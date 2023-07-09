package com.app.sevices;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotfoundException;
import com.app.dto.ApiResponse;
import com.app.dto.AuthorDto;
import com.app.entities.Author;
import com.app.entities.Book;
import com.app.respositories.AuthorRespository;
import com.app.respositories.BookRespository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRespository authorRepo;
	@Autowired
	private BookRespository bookRepository;

	@Autowired ModelMapper mapper;
	
	@Override
	public AuthorDto addAuthor(AuthorDto authordto) {
		System.out.println(authordto);
		Author author=mapper.map(authordto, Author.class);
		System.out.println(author);
		return mapper.map(authorRepo.save(author), AuthorDto.class);
	}
	
	
	@Override
	public List<Author> getallAuthors() {
		
		return authorRepo.findAll();
	}
	@Override
	public AuthorDto updateAuthor(AuthorDto authordto) {
		Author author=mapper.map(authordto, Author.class);
		if(!authorRepo.existsById(authordto.getId())) {
			throw new ResourceNotfoundException("Author does not exists");
		}
		return mapper.map(authorRepo.save(author), AuthorDto.class);
	}
	@Override
	public ApiResponse deleteAuthor(Long authorId) {
		
		if(!authorRepo.existsById(authorId)) {
			throw new ResourceNotfoundException("Author does not exists");
		}
		authorRepo.deleteById(authorId);
		
		return new ApiResponse("Author is deleted");
	}
	
	
	@Override
	public List<Book> getAllBooksOfAuthor(Long authorId) {
		
		
		return bookRepository.findByAuthor(authorRepo.findById(authorId).orElseThrow(()->new ResourceNotfoundException("Author does not exists")));
				
	}
	
	 
	
	
	
	
}
