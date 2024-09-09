package tester;

import java.util.Scanner;
import customer_stack.*;

public class TestStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stack = null;
		int choice = 0;
		boolean flag = false;
		do {
			System.out.println("1. Choose Fixed Stack");
			System.out.println("2. Choose Growable Stack");
			System.out.println("3. Push data");
			System.out.println("4. Pop data & display the same");
			System.out.println("5. Exit");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					if (flag == true) {
						System.out.println("Stack already chosen.");
					} else {
						stack = new FixedStack();
						flag = true;
					}
					break;
				case 2:
					if (flag == false) {
						System.out.println("Stack already chosen.");
					} else {
						stack = new GrowableStack();
						flag = true;
					}
					break;
				case 3:
					if (flag == false) {
						System.out.println("No Stack chosen.");
					} else {
						System.out.println("Enter the customer details : ");
						Customer customer = new Customer(sc.nextInt(), sc.next(), sc.next());
						if (stack instanceof FixedStack) {
							stack.push(customer);
						} else if (stack instanceof GrowableStack) {
							stack.push(customer);
						} else {
							System.out.println("No Stack chosen...");
						}
					}
					break;
				case 4:
					if (flag == false) {
						System.out.println("No Stack chosen.");
					} else {
						if (stack instanceof FixedStack) {
							System.out.println("Enter customer details : ");
							System.out.println(stack.pop());
						} else if (stack instanceof GrowableStack) {
							System.out.println("Enter customer details : ");
							System.out.println(stack.pop());
						} else {
							System.out.println("No Stack chosen...");
						}
					}
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid choice.");
			}
		} while (choice != 5);
		sc.close();
	}

}
