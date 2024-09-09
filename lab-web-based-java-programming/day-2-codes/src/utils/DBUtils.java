package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	
	public static Connection openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
		System.out.println("Connection setup successfully.");
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		System.out.println("Connection closed successfully.");
	}
}
