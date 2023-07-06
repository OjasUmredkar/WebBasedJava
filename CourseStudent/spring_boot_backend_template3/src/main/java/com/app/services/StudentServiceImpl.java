package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CourseCustomException;
import com.app.custom_exception.StudentCustomException;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repositories.CourseRepository;
import com.app.repositories.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Override
	public List<Student> getStudents() {
		
		return studentRepo.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
		
		Course course=courseRepo.findById(student.getCourseTitle().getId()).orElseThrow(()->new CourseCustomException("Enter the valid course id"));
		
		if(student.getScore()<=course.getMinScore())
			throw new StudentCustomException("Student is not eligible, minimum score must be "+course.getMinScore());
		
		return studentRepo.save(student);
	}

}
