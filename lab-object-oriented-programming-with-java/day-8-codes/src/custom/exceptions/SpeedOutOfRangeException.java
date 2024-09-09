package custom.exceptions;

public class SpeedOutOfRangeException extends Exception {
	public SpeedOutOfRangeException(String message, Throwable cause) {
		super(message, cause);
	}
}