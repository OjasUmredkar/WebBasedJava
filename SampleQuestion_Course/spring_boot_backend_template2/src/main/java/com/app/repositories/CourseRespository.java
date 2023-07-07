package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Course;

public interface CourseRespository extends JpaRepository<Course, Long> {
	
	Course getCourseByName(String courseName);
	List<Course> findByCategory(Category category);
}
