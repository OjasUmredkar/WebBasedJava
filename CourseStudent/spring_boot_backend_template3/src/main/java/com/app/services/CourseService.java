package com.app.services;

import com.app.entities.Course;

public interface CourseService {

	Course saveCourse(Course course);

	String updateFess(Long courseId, double fees);

	

}
