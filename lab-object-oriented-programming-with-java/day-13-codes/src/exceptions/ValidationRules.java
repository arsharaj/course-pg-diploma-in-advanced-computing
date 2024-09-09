package exceptions;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import core.Customer;
import enums.ServicePlan;

public class ValidationRules {
	public static boolean noDuplicateCustomers(String email, Map<String, Customer> customerMap)
			throws CustomerException {
		if (customerMap.get(email) == null)
			throw new CustomerException("Duplicate entry found in the customer list !");
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

	public static Customer validateUserByPassword(String email, String password, Map<String, Customer> customerMap)
			throws CustomerException {
		if (!customerMap.get(email).checkPassword(password)) {
			throw new CustomerException("Password does not match !");
		}
		return customerMap.get(email);
	}

	public static Customer validateUserByEmail(String email, Map<String, Customer> customerMap)
			throws CustomerException {
		if (customerMap.get(email) == null) {
			throw new CustomerException("Email not found !");
		}
		return customerMap.get(email);
	}

	public static void validateAndRemoveDefaulterCustomers(Map<String, Customer> customerMap) {
//		customerMap.keySet()
//				.removeIf((entry) -> (Period.between(customerMap.get(entry).getLastSubscriptionDate(), LocalDate.now())
//						.getYears() >= 1)
//						|| Period.between(customerMap.get(entry).getLastSubscriptionDate(), LocalDate.now())
//								.getMonths() >= 9);
		customerMap.forEach((email, customer) -> {
			Period period = Period.between(customerMap.get(email).getLastSubscriptionDate(), LocalDate.now());
			if (period.getYears() >= 1 || period.getMonths() >= 9) {
				customerMap.remove(email);
			}
		});
		System.out.println("Defaulters removed.");
	}
}