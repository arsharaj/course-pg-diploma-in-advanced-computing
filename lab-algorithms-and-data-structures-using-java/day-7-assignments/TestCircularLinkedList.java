import java.util.Scanner;

public class TestCircularLinkedList {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int choice = 0;
			CircularLinkedList circularLinkedList = new CircularLinkedList();
			do {
				try {
					System.out.println("--- Circular Linked List Operations ---");
					System.out.println("1. Show the contents of circular linked list.");
					System.out.println("2. Insert the data in the circular linked list.");
					System.out.println("3. Check how many elements are there in the circular linked list.");
					System.out.println("4. Check to see if circular linked list is empty.");
					System.out.println("0. Exit.");
					System.out.println("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						circularLinkedList.display();
						break;
					case 2:
						System.out.println("Enter the data : ");
						circularLinkedList.insertAtBegin(scan.nextInt());
						circularLinkedList.display();
						break;
					case 3:
						System.out.println("No of elements in the circular linked list : " + circularLinkedList.size());
						break;
					case 4:
						System.out.println("Is empty status : " + circularLinkedList.isEmpty());
						break;
					case 0:
						System.out.println("Thank you for using our services.");
						break;
					default:
						System.out.println("Enter a valid choice!");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (choice != 0);
		}
	}

}
