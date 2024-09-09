package customer_stack;

public class GrowableStack implements Stack {
	private Customer[] customers;
	int size = 1;
	int counter = 0;

	void increaseSize() {
		Customer[] newCustomerArray = new Customer[2 * size];
		for(int i = 0; i < size; i++) {
			newCustomerArray[i] = customers[i];
		}
		size *= 2;
		customers = newCustomerArray;
	}
	
	@Override
	public void push(Customer newCustomer) {
		if (counter >= 0) {
			if (customers.length == counter) {
				increaseSize();
			}
			customers[counter] = newCustomer;
			counter++;
		} else {
			System.out.println("Customer cannot be inserted. Limit Reached !");
		}
	}

	@Override
	public String pop() {
		if (counter >= 0 && customers[counter] != null) {
			Customer temp = customers[counter];
			counter--;
			return temp.toString();
		} else {
			System.out.println("No Customer Present !");
			return "";
		}
	}

}
