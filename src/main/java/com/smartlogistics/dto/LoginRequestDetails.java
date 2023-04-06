package com.smartlogistics.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequestDetails {
	
    @NotBlank(message = "Email is mandatory")
    @Email
	private String email;
    
    @NotBlank(message = "password is mandatory")
	private String passWord;
	
	private String deviceToken;
}
