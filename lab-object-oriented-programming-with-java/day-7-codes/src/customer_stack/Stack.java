package customer_stack;

public interface Stack {
	int STACK_SIZE = 20;
	
	void push(Customer newCustomer);
	String pop();
}