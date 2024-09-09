package core;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
	static private int idGenerator = 0;

	private int empId;
	private String name;
	private LocalDate dateOfJoining;
	private String phone;
	private String aadhar;

	public Employee(String name, LocalDate dateOfJoining, String phone, String aadhar) {
		this.empId = ++idGenerator;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.phone = phone;
		this.aadhar = aadhar;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public String getPhone() {
		return phone;
	}

	public String getAadhar() {
		return aadhar;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dateOfJoining=" + dateOfJoining + ", phone=" + phone
				+ ", aadhar=" + aadhar + "]";
	}
}
