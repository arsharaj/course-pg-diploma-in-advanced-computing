package exception;

public class AuthorizationException extends Exception {
	private static final long serialVersionUID = 4662536272228270139L;

	public AuthorizationException() {
		super("Authorization failed !");
	}
}
