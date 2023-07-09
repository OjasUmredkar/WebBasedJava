package com.app.sevices;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotfoundException;
import com.app.dto.ApiResponse;
import com.app.dto.BookDto;
import com.app.entities.Author;
import com.app.entities.Book;
import com.app.respositories.AuthorRespository;
import com.app.respositories.BookRespository;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRespository bookRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AuthorRespository authorRepo;
	

	@Override
	public BookDto addBook(BookDto bookDto) {
		
			Book book=mapper.map(bookDto, Book.class);
		
			Author author=authorRepo
					.findById(bookDto.getAuthorId())
				.orElseThrow(()->new ResourceNotfoundException("Enter the valid author id"));
		
						
			book.setAuthor(author);
			bookDto=mapper.map(bookRepo.save(book),BookDto.class);
			bookDto.setAuthorId(author.getId());
			return bookDto;
	}



	@Override
	public List<Book> getAllTheCourses() {
		
		return bookRepo.findAll();
	}



	@Override
	public BookDto updateBook(BookDto bookDto) {
		Book book=mapper.map(bookDto, Book.class);
		
		Author author=authorRepo
				.findById(bookDto.getAuthorId())
			.orElseThrow(()->new ResourceNotfoundException("Enter the valid author id"));
	
					
		book.setAuthor(author);
		bookDto=mapper.map(bookRepo.save(book),BookDto.class);
		bookDto.setAuthorId(author.getId());
		return bookDto;
	}



	@Override
	public ApiResponse deleteBook(Long id) {
		if(!bookRepo.existsById(id)) {
			throw new ResourceNotfoundException("Enter the valid book id");
		}
		bookRepo.deleteById(id);
		return new ApiResponse("Book is deleted");
	}
	
	
	
	
	
	
}
