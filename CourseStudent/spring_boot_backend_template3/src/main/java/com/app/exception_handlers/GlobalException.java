package com.app.exception_handlers;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exception.CourseCustomException;
import com.app.custom_exception.StudentCustomException;
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
	
	@ExceptionHandler(StudentCustomException.class)
	public ResponseEntity<?> handleStudentCustomException(StudentCustomException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
	}
	
	@ExceptionHandler(CourseCustomException.class)
	public ResponseEntity<?> handleCourseCustomException(CourseCustomException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
	}
	
}
