package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.CourseDto;
import com.app.entities.Category;
import com.app.entities.Course;

public interface CourseService {

	CourseDto saveCourse(@Valid CourseDto course);

	CourseDto updateTheCourse(@Valid CourseDto courseDto);

	CourseDto getCourse(String courseName);

	List<Course> getByCat(Category cat);

	

}
