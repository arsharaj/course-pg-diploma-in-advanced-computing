package exceptions;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import core.Customer;
import enums.ServicePlan;

public class ValidationRules {
	public static boolean noDuplicateCustomers(String email, List<Customer> customerList) throws CustomerException {
		Customer newCustomer = new Customer(email);
		if (customerList.contains(newCustomer)) {
			throw new CustomerException("Duplicate entry found in the customer list !");
		}
		return true;
	}

	public static boolean validatePlan(String plan) throws CustomerException {
		for (ServicePlan planName : ServicePlan.values()) {
			if (planName.toString().equals(plan)) {
				return true;
			}
		}
		throw new CustomerException("No plan of " + plan + " name found !");
	}

	public static boolean validateRegistrationAmount(double amount, String plan) throws CustomerException {
		if (ServicePlan.valueOf(plan.toUpperCase()).getServicePlanCost() != amount) {
			throw new CustomerException("Amount is not exactly equal to the service plan cost !");
		}
		return true;
	}

	public static int validateUserByPassword(String email, String password, List<Customer> customerList)
			throws CustomerException {
		Customer newCustomer = new Customer(email);
		int customerIndex = customerList.indexOf(newCustomer);
		if (customerIndex < 0) {
			throw new CustomerException("No customer found !");
		}
		if (!customerList.get(customerIndex).checkPassword(password)) {
			throw new CustomerException("Password does not match !");
		}
		return customerIndex;
	}

	public static int validateUserByEmail(String email, List<Customer> customerList) throws CustomerException {
		Customer newCustomer = new Customer(email);
		int customerIndex = customerList.indexOf(newCustomer);
		if (customerIndex < 0) {
			throw new CustomerException("No customer found !");
		}
		return customerIndex;
	}

	public static void validateAndRemoveDefaulterCustomers(List<Customer> customerList) {
		Iterator<Customer> customerListItr = customerList.iterator();
		while (customerListItr.hasNext()) {
			Customer customer =  customerListItr.next();
			Period period = Period.between(customer.getLastSubscriptionDate(), LocalDate.now());
			if (period.getYears() > 0 || period.getMonths() > 6)
				customerListItr.remove();
		}
	}
}