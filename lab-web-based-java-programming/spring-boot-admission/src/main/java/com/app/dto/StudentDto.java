package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDto {
	private String firstName;

	private String lastName;

	private String email;

	private double score;

	@JsonProperty(access = Access.WRITE_ONLY) // this property is going to be used ONLY during un marshalling(de ser.) to
												// read the course title from the request payload. But it;s not required
												// in resp data
	private String courseTitle;

}
