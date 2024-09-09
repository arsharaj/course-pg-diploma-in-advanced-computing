package exception;

public class OutOfStockException extends Exception {
	private static final long serialVersionUID = -919840688455635877L;

	public OutOfStockException(String message) {
		super(message);
	}
}
