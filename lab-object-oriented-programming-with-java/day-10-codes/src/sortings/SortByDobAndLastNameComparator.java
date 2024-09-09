package sortings;

import java.util.Comparator;
import core.Customer;

public class SortByDobAndLastNameComparator implements Comparator<Customer> {
	public int compare(Customer firstCustomer, Customer secondCustomer) {
		int dateStatus = firstCustomer.getDate().compareTo(secondCustomer.getDate());
		return (dateStatus == 0) ? firstCustomer.getLastName().compareTo(secondCustomer.getLastName()) : dateStatus;
	};
}
