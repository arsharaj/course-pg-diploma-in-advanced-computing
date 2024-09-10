package custom_exceptions;

public class BankingException extends Exception {
	public BankingException(String mesg) {
		super(mesg);
	}
}
