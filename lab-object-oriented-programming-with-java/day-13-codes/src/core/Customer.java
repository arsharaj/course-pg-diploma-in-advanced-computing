package core;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private static int idGenerator = 1;

	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dateOfBirth;
	private String plan;
	private LocalDate lastSubscriptionDate;

	public Customer(String firstName, String lastName, String email, String password, double registrationAmount,
			LocalDate dateOfBirth, String plan) {
		this.customerId = idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dateOfBirth = dateOfBirth;
		this.plan = plan;
		this.lastSubscriptionDate = dateOfBirth;

		idGenerator++;
	}

	public Customer(String email) {
		this.email = email;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPlan() {
		return this.plan;
	}
	
	public double getAmount() {
		return this.registrationAmount;
	}
	
	public LocalDate getDate() {
		return this.dateOfBirth;
	}
	
	public LocalDate getLastSubscriptionDate() {
		return this.lastSubscriptionDate;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setLastSubscriptionDate(LocalDate date) {
		this.lastSubscriptionDate = date;
	}
	
	@Override
	public String toString() {
		return "Customer Details : \n"
				+ "Customer Id - " + customerId + "\n"
				+ "First Name - " + firstName + "\n"
				+ "Last Name - " + lastName + "\n"
				+ "Email - " + email + "\n"
				+ "Registration Amount - " + registrationAmount + "\n"
				+ "Date of Birth - " + dateOfBirth +"\n"
				+ "Plan - " + plan + "\n";
	}

	@Override
	public boolean equals(Object anotherCustomer) {
		return email.equals(((Customer) anotherCustomer).getEmail());
	}
	
	@Override
	public int compareTo(Customer anotherCustomer) {
		return this.email.compareTo(anotherCustomer.email);
	}
}
