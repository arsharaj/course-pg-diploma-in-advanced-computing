package core;

public class Order {
	static int generateOrderId = 101;

	private User user;
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;

	public int getOrderId() {
		return orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getPetId() {
		return petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public User getUser() {
		return user;
	}

	public Status getStatus() {
		return status;
	}

	public Order(int petId, int quantity, Status status,User user) {
		this.orderId = generateOrderId;
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
		generateOrderId++;
		this.user=user;
	}

}
