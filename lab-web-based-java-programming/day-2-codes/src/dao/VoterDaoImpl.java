package dao;

import java.sql.*;
import static utils.DBUtils.*;


public class VoterDaoImpl implements VoterDao {
	private Connection connection;
	private PreparedStatement signUpPreparedStatement;
	
	public VoterDaoImpl() throws SQLException {
		connection = openConnection();
		//  id, first_name, last_name, email, password, dob, status, role
		signUpPreparedStatement = connection.prepareStatement("insert into users values (default, ?, ?, ?, ?, ?, 0, 'voter')");
	}

	@Override
	public String signUp(String firstName, String lastName, String email, String password, Date dob)
			throws SQLException {
		//	first_name, last_name, email, password, dob
		signUpPreparedStatement.setString(1, firstName);
		signUpPreparedStatement.setString(2, lastName);
		signUpPreparedStatement.setString(3, email);
		signUpPreparedStatement.setString(4, password);
		signUpPreparedStatement.setDate(5, dob);
		int affectedRows = signUpPreparedStatement.executeUpdate();
		System.out.println("Affected Rows : " + affectedRows);
		if (affectedRows != 0) {
			return "User has been successfully registered.";
		} else {
			return "User has not been registered.";
		}
	}
	
	public void cleanUp() throws SQLException {
		if (signUpPreparedStatement != null) {
			signUpPreparedStatement.close();
		}
		closeConnection();
	}
}
