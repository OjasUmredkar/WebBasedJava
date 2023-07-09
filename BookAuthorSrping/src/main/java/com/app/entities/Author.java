package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
@Table(name = "authors")
public class Author extends BaseEntity {

	@Column(length = 20,nullable = false)
	private String firstName;
	@Column(length = 20,nullable = false)
	private String lastName;
	@Column(length = 30,nullable = false)
	private String email;
	@Column(length = 10,nullable = false)
	private String password;
//	@Transient
//	private String confirmPassword;
	
	
	@OneToMany(cascade = CascadeType.ALL,
			orphanRemoval = true, 
			mappedBy = "author")
	@JsonIgnore
	List<Book> books=new ArrayList<Book>();
	
	
	
}
