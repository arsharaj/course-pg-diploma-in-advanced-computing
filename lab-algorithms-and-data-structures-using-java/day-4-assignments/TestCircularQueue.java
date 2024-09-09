import java.util.Scanner;

public class TestCircularQueue {
	public static void main(String[] args) {
		System.out.print("Enter the number of elements : ");
		try (Scanner scan = new Scanner(System.in)) {
			int size = scan.nextInt();
			CircularQueue circularQueue = new CircularQueue(size);
			int choice = 0;
			do {
				System.out.println("--- Circular Queue based operations ---");
				System.out.println("1. Show the contents of circular queue.");
				System.out.println("2. Enqueue the data in the circular queue.");
				System.out.println("3. Access the data from the circular queue.");
				System.out.println("4. Check how many elements are there in the circular queue.");
				System.out.println("5. Check to see if the circular queue is full.");
				System.out.println("6. Check to see if circular queue is empty.");
				System.out.println("0. Exit.");
				System.out.println("Enter your choice : ");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					circularQueue.display();
					break;
				case 2:
					System.out.println("Enter the element : ");
					circularQueue.add(scan.nextInt());
					circularQueue.display();
					break;
				case 3:
					System.out.println("Element removed : " + circularQueue.remove());
					circularQueue.display();
					break;
				case 4:
					System.out.println("The current size of the circular queue is : " + circularQueue.size());
					break;
				case 5:
					System.out.println("Is full status : " + circularQueue.isFull());
					break;
				case 6:
					System.out.println("Is empty status : " + circularQueue.isEmpty());
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
