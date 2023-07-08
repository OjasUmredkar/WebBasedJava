package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CourseCustomException;
import com.app.entities.Course;
import com.app.repositories.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public Course saveCourse(Course course) {
		if(course.getStartDate().isAfter(course.getEndDate())) {
			throw new CourseCustomException("Enter the valid start and end date of the course");
		}
		return courseRepo.save(course);
	}

	@Override
	public String updateFess(Long courseId, double fees) {
		
		Course course=courseRepo.findById(courseId).orElseThrow(()->new CourseCustomException("Course not found enter the valid id"));
		course.setFees(fees);
		courseRepo.save(course);
		return "Course fees is updated";
	}

	
	
}
