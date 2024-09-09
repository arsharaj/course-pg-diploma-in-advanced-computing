package customer_stack;

public class FixedStack implements Stack {
	private Customer[] customers;
	int counter = 0;
	
	public FixedStack() {
		customers = new Customer[STACK_SIZE];
	}
	
	@Override
	public void push(Customer newCustomer) {
		if (counter >= 0 && counter < STACK_SIZE) {
			customers[counter] = newCustomer;
			counter++;
		} else {
			System.out.println("Customer cannot be inserted. Limit Reached !");
		}
	}

	@Override
	public String pop() {
		if (counter >= 0 && counter < STACK_SIZE) {
			counter--;
			Customer temp = customers[counter];
			return temp.toString();
		} else {
			System.out.println("No Customer Present !");
			return "";
		}
	}

}
