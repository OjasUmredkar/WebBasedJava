package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student extends BaseEntity {
	@Column(nullable = false,length = 20)
	private String firstName;
	@Column(nullable = false,length = 20)
	private String lastName;
	@Column(nullable = false, length = 30 )
	private String email;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="course_id",nullable = false)
	//@JsonIgnore
	private Course courseTitle;
	@Column(nullable = false)
	private int score;
	
}
