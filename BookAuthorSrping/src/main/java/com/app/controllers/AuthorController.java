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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthorDto;
import com.app.sevices.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorServ;
	
	@PostMapping
	public ResponseEntity<?> addAuthor(@RequestBody AuthorDto authorDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(authorServ.addAuthor(authorDto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAuthors(){
		return ResponseEntity.status(HttpStatus.OK).body(authorServ.getallAuthors());
	}
	
	@PutMapping("/{authorId}")
	public ResponseEntity<?> updateAuthor(@RequestBody AuthorDto authorDto){
		return ResponseEntity.status(HttpStatus.OK).body(authorServ.updateAuthor(authorDto));
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId ){
		return ResponseEntity.status(HttpStatus.OK).body(authorServ.deleteAuthor(authorId));
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<?> getAllBooksOfAuthorById(@PathVariable Long authorId){
		return ResponseEntity.status(HttpStatus.OK).body(authorServ.getAllBooksOfAuthor(authorId));
	}
	
	
	
}
