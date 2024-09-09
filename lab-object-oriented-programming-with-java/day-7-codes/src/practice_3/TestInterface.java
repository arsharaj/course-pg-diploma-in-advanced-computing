package practice_3;

import java.util.Scanner;

// Here C interface is inheriting 2 interfaces A and B that have same method signature
// for sum method. Then we override the same method in our interface.

// We cannot implement method definition in interface.
// We have to implement it in our implementation class.

// To make this class concrete we have to implement all the methods
// in our implementation class.
public class TestInterface implements C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestInterface test = new TestInterface();
		// Here Multiple inheritance is working via interfaces.
		System.out.print("Enter two integers : ");
		System.out.println("Sum : " + test.sum(sc.nextInt(), sc.nextInt()));
		System.out.print("Enter two doubles : ");
		System.out.println("Sum : " + test.sum(sc.nextDouble(), sc.nextDouble()));
		sc.close();
	}

	@Override
	public double sum(double d1, double d2) {
		return d1 + d2;
	}

	@Override
	public int sum(double d1, double d2) {
		return d1 + d2;
	}
}
