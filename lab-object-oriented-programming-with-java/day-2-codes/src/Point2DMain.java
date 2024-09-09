import java.util.Scanner;

public class Point2DMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x and y coordinates for 1st point : ");
		Point2D firstPoint = new Point2D(sc.nextFloat(),sc.nextFloat());
		System.out.println(firstPoint.show());
		System.out.println("Enter x and y coordinates for 2nd point : ");
		Point2D secondPoint = new Point2D(sc.nextFloat(),sc.nextFloat());
		System.out.println(secondPoint.show());
		// Checking Equality
		if (firstPoint.isEqual(secondPoint) == true)
			System.out.println("Both points are equal.");
		else
			System.out.println("Both points are not equal.");
		double distance = firstPoint.calculateDistance(secondPoint);
		System.out.println("Distance: " + distance);
		sc.close();
	}
}	