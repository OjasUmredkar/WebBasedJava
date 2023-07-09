package com.app.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Author;

public interface AuthorRespository extends JpaRepository<Author, Long> {

	
	
}
