package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

public class UserDaoImpl implements UserDao {
	private Connection connection;
	private PreparedStatement firstPst;

	public UserDaoImpl() throws SQLException {
		connection = openConnection();
		firstPst = connection.prepareStatement("select * from users where email=? and password=?");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		firstPst.setString(1, email);
		firstPst.setString(2, password);
		try (ResultSet rst = firstPst.executeQuery()) {
			if (rst.next()) {
				return new User();
			}
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (firstPst != null) {
			firstPst.close();
		}
		closeConnection();
	}
}
