package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
	private Long id;
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	
	
	private Long courseid;
	
	private int score;
}
