package tester;

import static utils.CustomerValidationRules.authenticateCustomer;
import static utils.CustomerValidationRules.validateAllInputs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Customer;

import custom_exceptions.CustomerHandlingException;

public class CMS {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// D.S : exam tip : start with populated sample data
			Map<String, Customer> customers = new HashMap<>();
			while (!exit) {
				System.out.println("1. SignUP 2. Signin 3.Change Password 4.Un subscribe 0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // reg
						System.out.println(
								"Enter firstName,  lastName,  email,  password, regAmount,  dob(yr-mon-day),  plan");
						Customer customer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(customer.getEmail(), customer);
						System.out.println("customer signed up !");
						break;
					case 2: // sign in
						System.out.println("Enter email n pwd");
						customer = authenticateCustomer(sc.next(), sc.next(), customers);
						System.out.println("Login successful , your details " + customer);
						break;
					case 3: // change pwd
						System.out.println("Enter email ,  pwd new pwd");
						customer = authenticateCustomer(sc.next(), sc.next(), customers);
						// => valid login , now simply change pwd
						customer.setPassword(sc.next());
						break;
					case 4: // remove
						System.out.println("Enter email");
						customer = customers.remove(sc.next());
						if (customer == null)
							throw new CustomerHandlingException("Invalid email : rec can't be removed");
						System.out.println("Removed " + customer);
						break;
					case 5:
						System.out.println("All customers details ");
						for (Customer c : customers.values())
							System.out.println(c);
						break;

					case 6: // sort customers as per email
						// since Key based sorting criteria , can be done with TreeMap
						TreeMap<String, Customer> tm = new TreeMap<>(customers);
						System.out.println("All customers details sorted as per email : ");
						for (Customer c : tm.values())
							System.out.println(c);
						break;

					case 7: // advanced : sort customers as per dob
						// since dob is a value based critreria , can't be solved using a TreeMap
						// will have to be converted into Collection view
						// HashMap ---> values() --> Collection<V> --> AL ctor --> AL<V>
						ArrayList<Customer> list = new ArrayList<>(customers.values());
						// practice of functional prog here
						Comparator<Customer> comp = (c1, c2) -> c1.getDob().compareTo(c2.getDob());
						Collections.sort(list, comp);
						System.out.println("customers sorted as per dob");
						list.forEach(c -> System.out.println(c));
						break;
					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}

		}

	}

}
