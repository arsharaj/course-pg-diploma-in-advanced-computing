package core;

import java.time.LocalDate;

public class PartTime extends Employee {
	private double hourlyPayment;
	
	public PartTime(String name, LocalDate dateOfJoining, String phone, String aadhar, double hourlyPayment) {
		super(name, dateOfJoining, phone, aadhar);
		this.hourlyPayment = hourlyPayment;
	}

	public double getHourlyPayment() {
		return hourlyPayment;
	}

	@Override
	public String toString() {
		return "PartTime [" + super.toString() + ", hourlyPayment = " + hourlyPayment + "]";
	}
	
	
}
