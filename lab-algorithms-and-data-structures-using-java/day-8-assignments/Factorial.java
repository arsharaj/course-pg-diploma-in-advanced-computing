import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the number to find its factorial : ");
			int num = scan.nextInt();
			System.out.println("Factorial of " + num + " : " + findFactorial(num));
		}
	}

	private static int findFactorial(int num) {
		return findFactorialHelper(num, 1);
	}

	private static int findFactorialHelper(int num, int accumulator) {
		if (num == 0) {
			return accumulator;
		} else {
			return findFactorialHelper(num - 1, num * accumulator);
		}
	}

}
