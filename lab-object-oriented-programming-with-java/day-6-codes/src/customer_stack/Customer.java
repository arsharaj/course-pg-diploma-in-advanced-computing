package customer_stack;

public class Customer {
	private int id;
	private String name;
	private String address;
	
	public Customer(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.name + " " + this.address;
	}
}
