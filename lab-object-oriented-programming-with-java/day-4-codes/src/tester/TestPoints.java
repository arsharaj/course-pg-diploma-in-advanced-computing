package tester;

import java.util.Scanner;

import core.Point2D;

public class TestPoints {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of points : ");
		Point2D[] points = new Point2D[sc.nextInt()];
		int choice = 0;
		do {
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter index : ");
				int index = sc.nextInt();
				if (index < points.length && index >= 0) {
					if (points[index] == null) {
						System.out.println("Enter x and y : ");
						points[index] = new Point2D(sc.nextFloat(), sc.nextFloat());
						System.out.println("Inserting point.");
					} else {
						System.out.println("Point is already present.");
					}
				} else {
					System.out.println("Index out of bound.");
				}
				break;
			case 2:
				int i = 0;
				System.out.println("All the points are : ");
				for (Point2D point : points) {
					if (point == null) {
						System.out.println("Point " + i + " : ");
					} else {
						System.out.println("Point " + i + " : " + point.show());
					}
					i++;
				}
				break;
			case 3:
				System.out.println("Enter first index : ");
				int firstIndex = sc.nextInt();
				System.out.println("Enter second index : ");
				int secondIndex = sc.nextInt();
				if (points[firstIndex] == null || points[secondIndex] == null) {
					System.out.println("Cannot compare null values.");
				} else {
					if (points[firstIndex].isEqual(points[secondIndex]) == true) {
						System.out.println("Both the points are equal.");
					} else {
						System.out.println("Both the points are not equal.");
						System.out.println("Distance between them is : "
								+ points[firstIndex].calculateDistance(points[secondIndex]));
					}
				}

				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid choice!");
				break;
			}
		} while (choice != 4);
		sc.close();
	}
}
