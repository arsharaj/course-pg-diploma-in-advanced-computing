package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {
	// state (fields)
	private Connection connection;
	private PreparedStatement pst1;

	// def ctor
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		connection = getCn();
		pst1 = connection.prepareStatement("select * from users where email=? and password=?");
		System.out.println("user dao created!");
	}

	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		// exec query : execQuery() --> RST --> next
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				// int userId, String firstName, String lastName, String email, Date dob,
				// boolean votingStatus,
				// String role
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, rst.getDate(6),
						rst.getBoolean(7),rst.getString(8));
		}
		return null;
	}
	
	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("user dao cleaned up !");
	}
}
