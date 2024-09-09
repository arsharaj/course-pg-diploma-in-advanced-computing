package pojos;

import java.sql.Date;
import enums.Role;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private Role role;
	
	public User(int userId, String firstName, String lastName, String email, Date dob, Role role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.role = role;
	}

	public User() {
    }

    public int getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Date getDob() {
		return dob;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", role=" + role + "]";
	}
}
