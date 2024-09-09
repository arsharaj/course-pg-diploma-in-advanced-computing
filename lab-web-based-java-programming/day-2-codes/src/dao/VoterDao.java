package dao;

import java.sql.Date;
import java.sql.SQLException;

public interface VoterDao {
	String signUp(String firstName, String lastName, String email, String password, Date dob) throws SQLException;
}
