import java.util.Scanner;

public class SquareOfNumber {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter a number to find its square : ");
			int num = scan.nextInt();
			System.out.println("Sqaure of " + num + " : " + findSquare(num));
		}
	}

	private static int findSquare(int num) {
		return findSquarehelper(num, num);
	}

	private static int findSquarehelper(int num, int counter) {
		if (counter == 1) {
			return num;
		} else {
			return num + findSquarehelper(num, counter - 1);
		}
	}

}
