package com.smartlogistics.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2977358951940310436L;

	
    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
