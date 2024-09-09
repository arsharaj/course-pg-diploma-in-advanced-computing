import java.util.Scanner;

public class TestArray {

	public static void main(String[] args) {
		System.out.print("Enter the number of elements : ");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		Array array = new Array(size);
		int choice = 0;
		do {
			System.out.println("--- Array based operations ---");
			System.out.println("1. Display the array.");
			System.out.println("2. Reverse the array.");
			System.out.println("3. Replace the nth element from the array and print.");
			System.out.println("4. Find the addition of all elements of the array.");
			System.out.println("5. Find the maximum number from the array.");
			System.out.println("6. Print the average of all the elements from the array.");
			System.out.println("7. Display the even and odd number from the array separately.");
			System.out.println("0. Exit.");
			System.out.println("Enter your choice : ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				array.display();
				break;
			case 2:
				array.reverse();
				break;
			case 3:
				array.replaceNth(scan);
				break;
			case 4:
				System.out.println("The sum of all the elements in the array is : " + array.findSum());
				break;
			case 5:
				System.out.println("The maximum element in the array is : " + array.findMax());
				break;
			case 6:
				System.out.println("The average of all the elements in the array is : " + array.findAverage());
				break;
			case 7:
				array.displayEven();
				array.displayOdd();
				break;
			case 0:
				System.out.println("Thank you for using our services.");
				break;
			default:
				System.out.println("Enter a valid choice.");
				break;
			}
		} while (choice != 0);
		scan.close();
	}
}
