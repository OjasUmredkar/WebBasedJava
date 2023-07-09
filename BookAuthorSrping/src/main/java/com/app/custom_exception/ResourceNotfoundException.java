package com.app.custom_exception;

@SuppressWarnings("serial")
public class ResourceNotfoundException extends RuntimeException {

	public ResourceNotfoundException(String message) {
		
		super(message);
		
	}
	
}
