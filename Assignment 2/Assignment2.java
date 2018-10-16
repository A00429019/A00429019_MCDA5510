import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment2 {

	public static void main(String[] args) throws Exception {

		System.setProperty("java.util.logging.config.file", "./logging.properties");
		MySQLAccess dao = new MySQLAccess();
		try {
			int i;
			Connection connection = dao.setupConnection();
			Scanner user_input = new Scanner(System.in);

			Boolean exit = false;

			do {

				System.out.println("----------------------------------------\n"
						+ "Press:\n1 for SELECT\n2 for INSERT\n3 for UPDATE\n4 for REMOVE\n5 for EXIT");
				i = Integer.parseInt(user_input.next());
				switch (i) {
				case 1:
					Collection<Transaction> trxns = dao.getAllTransactions(connection);

					for (Transaction trxn : trxns) {
						System.out.println(trxn.toString());
					}
					break;

				case 2:
					dao.insertTrxns(connection);
					break;

				case 3:
					dao.updateTrxns(connection);
					break;

				case 4:
					dao.removeTrxns(connection);
					break;

				case 5:
					System.out.println("Transaction ended!");
					exit = true;
					break;

				default:
					System.out.println("Please enter a valid input");
					break;

				}
			} while (!exit);

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			Logger.getLogger("Main").log(Level.INFO, e.getMessage() + "\n");
		} catch (Exception e) {
			Logger.getLogger("Main").log(Level.INFO, e.getMessage() + "\n");
		}

	}
}
