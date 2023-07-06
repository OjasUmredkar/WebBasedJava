package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Student;
import com.app.services.StudentService;
import com.app.services.StudentServiceImpl;

import lombok.Getter;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentServ;
	
	@GetMapping("/students")
	public ResponseEntity<?> getStudentList(){
		return ResponseEntity.status(HttpStatus.OK).body(studentServ.getStudents());
	}
	
	@PostMapping("/students/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentServ.saveStudent(student));
		
	}
	
}
