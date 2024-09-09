import java.util.Scanner;

public class TestMyStack {
	public static void main(String[] args) {
		System.out.print("Enter the number of elements : ");
		try (Scanner scan = new Scanner(System.in)) {
			int size = scan.nextInt();
			MyStack stack = new MyStack(size);
			int choice = 0;
			do {
				System.out.println("--- Stack based operations ---");
				System.out.println("1. Display the stack.");
				System.out.println("2. Push the data on the stack.");
				System.out.println("3. Pop the data from the stack.");
				System.out.println("4. Check how many elements are there on the stack.");
				System.out.println("5. Check to see if the stack is full.");
				System.out.println("6. Check to see if stack is empty.");
				System.out.println("0. Exit.");
				System.out.println("Enter your choice : ");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					stack.display();
					break;
				case 2:
					System.out.println("Enter the element : ");
					stack.push(scan.nextInt());
					stack.display();
					break;
				case 3:
					System.out.println("Element removed : " + stack.pop());
					stack.display();
					break;
				case 4:
					System.out.println("The current size of the stack is : " + stack.size());
					break;
				case 5:
					System.out.println("Is full status : " + stack.isFull());
					break;
				case 6:
					System.out.println("Is empty status : " + stack.isEmpty());
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
