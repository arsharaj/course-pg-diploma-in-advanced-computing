package tester;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import custom.exceptions.LicenseExpiredException;
import custom.exceptions.SpeedOutOfRangeException;
import custom.exceptions.ValidationRules;

public class TestSpeed {
	private static final SimpleDateFormat newFormat;
	static {
		newFormat = new SimpleDateFormat("dd-MM-yyyy");
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the current speed : ");
			ValidationRules.validateSpeed(sc.nextInt());
			System.out.println("Enter driving license expiry date (dd-MM-yyyy) : ");
			Date expiryDate = newFormat.parse(sc.next());
			ValidationRules.validateExpiry(expiryDate);
			System.out.println("License Expiry Date : " + newFormat.format(expiryDate));
			System.out.println("End of try block.");
		} catch (SpeedOutOfRangeException e) {
			e.printStackTrace();
			System.out.println("End of Speed catch block.");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("End of Parsing catch block.");
		} catch (LicenseExpiredException e) {
			e.printStackTrace();
			System.out.println("End of License catch block.");
		}
		System.out.println("End of main block.");
	}
}
