package pojos;

import java.sql.Date;

public class Voter {
	//  id, first_name, last_name, email, password, dob, status, role
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	
	public Voter(String firstName, String lastName, String email, String password, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Voter [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob=" + dob + "]";
	}
}
