import java.util.Scanner;

public class TestSimpleLinkedList {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			SimpleLinkedList simpleLinkedList = new SimpleLinkedList();
			int choice = 0;
			do {
				System.out.println("--- Simple Linked List based operations ---");
				System.out.println("1. Show the contents of linked list.");
				System.out.println("2. Insert the data at the beginning of linked list.");
				System.out.println("3. Insert the data at the end of linked list.");
				System.out.println("4. Insert the data at a specific position in linked list.");
				System.out.println("5. Check how many elements are there in the linked list.");
				System.out.println("6. Check to see if linked list is empty.");
				System.out.println("7. Delete the data at the beginning of linked list.");
				System.out.println("8. Delete the data at the end of linked list.");
				System.out.println("9. Delete the data at a specific position in linked list.");
				System.out.println("0. Exit.");
				System.out.println("Enter your choice : ");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					simpleLinkedList.display();
					break;
				case 2:
					System.out.println("Enter the element : ");
					simpleLinkedList.addAtBegin(scan.nextInt());
					simpleLinkedList.display();
					break;
				case 3:
					System.out.println("Enter the element : ");
					simpleLinkedList.addAtEnd(scan.nextInt());
					simpleLinkedList.display();
					break;
				case 4:
					System.out.println("Enter the element and position : ");
					simpleLinkedList.addAtSpecificPosition(scan.nextInt(), scan.nextInt());
					simpleLinkedList.display();
					break;
				case 5:
					System.out.println("The current size of the circular queue is : " + simpleLinkedList.size());
					break;
				case 6:
					System.out.println("Is empty status : " + simpleLinkedList.isEmpty());
					break;
				case 7:
					System.out.println("Element removed : " + simpleLinkedList.deleteAtBegin());
					simpleLinkedList.display();
					break;
				case 8:
					System.out.println("Element removed : " + simpleLinkedList.deleteAtEnd());
					simpleLinkedList.display();
					break;
				case 9:
					System.out.println("Enter the position of the element to be removed : ");
					System.out
							.println("Element removed : " + simpleLinkedList.deleteAtSpecificPosition(scan.nextInt()));
					simpleLinkedList.display();
					break;
				case 0:
					System.out.println("Thank you for using our services.");
					break;
				default:
					System.out.println("Enter a valid choice.");
					break;
				}
			} while (choice != 0);
		}
	}
}
