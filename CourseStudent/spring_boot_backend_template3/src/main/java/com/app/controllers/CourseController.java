package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
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
	
	@PutMapping("/courses/{courseId}/fees/{fees}")
	public ResponseEntity<?> updateCourseFees(@PathVariable Long courseId,@PathVariable double fees ){
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(courseServ.updateFess(courseId,fees)));
	}
	
	
	
}
