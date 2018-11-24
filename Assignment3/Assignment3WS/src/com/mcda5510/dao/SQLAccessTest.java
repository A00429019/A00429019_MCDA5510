package com.mcda5510.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import com.mcda5510.entity.*;
	
	import com.mcda5510.con.JDBCConnection;
	public class SQLAccessTest {
		
		
		//INSERT
		public static String insert(Transaction trxn) throws Exception {
			
			try {
			Connection connection = JDBCConnection.getDBConnection();
			
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new java.util.Date());
			
			Pattern ptrn = Pattern.compile("^([0-9]{2})/([0-9]{4})");
			Matcher m = ptrn.matcher(trxn.getExpDate());
			
			if(trxn.getCardNumber().matches("^((?![;:!@#$%^*+?<>]).)*$") && trxn.getNameOnCard().matches("^((?![;:!@#$%^*+?<>]).)*$") && trxn.getExpDate().matches("^((?![;:!@#$%^*+?<>]).)*$")) {
			
				if(m.find() && Integer.parseInt(m.group(2)) > 2015 && Integer.parseInt(m.group(2)) < 2032 && Integer.parseInt(m.group(1)) > 0 && Integer.parseInt(m.group(1)) < 13) {
				
				PreparedStatement statement = connection.prepareStatement("insert into transaction (ID, NameOnCard, CardNumber, UnitPrice, Quantity, TotalPrice, ExpDate, CreatedOn, CreatedBy, CreditCardType) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
				
				statement.setInt(1, trxn.getID());
				statement.setString(2, trxn.getNameOnCard());
				statement.setString(3, trxn.getCardNumber());
				statement.setDouble(4, trxn.getUnitPrice());
				statement.setInt(5, trxn.getQty());
				statement.setDouble(6, trxn.getTotalPrice());
				statement.setString(7, trxn.getExpDate());
				statement.setString(8, timeStamp);
				statement.setString(9, System.getProperty("user.name"));
				
				if (trxn.getCardNumber().startsWith("4") && trxn.getCardNumber().matches("[0-9]{16}")) 
					statement.setString(10, "Visa");
				
				else if (trxn.getCardNumber().matches("^[51-55]{2}.*$") && trxn.getCardNumber().matches("[0-9]{16}")) 
					statement.setString(10, "MasterCard");
				
				else if ((trxn.getCardNumber().startsWith("34") || trxn.getCardNumber().startsWith("37")) && trxn.getCardNumber().matches("[0-9]{15}") ) 
					statement.setString(10, "American Express");
				
				else statement.setString(10, "Your card is invalid");			
					
				
				if (statement.executeUpdate() > 0) {
					System.out.println("\nSUCCESS. A new row has been inserted successfully\n");
					return "\nSUCCESS. A new row has been inserted successfully\n";}
				
				else {
					Logger.getLogger("Main").log(Level.INFO,"\nThere was an error. Please try again\n");
					System.out.println("\nThere was an error. Please try again\n");
					return "\nThere was an error. Please try again\n";
				}
			}
				else {
					Logger.getLogger("Main").log(Level.INFO,"\nPlease enter the correct format for Exp Date.\n");
					System.out.println("\nPlease enter the correct format for Exp Date.\n");
					return "\nPlease enter the correct format for Exp Date.\n";
				}
			}
			
			else {
				Logger.getLogger("Main").log(Level.INFO,"\nSpecial characters are not allowed in the varchars\n");
				System.out.println("\nSpecial characters are not allowed in the varchars\n");
				return "\nSpecial characters are not allowed in the varchars\n";
			}
				
			}
			
			
			catch (SQLIntegrityConstraintViolationException e) {
				Logger.getLogger("Main").log(Level.INFO,"\nThe row with the same ID exits. Try using the update query\n");
				Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
				e.printStackTrace();
//				System.out.println("\nThe row with the same ID exits. Try using the update query\n");
			}
			catch (IllegalStateException e) {
				Logger.getLogger("Main").log(Level.INFO,"\nThe format of Exp Date is not correct.\n");
				Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
				System.out.println("\nThe format of Exp Date is not correct.\n");
				return "\nThe format of Exp Date is not correct.\n";
			}
		catch (SQLException e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
		}
			catch (NullPointerException e) {
				Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
				return "Null Pointer Exception";
			}
			return null;
	}
		
	
	
	//SELECT
	public static String getAllTransactions() throws Exception {
		
		Connection connection = JDBCConnection.getDBConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<Transaction> results = null;
		String reslt = "";
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from transaction");
			results = createTrxns(resultSet);
	
			if (resultSet != null) {
				resultSet.close();
			}
	
			if (statement != null) {
				statement.close();
			}
			
			for (Transaction trxn : results) {
				reslt = reslt+trxn.toString()+"\n";
			}
	
		} catch (SQLException e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
		} finally {
			statement = null;
			resultSet = null;
		}
		
		return reslt;
	
	}
	
	
	private static Collection<Transaction> createTrxns(ResultSet resultSet) throws SQLException {
		Collection<Transaction> results = new ArrayList<Transaction>();
	
	
		while (resultSet.next()) {
	
			Transaction trxn = new Transaction();
			trxn.setID(resultSet.getInt("ID"));
			trxn.setNameOnCard(resultSet.getString("NameOnCard"));
			trxn.setCardNumber(resultSet.getString("CardNumber"));
			trxn.setUnitPrice(resultSet.getDouble("UnitPrice"));
			trxn.setQty(resultSet.getInt("Quantity"));
			trxn.setTotalPrice(resultSet.getDouble("TotalPrice"));
			trxn.setExpDate(resultSet.getString("ExpDate"));
			trxn.setCreatedOn(resultSet.getString("CreatedOn"));
			trxn.setCreatedBy(resultSet.getString("CreatedBy"));
			trxn.setCreditCardType(resultSet.getString("CreditCardType"));
			results.add(trxn);
		}
		return results;
	}
	
	
	//DELETE
	public static String remove(Transaction trxn) {
		try {
			Connection connection = JDBCConnection.getDBConnection();
			
			PreparedStatement statement = connection.prepareStatement("delete from transaction where ID = ?");
			statement.setInt(1, trxn.getID());
			if (statement.executeUpdate() > 0) {
				
				System.out.println("\nA row has been deleted successfully\n");
				return "\nA row has been deleted successfully\n";
			}
			else {
				System.out.println("\nPlease enter the correct ID\n");
				return "\nPlease enter the correct ID\n";
			}
			
		}
		
		catch(NullPointerException e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nID needs to be entered\n");
			return "ID needs to be entered";
		}
		catch(NumberFormatException e) {
			System.out.println("\nOnly integers are allowed in ID\n");
			return "Only integers are allowed in ID";
		}
		catch (Exception e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			return e.getMessage();
		}
	}
	
	public static String update(Transaction trxn) throws Exception {
		try {
		Connection connection = JDBCConnection.getDBConnection();
		String UpdateString = "update transaction set ";
		if(trxn.getNameOnCard() != null) {
			UpdateString += "NameOnCard = '" + trxn.getNameOnCard() + "', ";
		}
		
		if(trxn.getCardNumber() != null) {
			UpdateString += "CardNumber = '" + trxn.getCardNumber() + "', ";
			Pattern ptrn = Pattern.compile("(CardNumber).*([=])\\s[']([0-9]{1,})");
			Matcher m = ptrn.matcher(UpdateString);
			
			if(m.find()) {
			
			if (m.group(3).startsWith("4") && m.group(3).matches("[0-9]{16}"))
				UpdateString += "CreditCardType = 'Visa', ";
			
			else if (m.group(3).matches("^[51-55]{2}.*$") && m.group(3).matches("[0-9]{16}"))
				UpdateString += "CreditCardType = 'MasterCard', ";
			
			else if ((m.group(3).startsWith("34") || m.group(3).startsWith("37")) && m.group(3).matches("[0-9]{15}"))
					UpdateString += "CreditCardType = 'AmericanExpress', ";
			
			else
				UpdateString += "CreditCardType = 'The card type is invalid', ";
		}
		}
		
		if(trxn.getUnitPrice() != null) {
			UpdateString += "UnitPrice = '" + trxn.getUnitPrice() + "', ";
		}
		
		if(trxn.getQty() != null) {
			UpdateString += "Quantity = '" + trxn.getQty() + "', ";
		}
		
		if(trxn.getTotalPrice() != null) {
			UpdateString += "TotalPrice = '" + trxn.getTotalPrice() + "', ";
		}
		
		if(trxn.getExpDate() != null) {
			UpdateString += "ExpDate = '" + trxn.getExpDate() + "', ";
		}
		
		UpdateString = UpdateString.substring(0, UpdateString.length()-2);
		UpdateString = UpdateString + " where ID = " + trxn.getID() + ";";
		
		PreparedStatement statement = connection.prepareStatement(UpdateString);
		if (statement.executeUpdate() > 0) {
			System.out.println("\nSUCCESS. A row has been updated successfully\n");
			return "SUCCESS. A row has been updated successfully";
		}
		else {
			System.out.println("\nThe record was not updated. Try using Create.\n");
			return "The record was not updated. Try using Create.";
			
		}
		}
		catch (SQLSyntaxErrorException e) {
			Logger.getLogger("Main").log(Level.INFO,"\nSyntax invalid\n");
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nSyntax invalid\n");
			return "Syntax invalid";
		}
		catch (IllegalStateException e) {
			Logger.getLogger("Main").log(Level.INFO,"\nPlease enter a valid format for Exp Date.\n");
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nPlease enter a valid format for Exp Date.\n");
			return "Please enter a valid format for Exp Date.";
		}
		
		catch (NullPointerException e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			return "Null pointer exception";
		}
		catch (SQLException e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			return e.getMessage();
			
		}
	}
	}