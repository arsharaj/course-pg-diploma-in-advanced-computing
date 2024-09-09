package tester;

import java.util.ArrayList;
import java.util.Scanner;

import core.Statement;
import utils.Utils;

public class TestBankAccount {

	public static ArrayList<Statement> statements = new ArrayList<>();

	public static void main(String[] args) {
		Utils.restore("Jan2023.txt", statements);
		try (Scanner scan = new Scanner(System.in)) {
			int choice = 0;
			do {
				try {
					System.out.println("--- Bank Account Statement Menu ---");
					System.out.println("0. Exit");
					System.out.println("1. Sum of all deposits");
					System.out.println("2. Max deposit amount");
					System.out.println("3. Shopping expenses (sum of withdrawals for shopping)");
					System.out.println("4. Date on which maximum amount withdrawn");
					System.out.println("5. Display all transactions");
					System.out.println("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Sum of all deposits : " + Utils.sumOfAllDeposits(statements));
						break;
					case 2:
						System.out.println("Max deposited amount : " + Utils.maxDepositedAmount(statements));
						break;
					case 3:
						System.out.println("Shopping expenses : " + Utils.sumOfShoppingWithdrawls(statements));
						break;
					case 4:
						System.out.println("Date of max withdrawal : " + Utils.getDateForMaxShopping(statements));
						break;
					case 5:
						Utils.displayAllTransactions(statements);
						break;
					case 0:
						System.out.println("Thank you for using our services.");
						break;
					default:
						System.out.println("Enter a valid choice !");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (choice != 0);
		}
	}
}
