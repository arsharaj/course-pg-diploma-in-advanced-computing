package tester;

import static utils.DBUtils.openConnection;
import java.sql.*;

public class TestConnection {

	public static void main(String[] args) {
		try (Connection conn = openConnection()) {
			System.out.println("connected to DB : "+conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
