package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ApiResponse {

	private String message;
	LocalDateTime timeStamp;
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
	
	
}
