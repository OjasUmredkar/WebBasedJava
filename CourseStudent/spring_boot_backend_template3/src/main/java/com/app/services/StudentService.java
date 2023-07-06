package com.app.services;

import java.util.List;

import com.app.entities.Student;

public interface StudentService {

	List<Student> getStudents();

	Student saveStudent(Student student);

}
