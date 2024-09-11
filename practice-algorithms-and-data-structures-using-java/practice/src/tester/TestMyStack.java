package tester;

import java.util.Scanner;

import data_structure.MyStackImpl;

public class TestMyStack {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the size of the stack : ");
			int size = scan.nextInt();
			MyStackImpl myStack = new MyStackImpl(size);
			int choice = 0;
			do {
				try {
					System.out.println("--- Stack based operations ---");
					System.out.println("1. Push the element on the stack");
					System.out.println("2. Remove the element from the top of the stack");
					System.out.println("3. Get the top element");
					System.out.println("4. Retrieve the maximum element in the stack");
					System.out.println("0. Exit");
					System.out.print("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter the element : ");
						int element = scan.nextInt();
						myStack.push(element);
						break;
					case 2:
						System.out.println("Element popped from stack : " + myStack.pop());
						break;
					case 3:
						System.out.println("Top element : " + myStack.top());
						break;
					case 4:
						System.out.println("Max element :" + myStack.getMax());
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
