package com.cdac.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String patientName;
	private String doctor;
	private LocalDateTime dateTime;

	@Override
	public String toString() {
		return "Appointment [userId=" + userId + ", patientName=" + patientName + ", doctor=" + doctor + ", dateTime="
				+ dateTime + "]";
	}
}
