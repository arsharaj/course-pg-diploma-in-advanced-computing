package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;

	// add a method to open n ret a FIXED db cn
	public static Connection openConnection() throws /* ClassNotFoundException, */ SQLException {
		// optional : load JDBC driver class
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
		return cn;
	}
	// add a method to close DB connection
	public static void closeConnection() throws SQLException
	{
		if(cn != null)
			cn.close();
	}

}
