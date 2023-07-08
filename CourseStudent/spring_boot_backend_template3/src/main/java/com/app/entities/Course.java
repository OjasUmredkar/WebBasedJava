package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course extends BaseEntity{
	@Column(length = 20,unique = true, nullable = false)
	private String title;
	@Column(nullable = false)
	private LocalDate startDate;
	@Column(nullable = false)
	private LocalDate endDate;
	@Column(nullable = false)
	private double fees;
	@Column(nullable = false)
	private int minScore;
	@OneToMany(mappedBy = "courseTitle",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnore
	List<Student> students=new ArrayList<Student>();
	
	public void addStudent(Student s) {
		students.add(s);
		s.setCourseTitle(this);
		
	}
	
	
	
	
	
	
}
