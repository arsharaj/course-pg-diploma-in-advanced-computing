package date_handling;

import java.time.LocalDate;
import java.util.Scanner;

public class TestLocalDate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create today's date
			LocalDate today = LocalDate.now();
			System.out.println(today);
			// accept date from user :string
			System.out.println("Enter manu. date of the vehicle : yyyy-MM-dd");
			LocalDate manufactureDate = LocalDate.parse(sc.next());
			System.out.println("Manu date : " + manufactureDate);// toString : LocalDate
			//compare :
			System.out.println(today.isBefore(manufactureDate));
			System.out.println(today.compareTo(manufactureDate));			
		} // sc.close()

	}

}
