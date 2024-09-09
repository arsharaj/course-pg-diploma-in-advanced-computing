package exceptions;

public class BankAccountException extends Exception {
	private static final long serialVersionUID = -8183618757974452966L;

	public BankAccountException(String message) {
		super(message);
	}
}
