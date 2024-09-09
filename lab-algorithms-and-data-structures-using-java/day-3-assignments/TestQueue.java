import java.util.Scanner;

public class TestQueue {
	public static void main(String[] args) {
		System.out.print("Enter the number of elements : ");
		try (Scanner scan = new Scanner(System.in)) {
			int size = scan.nextInt();
			Queue queue = new Queue(size);
			int choice = 0;
			do {
				System.out.println("--- Queue based operations ---");
				System.out.println("1. Show the queue.");
				System.out.println("2. Store the data in the queue.");
				System.out.println("3. Access the data from the queue.");
				System.out.println("4. Check how many elements are there in the queue.");
				System.out.println("5. Check to see if the queue is full.");
				System.out.println("6. Check to see if queue is empty.");
				System.out.println("0. Exit.");
				System.out.println("Enter your choice : ");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					queue.display();
					break;
				case 2:
					System.out.println("Enter the element : ");
					queue.add(scan.nextInt());
					queue.display();
					break;
				case 3:
					System.out.println("Element removed : " + queue.remove());
					queue.display();
					break;
				case 4:
					System.out.println("The current size of the queue is : " + queue.size());
					break;
				case 5:
					System.out.println("Is full status : " + queue.isFull());
					break;
				case 6:
					System.out.println("Is empty status : " + queue.isEmpty());
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
