package com.app.dto;

import java.time.LocalDate;

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
public class CourseDto {
	private Long id;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
	private int minScore;
}
