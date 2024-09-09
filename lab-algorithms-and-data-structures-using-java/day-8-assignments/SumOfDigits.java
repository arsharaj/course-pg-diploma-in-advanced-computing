import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter a number to find digit sum : ");
			int num = scan.nextInt();
			System.out.println("Sum of digits : " + findDigitsSum(num));
		}
	}

	private static int findDigitsSum(int num) {
		if (num / 10 == 0) {
			return num;
		} else {
			return (num % 10) + findDigitsSum(num / 10);
		}
	}

}
