package tester;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestPreparedStatement {

	public static void main(String[] args) {
		String sql = "select first_name,last_name,dob,status from users where role=? and dob between ? and ?";
		try (Scanner sc = new Scanner(System.in);
				// establish fixed cn to db
				Connection conn = openConnection();
				// create a populated PST from cn , to hold select query
				PreparedStatement pst = conn.prepareStatement(sql);) {
	//		while (true) {
				System.out.println("Enter role start date n end date(yr-mon-day)");
				// set IN params
				pst.setString(1, sc.next());// role
				pst.setDate(2, Date.valueOf(sc.next()));// start date
				pst.setDate(3, Date.valueOf(sc.next()));// end date
				try (ResultSet rst = pst.executeQuery()) {
					while (rst.next())
						System.out.println("first name " + rst.getString(1) + "last name " + rst.getString(2) + " Dob "
								+ rst.getDate(3) + " status " + rst.getBoolean(4));
				} // rst.close()
			}

	//	} // JVM : pst.close(), conn.close()
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
