package com.smartlogistics.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDetailDTO {
	
	private String firstName;

	private String lastName;
	
	@Email
	private String email;

	private String phoneNumber;
	
	@NotBlank
	private String password;
	
	private String deviceToken;
}
