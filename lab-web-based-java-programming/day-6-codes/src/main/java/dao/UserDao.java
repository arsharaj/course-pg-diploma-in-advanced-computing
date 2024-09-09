package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.User;

public interface UserDao {
	// add a method to authenticate user
	User authenticateUser(String email, String pwd) throws SQLException;
}
