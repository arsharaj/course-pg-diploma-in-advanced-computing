package tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.User;

public class RegisterNewVoter {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter firstName,  lastName,  email,  password,  dob(yr-mon-day)");
			String mesg = dao
					.registerNewVoter(new User(sc.next(), 
							sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next())));
			System.out.println(mesg);
			// clean up
			dao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
