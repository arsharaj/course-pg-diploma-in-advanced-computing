package tester;

import shapes.*;

public class TestAbstractClass {

	public static void main(String[] args) {
		// add sample data (dyn init of array) in a single java statement
		BoundedShape[] shapes = { new Circle(10, 20, 15.6),
				new Rectangle(20, 40, 10, 2.56),
				new Circle(16, 27, 18.6)
				};//how many objs : 4 (1 : array , circles n rect)
		//use a for-each loop to display details (toString) n area
		for(BoundedShape s : shapes)
		{
			System.out.println(s); //s.toString
			System.out.println("Area "+s.area());
		}
			

	}

}
