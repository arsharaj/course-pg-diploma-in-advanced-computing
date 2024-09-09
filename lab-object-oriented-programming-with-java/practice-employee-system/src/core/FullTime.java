package core;

import java.time.LocalDate;

public class FullTime extends Employee {
	private double monthlySalary;
	
	public FullTime(String name, LocalDate dateOfJoining, String phone, String aadhar, double monthlySalary) {
		super(name, dateOfJoining, phone, aadhar);
		this.monthlySalary = monthlySalary;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	@Override
	public String toString() {
		return "FullTime [" + super.toString() + ", monthlySalary = " + monthlySalary + "]";
	}
	
	
}
