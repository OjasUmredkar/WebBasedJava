package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDto;
import com.app.entities.Category;
import com.app.services.CourseService;

@RestController("/courses")
public class CourseController {

	@Autowired
	private CourseService courseServ;
	
	@PostMapping("/addcourse")
	public ResponseEntity<?> addACourse(@Valid @RequestBody CourseDto course) {
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(courseServ.saveCourse(course));
		
	}
	
	@PutMapping
	public ResponseEntity<?> updateCourse(@Valid @RequestBody CourseDto courseDto ){
		
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.updateTheCourse(courseDto));
		
	}
	
	
	@GetMapping("/{courseName}")
	public ResponseEntity<?> getCourseByName(@PathVariable String courseName){
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.getCourse(courseName));
		
	}
	
	@GetMapping("/course/{category}")
	public ResponseEntity<?> getCourseByCategory(@PathVariable String category){
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.getByCat( Category.valueOf(category)));
	}
	
}
