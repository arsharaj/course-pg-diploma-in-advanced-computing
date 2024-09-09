package custom.exceptions;

import java.util.Date;

interface Speeds {
	int MIN_SPEED = 40;
	int MAX_SPEED = 80;
}

public class ValidationRules implements Speeds {
	public static void validateSpeed(int speed) throws SpeedOutOfRangeException {
		if (speed < MIN_SPEED) {
			throw new SpeedOutOfRangeException("Speed too Slow.", new Throwable("Step on the accelerator."));
		} else if (speed > MAX_SPEED) {
			throw new SpeedOutOfRangeException("Speed too Fast.", new Throwable("Don't step on the accelerator."));
		} else {
			System.out.println("Speed within the range.");
		}
	}

	public static void validateExpiry(Date expiryDate) throws LicenseExpiredException {
		Date now = new Date();
		if (now.before(expiryDate)) {
			System.out.println("License is valid.");
		} else {
			throw new LicenseExpiredException("License Expired !");
		}
	}
}