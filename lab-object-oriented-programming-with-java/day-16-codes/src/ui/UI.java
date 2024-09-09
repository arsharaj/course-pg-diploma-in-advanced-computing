package ui;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import core.Customer;
import exceptions.CustomerException;
import io.IoUtils;
import sortings.SortByDobAndLastNameComparator;
import static exceptions.ValidationRules.*;

public class UI {

	private static boolean isSignedIn = false;
	public static HashMap<String, Customer> customerMap = new HashMap<>();

	public static void main(String[] args) {
		populateCustomers();
		IoUtils.restore(customerMap);
		try (Scanner scan = new Scanner(System.in)) {
			int choice = 0;
			do {
				try {
					System.out.println("--- Customer Management System ---");
					System.out.println("1. Sign Up - Customer Registration");
					System.out.println("2. Sign In - Customer Log In");
					System.out.println("3. Change Password");
					System.out.println("4. Unsubscribe / Remove Customer");
					System.out.println("5. Display all the Customers");
					System.out.println("6. Sort customers based on email");
					System.out.println("7. Sort customers based on dob and last name");
					System.out.println("8. Remove all defaulter customers");
					System.out.println("0. Exit");
					System.out.println("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						registerNewCustomer(scan);
						break;
					case 2:
						signIn(scan);
						break;
					case 3:
						changePassword(scan);
						break;
					case 4:
						removeCustomer(scan);
						break;
					case 5:
						displayAllCustomers();
						break;
					case 6:
						sortCustomersByEmail();
						break;
					case 7:
						sortCustomersByDobAndLastname();
						break;
					case 8:
						removeDefaulterCustomers();
						break;
					case 9:
						IoUtils.store(customerMap);
					}
				} catch (Exception e) {
					e.printStackTrace();
					scan.nextLine();
				}
			} while (choice != 0);
		}
		IoUtils.store(customerMap);
		System.out.println("Thank You for using our services.");
	}

	private static void removeDefaulterCustomers() {
		validateAndRemoveDefaulterCustomers(customerMap);
	}

	private static void sortCustomersByEmail() {
		System.out.println("Underlying Data Structure does not support sorting inherently.");
	}

	private static void sortCustomersByDobAndLastname() {
		System.out.println("Underlying Data Structure does not support sorting inherently.");
	}

	private static void removeCustomer(Scanner scan) throws CustomerException {
		System.out.println("Enter the email of the customer to unsubscribe : ");
		Customer customer = validateUserByEmail(scan.next(), customerMap);
		customerMap.remove(customer);
		System.out.println("Customer successfully removed.");
	}

	private static void changePassword(Scanner scan) throws CustomerException {
		if (!isSignedIn) {
			System.out.println("First log in to your account and then try again.");
		} else {
			System.out.println("Enter email id and password : ");
			Customer customerKey = validateUserByPassword(scan.next(), scan.next(), customerMap);
			System.out.println("Enter your new password : ");
			customerMap.get(customerKey).setPassword(scan.next());
			System.out.println("Password changed successfully.");
		}
	}

	private static void signIn(Scanner scan) throws CustomerException {
		if (isSignedIn) {
			System.out.println("Already signed in.");
		} else {
			System.out.println("Enter email id and password : ");
			validateUserByPassword(scan.next().toLowerCase(), scan.next(), customerMap);
			isSignedIn = true;
			System.out.println("You have successfully logged in !");
		}
	}

	private static void registerNewCustomer(Scanner scan) throws CustomerException {
		System.out.println(
				"Enter the customer details : (firstName, lastName, email, password, registrationAmount, dateOfBirth[yyyy-MM-dd], plan)");
		Customer newCustomer = new Customer(scan.next(), scan.next(), scan.next().toLowerCase(), scan.next(),
				scan.nextDouble(), LocalDate.parse(scan.next()), scan.next().toUpperCase());
		noDuplicateCustomers(newCustomer.getEmail(), customerMap);
		validatePlan(newCustomer.getPlan());
		validateRegistrationAmount(newCustomer.getAmount(), newCustomer.getPlan());
		customerMap.put(newCustomer.getEmail(), newCustomer);
		System.out.println("Successfully added a new customer.");
	}

	private static void displayAllCustomers() {
		System.out.println("--- All the Customer Details ----");
		customerMap.forEach((email, customer) -> System.out.println(customer));
	}

	private static void populateCustomers() {
		customerMap.put("arsharaj@gmail.com ", new Customer("Arsharaj", "Chauhan", "arsharaj@gmail.com".toLowerCase(),
				"1234", 10000, LocalDate.parse("2022-02-02"), "platinum".toUpperCase()));
		customerMap.put("sahil@gmail.com", new Customer("Sahil", "Srivastava", "sahil@gmail.com".toLowerCase(), "1111",
				5000, LocalDate.parse("2021-02-15"), "diamond".toUpperCase()));
		customerMap.put("amar@gmail.com", new Customer("Amar", "Rajput", "amar@gmail.com".toLowerCase(), "0000", 1000,
				LocalDate.parse("2020-06-29"), "silver".toUpperCase()));
		customerMap.put("aarav@gmail.com".toLowerCase(), new Customer("Aarav", "Kumar", "aarav@gmail.com".toLowerCase(),
				"2222", 2000, LocalDate.parse("2023-11-30"), "gold".toUpperCase()));
		customerMap.put("rajan@gmail.com", new Customer("Rajan", "Bhirudh", "rajan@gmail.com".toLowerCase(), "3421",
				10000, LocalDate.parse("2021-11-30"), "platinum".toUpperCase()));
	}
}
