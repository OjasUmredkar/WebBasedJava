package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AuthorDto {
	
	private Long id;
	@NotBlank(message="First Name cannot be blank")
	private String firstName;
	@NotBlank(message="Last Name cannot be blank")
	private String lastName;
	@Email(message = "Enter correct email")
	private String email;
	@NotBlank(message="Enter password")
	private String password;
	@NotBlank(message="Enter confirm password")
	private String confirmPassword;
	@Override
	public String toString() {
		return "AuthorDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}


