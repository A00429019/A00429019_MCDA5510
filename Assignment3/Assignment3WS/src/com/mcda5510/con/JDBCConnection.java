package com.mcda5510.con;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	static Connection connection = null;
	private JDBCConnection() {
		
	}
	
	public static Connection getDBConnection() throws Exception {
			
		if(connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/r_gupta?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "r_gupta", "A00429019");
		}

		return connection;
	}
	
}
