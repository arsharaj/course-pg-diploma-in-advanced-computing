package tester;

import java.util.Scanner;

import data_structure.MySinglyLinkedListImpl;

public class TestSortedLinkedList {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			MySinglyLinkedListImpl myList = new MySinglyLinkedListImpl();
			int choice = 0;
			do {
				try {
					System.out.println("--- Custom Sorted Linked List ---");
					System.out.println("1. Add element X such that list remain sorted.");
					System.out.println("2. Add given list of X to the current list such that list remain sorted.");
					System.out.println("3. Remove element present at index i");
					System.out.println("4. Returns comman seperated elements from start to end");
					System.out.println("0. Exit");
					System.out.print("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter the element : ");
						int element = scan.nextInt();
						myList.add(element);
						System.out.println("Element successfully Added.");
						break;
					case 2:
						
						break;
					case 3:
						
						break;
					case 4:
						System.out.println(myList);
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
