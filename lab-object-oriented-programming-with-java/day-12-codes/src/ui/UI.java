package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import core.Customer;
import exceptions.CustomerException;
import sortings.SortByDobAndLastNameComparator;

import static exceptions.ValidationRules.*;

public class UI {

	private static boolean isSignedIn = false;
	private static ArrayList<Customer> customerList = new ArrayList<>();

	public static void main(String[] args) {
		populateCustomers();
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
					}
				} catch (Exception e) {
					e.printStackTrace();
					scan.nextLine();
				}
			} while (choice != 0);
		}
		System.out.println("Thank You for using our services.");
	}

	private static void removeDefaulterCustomers() {
		validateAndRemoveDefaulterCustomers(customerList);
	}

	private static void sortCustomersByEmail() {
		Collections.sort(customerList);
	}

	private static void sortCustomersByDobAndLastname() {
		Collections.sort(customerList, new SortByDobAndLastNameComparator());
	}

	private static void removeCustomer(Scanner scan) throws CustomerException {
		System.out.println("Enter the email of the customer to unsubscribe : ");
		int customerIndex = validateUserByEmail(scan.next(), customerList);
		customerList.remove(customerIndex);
		System.out.println("Customer successfully removed.");
	}

	private static void changePassword(Scanner scan) throws CustomerException {
		if (!isSignedIn) {
			System.out.println("First log in to your account and then try again.");
		} else {
			System.out.println("Enter email id and password : ");
			int customerIndex = validateUserByPassword(scan.next(), scan.next(), customerList);
			System.out.println("Enter your new password : ");
			customerList.get(customerIndex).setPassword(scan.next());
			System.out.println("Password changed successfully.");
		}
	}

	private static void signIn(Scanner scan) throws CustomerException {
		if (isSignedIn) {
			System.out.println("Already signed in.");
		} else {
			System.out.println("Enter email id and password : ");
			validateUserByPassword(scan.next().toLowerCase(), scan.next(), customerList);
			isSignedIn = true;
			System.out.println("You have successfully logged in !");
		}
	}

	private static void registerNewCustomer(Scanner scan) throws CustomerException {
		System.out.println(
				"Enter the customer details : (firstName, lastName, email, password, registrationAmount, dateOfBirth[yyyy-MM-dd], plan)");
		Customer newCustomer = new Customer(scan.next(), scan.next(), scan.next().toLowerCase(), scan.next(),
				scan.nextDouble(), LocalDate.parse(scan.next()), scan.next().toUpperCase());
		noDuplicateCustomers(newCustomer.getEmail(), customerList);
		validatePlan(newCustomer.getPlan());
		validateRegistrationAmount(newCustomer.getAmount(), newCustomer.getPlan());
		customerList.add(newCustomer);
		System.out.println("Successfully added a new customer.");
	}

	private static void displayAllCustomers() {
		System.out.println("--- All the Customer Details ----");
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
	}

	private static void populateCustomers() {
		customerList.add(new Customer("Arsharaj", "Chauhan", "arsharaj@gmail.com".toLowerCase(), "1234", 10000,
				LocalDate.parse("2022-02-02"), "platinum".toUpperCase()));
		customerList.add(new Customer("Sahil", "Srivastava", "sahil@gmail.com".toLowerCase(), "1111", 5000,
				LocalDate.parse("2021-02-15"), "diamond".toUpperCase()));
		customerList.add(new Customer("Amar", "Rajput", "amar@gmail.com".toLowerCase(), "0000", 1000,
				LocalDate.parse("2020-06-29"), "silver".toUpperCase()));
		customerList.add(new Customer("Aarav", "Kumar", "aarav@gmail.com".toLowerCase(), "2222", 2000,
				LocalDate.parse("2021-11-30"), "gold".toUpperCase()));
		customerList.add(new Customer("Rajan", "Bhirudh", "rajan@gmail.com".toLowerCase(), "3421", 10000,
				LocalDate.parse("2021-11-30"), "platinum".toUpperCase()));
	}
}
