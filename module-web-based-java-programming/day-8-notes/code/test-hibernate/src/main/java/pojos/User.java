package pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity // MANDATORY cls level anno to tell hibernate , following is entity / POJO class
		// whose life cycle will be managed by hibernate
public class User {
	@Id //=> PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;// explicitly Serializable
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private boolean votingStatus;
	private String role;

	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(String firstName, String lastName, String email, String password, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isVotingStatus() {
		return votingStatus;
	}

	public void setVotingStatus(boolean votingStatus) {
		this.votingStatus = votingStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", votingStatus=" + votingStatus + ", role=" + role + "]";
	}

}
