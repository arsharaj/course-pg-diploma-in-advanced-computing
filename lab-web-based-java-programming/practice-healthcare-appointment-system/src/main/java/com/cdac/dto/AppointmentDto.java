package com.cdac.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AppointmentDto {
	private Long userId;
	private String patientName;
	private String doctor;
	private LocalDateTime dateTime;
}
