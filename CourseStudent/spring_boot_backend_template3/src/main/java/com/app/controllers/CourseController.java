package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Course;
import com.app.services.CourseService;

@RestController()
public class CourseController {

	@Autowired
	private CourseService courseServ;
	
	
	@PostMapping("/courses/add")
	public ResponseEntity<?> addCourse(@RequestBody Course course){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(courseServ.saveCourse(course));
	}
	
	
	
}
