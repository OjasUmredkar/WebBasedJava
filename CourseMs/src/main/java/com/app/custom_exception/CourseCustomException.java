package com.app.custom_exception;

@SuppressWarnings("serial")
public class CourseCustomException extends RuntimeException {
	public CourseCustomException(String message) {

		super(message);
	}
}
