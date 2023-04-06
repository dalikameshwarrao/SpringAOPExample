package com.smartlogistics.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LogoutDTO {
	
	@NotEmpty(message="token should not be blank or Empty")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
