import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Enter the string to check if it is palindrome or not : ");
			String string = scan.next();
			if (isPalindrome(string)) {
				System.out.println(string + " is palindrome.");
			} else {
				System.out.println(string + " is not palindrome.");
			}
		}
	}

	private static boolean isPalindrome(String string) {
		return string.equals(findReverse(string));
	}

	private static String findReverse(String string) {
		if (string.length() == 1) {
			return string;
		} else {
			return findReverse(string.substring(1)) + string.charAt(0);
		}
	}

}
