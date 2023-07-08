package com.app.services;

import java.util.List;

import com.app.dto.CourseDto;
import com.app.dto.StudentDto;
import com.app.entities.Course;
import com.app.entities.Student;

public interface StudentService {

	List<Student> getStudents();

	

	StudentDto saveStudentInCourse(StudentDto studentdto);



	//Student saveCourseAndStudent(Student student);



	String deleteStudentById(Long studentId);



	List<Student> getByCourseTitle(String course);

}
