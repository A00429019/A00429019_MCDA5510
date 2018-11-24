package com.mcda5510.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mcda5510.dao.SQLAccessTest;
import com.mcda5510.entity.Transaction;

public class Assignment3Service {
	

	public static String insertTrxns(int ID, String NameOnCard, String CardNumber, double UnitPrice, int Qty, double TotalPrice, String ExpDate) throws Exception {
		
		try {
		System.setProperty("java.util.logging.config.file", "./logging.properties");
		Transaction trxn = new Transaction();
		
		trxn.setID(ID);	//nextInt() does not allow user to enter empty string
		trxn.setNameOnCard(NameOnCard);	//same for next()
		trxn.setCardNumber(CardNumber);	//Therefore, all fields are required
		trxn.setUnitPrice(UnitPrice);
		trxn.setQty(Qty);
		trxn.setTotalPrice(TotalPrice);
		trxn.setExpDate(ExpDate);
		
		String pass = SQLAccessTest.insert(trxn);
		return pass;
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
}
	
	public static String selectTrxns() throws Exception {
		
		System.setProperty("java.util.logging.config.file", "./logging.properties");
		return SQLAccessTest.getAllTransactions();
		
	}
	
	
	//REMOVE
	public static String removeTrxns(String ID) throws Exception {
		System.setProperty("java.util.logging.config.file", "./logging.properties");
		Transaction trxn = new Transaction();
		
		if(ID != null) {
			if(ID.matches("([0-9])+")) {
				int a = Integer.parseInt(ID);
				trxn.setID(a);
			}
			else {
				System.out.println("Only integers are allowed");
				return "Only integers are allowed";
			}
		}
		else {
			return "An ID needs to be entered";
		}
		String pass = SQLAccessTest.remove(trxn);
		return pass;
	}
	
	
	//UPDATE
	public static String updateTrxns(String ID, String NameOnCard, String CardNumber, String UnitPrice, String Qty, String TotalPrice, String ExpDate) throws Exception {
		
		System.setProperty("java.util.logging.config.file", "./logging.properties");
		Transaction trxn = new Transaction();
		
		if (ID != null) {
			if(ID.matches("([0-9])+") ) {
				int a = Integer.parseInt(ID);
				trxn.setID(a);
			}
			else {
				System.out.println("\nID only takes integers\n");
				return "ID only takes integers";
		}

		if(NameOnCard != null) {
			if (NameOnCard.matches("^((?![;:!@#$%^*+?<>]).)*$")) 
				trxn.setNameOnCard(NameOnCard);
			else {
				System.out.println("\nSpecial characters are not allowed in the NameOnCard\n");
				return "Special characters are not allowed in the NameOnCard";
		}
			
		}
		if(CardNumber != null) {
			if(CardNumber.matches("^((?![;:!@#$%^*+?<>]).)*$")) {
				trxn.setCardNumber(CardNumber);
			}
			else {
				System.out.println("\nSpecial characters are not allowed in the CardNumber\n");
				return "Special characters are not allowed in the CardNumber";
			}
		}
		if(UnitPrice != null) {
			if(UnitPrice.matches("([0-9])+")) {
				double x = Double.parseDouble(UnitPrice);
				trxn.setUnitPrice(x);
			}
			else {
				System.out.println("\nUnit Price only accepts integers\n");
				return "Unit Price only accepts integers";
			}
		}
		if(Qty != null) {
			if(Qty.matches("([0-9])+")) {
				int y = Integer.parseInt(Qty);
				trxn.setQty(y);
			}
			else {
				System.out.println("\nQuantity only accepts integers\n");
				return "Quantity only accepts integers";
			}
		}
		
		if(TotalPrice != null) {
			if(TotalPrice.matches("([0-9])+")) {
				double z = Double.parseDouble(TotalPrice);
				trxn.setTotalPrice(z);
			}
			else {
				System.out.println("\nTotalPrice only accepts integers\n");
				return "TotalPrice only accepts integers";
			}
		}
		if(ExpDate != null) {
			Pattern pattern = Pattern.compile("^([0-9]{2})/([0-9]{4})");
			Matcher matcher = pattern.matcher(ExpDate);
			if(matcher.find() && ExpDate.matches("^((?![;:!@#$%^*+?<>]).)*$") && Integer.parseInt(matcher.group(2)) > 2015 && Integer.parseInt(matcher.group(2)) < 2032 && Integer.parseInt(matcher.group(1)) > 0 && Integer.parseInt(matcher.group(1)) < 13) {
				trxn.setExpDate(ExpDate);
			}
			else {
				System.out.println("\nSpecial characters are not allowed in the ExpDate or you entered the incorrect range\n");
				return "Special characters are not allowed in the ExpDate or you entered the incorrect range";
			}
		}
		}
		
		else
			return "ID cannot be empty";
		
		String returnstmt = SQLAccessTest.update(trxn);
		return returnstmt;
	
	}
	
}

