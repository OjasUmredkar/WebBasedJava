package com.app.services;

import javax.validation.Valid;

import com.app.dto.CourseDto;

public interface CourseService {

	CourseDto saveCourse(@Valid CourseDto course);

	CourseDto updateTheCourse(@Valid CourseDto courseDto);

	CourseDto getCourse(String courseName);

	

}
