package com.app.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDto;
import com.app.dto.StudentDto;
import com.app.entities.Course;
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
	
	@GetMapping("/students/course_title/{courseTitle}")
	public ResponseEntity<?> getStudentsByCourseTitle(@PathVariable String courseTitle){
		return ResponseEntity.status(HttpStatus.OK).body(studentServ.getByCourseTitle(courseTitle));
	}
	
	
	
	@PostMapping("/students")
	public ResponseEntity<?> addStudentInCourse(@RequestBody StudentDto studentdto){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentServ.saveStudentInCourse(studentdto));
	}
	
//	@PostMapping("/students/addcourseandstudent")
//	public ResponseEntity<?> addCourseStudent(@RequestBody Student student){
//		return ResponseEntity.status(HttpStatus.CREATED).body(studentServ.saveCourseAndStudent(student));
//	}
	
	@DeleteMapping("courses/{coursesId}/students/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long coursesId,@PathVariable Long studentId ) {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(studentServ.deleteStudentById(studentId)));
	}
}
