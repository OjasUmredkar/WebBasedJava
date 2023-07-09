package com.app.sevices;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.AuthorDto;
import com.app.entities.Author;
import com.app.entities.Book;

public interface AuthorService {
	
	
	List<Author> getallAuthors();
	AuthorDto addAuthor(AuthorDto authordto);
	AuthorDto updateAuthor(AuthorDto authordto);
	ApiResponse deleteAuthor(Long authorId);
	List<Book> getAllBooksOfAuthor(Long authorId);
}
