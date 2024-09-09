package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class CreateNewCourse {	
	private String title;	
	private LocalDate startDate;	
	private LocalDate endDate;
	private double fees;	
	private double minScore;
}
