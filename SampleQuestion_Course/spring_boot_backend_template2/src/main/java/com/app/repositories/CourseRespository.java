package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Course;

public interface CourseRespository extends JpaRepository<Course, Long> {
	
	Course getCourseByName(String courseName);
	
}
