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

import com.app.dto.BookDto;
import com.app.sevices.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookServ;
	
	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody BookDto bookDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookServ.addBook(bookDto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBooks(){
		return ResponseEntity.status(HttpStatus.OK).body(bookServ.getAllTheCourses());
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto ){
		return ResponseEntity.status(HttpStatus.OK).body(bookServ.updateBook(bookDto));
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId){
		return ResponseEntity.status(HttpStatus.OK).body(bookServ.deleteBook(bookId));
	}
	
}
