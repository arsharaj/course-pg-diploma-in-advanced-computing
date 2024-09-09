package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.VoterDaoImpl;

public class TestVoterRegistration {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			// Initialization phase
			VoterDaoImpl dao = new VoterDaoImpl();
			
			// Servicing phase
			System.out.println("Enter voter details : (first_name, last_name, email, password, dob)");
			dao.signUp(scan.next(), scan.next(), scan.next(), scan.next(), Date.valueOf(scan.next()));
			
			// Cleanup phase
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
