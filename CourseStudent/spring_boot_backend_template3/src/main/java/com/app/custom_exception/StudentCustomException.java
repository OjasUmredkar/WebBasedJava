package com.app.custom_exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class StudentCustomException extends RuntimeException {
	public StudentCustomException(String message) {
		super(message);
	}
}
