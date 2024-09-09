package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;

import core.Customer;

public interface IoUtils {
	public static void store(HashMap<String, Customer> customerMap) {
		try (PrintWriter pw = new PrintWriter(new FileWriter("Date.txt"))) {
			customerMap.forEach((email, customer) -> pw.print(customer.storeString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End of Store");
	}

	public static void restore(HashMap<String, Customer> customerMap) {
		// First store it in a CSV file and then retrieve it via attaching Scanner with
		// a delimiter.
//		try (Scanner scan = new Scanner(new BufferedReader(new FileReader("Date.txt"))).useDelimiter(",")) {
//			while (scan.hasNext()) {
//				int customerId = Integer.parseInt(scan.next());
//				String firstName = scan.next();
//				String lastName = scan.next();
//				String email = scan.next().toLowerCase();
//				String password = scan.next();
//				double registrationAmount = Double.parseDouble(scan.next());
//				LocalDate dateOfBirth = LocalDate.parse(scan.next());
//				String plan = scan.next();
//				LocalDate lastSubscriptionDate = LocalDate.parse(scan.next());
//				Customer customer = new Customer(customerId, firstName, lastName, email, password, registrationAmount, dateOfBirth, plan, lastSubscriptionDate);
//				System.out.println(customer);
//				customerMap.put(email, customer);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String line;
		String[] fields;
		try (BufferedReader br = new BufferedReader(new FileReader("Date.txt"))) {
			while ((line = br.readLine()) != null) {
				fields = line.split(",");
				int customerId = Integer.parseInt(fields[0]);
				String firstName = fields[1];
				String lastName = fields[2];
				String email = fields[3].toLowerCase();
				String password = fields[4];
				double registrationAmount = Double.parseDouble(fields[5]);
				LocalDate dateOfBirth = LocalDate.parse(fields[6]);
				String plan = fields[7];
				LocalDate lastSubscriptionDate = LocalDate.parse(fields[8]);
				Customer customer = new Customer(customerId, firstName, lastName, email, password, registrationAmount,
						dateOfBirth, plan, lastSubscriptionDate);
				System.out.println(customer);
				customerMap.put(email, customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End of Restore");
	}
}