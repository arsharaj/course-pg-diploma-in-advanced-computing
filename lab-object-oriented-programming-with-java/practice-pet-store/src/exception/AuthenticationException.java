package exception;

public class AuthenticationException extends Exception {
	private static final long serialVersionUID = -6593404369886390259L;

	public AuthenticationException() {
		super("Authentication failed !");
	}
}
