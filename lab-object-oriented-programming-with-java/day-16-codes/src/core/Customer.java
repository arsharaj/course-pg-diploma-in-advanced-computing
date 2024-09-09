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

	public Customer(int customerId, String firstName, String lastName, String email, String password, double registrationAmount,
			LocalDate dateOfBirth, String plan, LocalDate lastSubscriptionDate) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dateOfBirth = dateOfBirth;
		this.plan = plan;
		this.lastSubscriptionDate = lastSubscriptionDate;
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

	public String storeString() {
		return customerId + "," + firstName + "," + lastName + "," + email + "," + password + "," + registrationAmount + ","
				+ dateOfBirth + "," + plan + "," + lastSubscriptionDate + ",\n";
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", registrationAmount=" + registrationAmount + ", dateOfBirth=" + dateOfBirth + ", plan="
				+ plan + ", lastSubscriptionDate=" + lastSubscriptionDate + "]";
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
