package com.app.sevices;

import java.util.List;



import com.app.dto.ApiResponse;
import com.app.dto.BookDto;
import com.app.entities.Book;

public interface BookService {

	BookDto addBook(BookDto bookDto);

	List<Book> getAllTheCourses();
	
	BookDto updateBook(BookDto bookDto);
	
	ApiResponse deleteBook(Long id);

}
