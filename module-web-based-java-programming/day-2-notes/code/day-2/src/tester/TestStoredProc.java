package tester;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.BankAccountDaoImpl;
import dao.UserDaoImpl;
import pojos.User;

public class TestStoredProc {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			BankAccountDaoImpl dao=new BankAccountDaoImpl();
			System.out.println("Enter src a/c dest a/c nos n amount");
			System.out.println(dao.transferFunds
					(sc.nextInt(), sc.nextInt(),sc.nextDouble()));
			// clean up
			dao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
