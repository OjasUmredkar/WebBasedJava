package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.app.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Valid
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDto {
	
	
	@NotNull(message = "Enter the Id")
	private Long id;
	@NotNull(message="Enter the name of course")
	private String name;
	@NotNull(message = "Enter the category of course")
	private Category category;
	@NotNull(message = "Enter the start date of course")
	private LocalDate startDate;
	@NotNull(message = "Enter the end date of the course")
	private LocalDate endDate;
	@NotNull(message = "Enter the fees of the course")
	private double fee;
	
	
	
}
