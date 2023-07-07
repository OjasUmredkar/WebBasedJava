package com.app.exception_handler;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exception.CourseCustomException;
import com.app.dto.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(e.getFieldErrors()
						.stream()
						.collect(Collectors
								.toMap(f->f.getField(), f->f.getDefaultMessage())));
		
	}
	
	@ExceptionHandler(CourseCustomException.class)
	public ResponseEntity<?> handleCourseCustomException(CourseCustomException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(e.getMessage()));
	}
	
}
