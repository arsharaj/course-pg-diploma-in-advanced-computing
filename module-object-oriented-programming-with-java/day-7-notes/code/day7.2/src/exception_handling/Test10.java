package exception_handling;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		// Create Scanner instance : using try-with-resources
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter numerator n denominator ");
			System.out.println("Div " + (sc.nextInt() / sc.nextInt()));
			Thread.sleep(2000);
			System.out.println("end of try..");
		} // JVM calls sc.close()
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("main over....");

	}

}
