package com.app.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.BookDto;
import com.app.entities.Author;
import com.app.entities.Book;

public interface BookRespository extends JpaRepository<Book, Long>{
	List<Book> findByAuthor(Author author);
}
