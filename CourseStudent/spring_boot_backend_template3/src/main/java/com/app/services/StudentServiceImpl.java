package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CourseCustomException;
import com.app.custom_exception.StudentCustomException;
import com.app.dto.CourseDto;
import com.app.dto.StudentDto;
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
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<Student> getStudents() {
		
		return studentRepo.findAll();
	}
	
	

	@Override
	public StudentDto saveStudentInCourse(StudentDto studentdto) {
		Student student=mapper.map(studentdto,Student.class );
		
		Course course=courseRepo.findById(studentdto.getCourseid()).orElseThrow(()->new CourseCustomException("Enter the valid course id"));
		
		if(student.getScore()<=course.getMinScore())
			throw new StudentCustomException("Student is not eligible, minimum score must be "+course.getMinScore());
		
		student.setCourseTitle(course);		
		StudentDto stu=mapper.map(studentRepo.save(student),StudentDto.class);
		stu.setCourseid(course.getId());
		return stu;//studentRepo.save(student);
		
		
	}



//	@Override
//	public Student saveCourseAndStudent(Student student) {
//		
//		
//		
//		courseRepo.save(student.getCourseTitle());
//		Course course=courseRepo.findById(student.getCourseTitle().getId()).orElseThrow(()->new StudentCustomException("getting wrong course id"));
//		course.addStudent(student);
//		
//		return studentRepo.save(student);
//	}



	@Override
	public String deleteStudentById(Long studentId) {
		String message="Students is not deleted";
		
		if(studentRepo.existsById(studentId)) {
			studentRepo.deleteById(studentId);
			message="Student is deleted";
		}
		return message;
	}



	@Override
	public List<Student> getByCourseTitle(String course) {
		
		Course c=courseRepo.findByTitle(course);
		
		return studentRepo.findByCourseTitle(c);
	}
	

}
