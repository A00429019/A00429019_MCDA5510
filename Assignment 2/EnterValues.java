import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnterValues {

	//INSERT
	public Transaction InsertValues() throws Exception {
		Transaction trxn = new Transaction();

		try {
		Scanner user_input = new Scanner(System.in);
		System.out.println("Please enter the values");
			System.out.println("ID");
			trxn.setID(user_input.nextInt());	//nextInt() does not allow user to enter empty string
			System.out.println("Name on Card");
			trxn.setNameOnCard(user_input.next());	//same for next()
			System.out.println("Card Number");
			trxn.setCardNumber(user_input.next());	//Therefore, all fields are required
			System.out.println("Unit Price");
			trxn.setUnitPrice(user_input.nextDouble());
			System.out.println("Quantity");
			trxn.setQty(user_input.nextInt());
			System.out.println("Total Price");
			trxn.setTotalPrice(user_input.nextDouble());
			System.out.println("Exp Date");
			trxn.setExpDate(user_input.next());
			
			return trxn;
			
		}
		
		catch (InputMismatchException e) {
			Logger.getLogger("Main").log(Level.INFO,"\nEnter a valid input for Inserting\n");
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nEnter a valid input for Inserting\n");
		}
		return trxn;
		
		}
	
	//REMOVE
	public Transaction removeValues() throws Exception {
		Transaction trxn = new Transaction();
		
		try {
		Scanner user_input = new Scanner(System.in);
		System.out.println("\nPlease enter ID of the row you want to delete\n");
		
			trxn.setID(user_input.nextInt());
		return trxn;
		}
		catch (InputMismatchException e) {
			Logger.getLogger("Main").log(Level.INFO,"\nPlease enter the correct ID to delete.\n");
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nPlease enter the correct ID to delete.\n");
			return null;
		}
		catch (Exception e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
		}
		return trxn;
	}
	
	
	//UPDATE
	public Transaction UpdateValues() throws Exception {
		Transaction trxn = new Transaction();
		
		try {
		Scanner user_input = new Scanner(System.in);
		System.out.println("\nPress y for the fields you want to update, otherwise N\n");
		
		System.out.println("ID");
		char a=user_input.next().charAt(0);
		if (a == 'y')
			trxn.setID(user_input.nextInt());
		
		System.out.println("Name on Card");
		a=user_input.next().charAt(0);
		if (a == 'y')
			trxn.setNameOnCard(user_input.next());
		
		System.out.println("Card Number");
		a=user_input.next().charAt(0);
		if (a == 'y')
			trxn.setCardNumber(user_input.next());
		
		System.out.println("Unit Price");
		a=user_input.next().charAt(0);
		if (a == 'y')
			trxn.setUnitPrice(user_input.nextDouble());
		
		System.out.println("Quantity");
		a=user_input.next().charAt(0);
		if (a == 'y')
			trxn.setQty(user_input.nextInt());

		System.out.println("Total Price");
		a=user_input.next().charAt(0);
		if (a == 'y')
			trxn.setTotalPrice(user_input.nextDouble());
		
		System.out.println("Exp Date");
		a=user_input.next().charAt(0);
		if (a == 'y')
			trxn.setExpDate(user_input.next());
		
		return trxn;
	}
		
		catch (InputMismatchException e) {
			Logger.getLogger("Main").log(Level.INFO,"\nEnter a valid input for updating\n");
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nEnter a valid input for updating\n");
		
		
		}
		catch (Exception e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
		}
		return trxn;
		
}
	//UPDATE WHERE CONDITION
	public Transaction UpdateWhere() throws Exception {
		Transaction trxn = new Transaction();
		try {
			Scanner user_input = new Scanner(System.in);
			System.out.println("\nEnter the ID of the row you want to update\n");
			String temp = user_input.next();
			int i = Integer.parseInt(temp);
			trxn.setID(i);

			
			return trxn;
	}
		catch (InputMismatchException e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nEnter a valid input for where condition\n");
		}
		catch (NumberFormatException e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
			System.out.println("\nEnter a valid input for where condition\n");
		}
		catch (Exception e) {
			Logger.getLogger("Main").log(Level.INFO,e.getMessage() + "\n");
		}

		return trxn;
}
}

