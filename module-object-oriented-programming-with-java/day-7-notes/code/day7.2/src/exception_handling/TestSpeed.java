package exception_handling;

import java.util.Scanner;

import custom_exceptions.SpeedOutOfRangeException;
import utils.VehicleValidationRules;
import static utils.VehicleValidationRules.validateSpeed;

public class TestSpeed {

	public static void main(String[] args) /* throws SpeedOutOfRangeException */ {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter curnt speed");
			// invoke a static method for speed validation.
			validateSpeed(sc.nextInt());
			System.out.println("end of try...");
		} // JVM : sc.close()
		catch (SpeedOutOfRangeException e) {
		//	System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("main cntd....");

	}

}
