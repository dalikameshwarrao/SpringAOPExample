
package com.smartlogistics.controllers;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogistics.dto.LoginRequestDetails;
import com.smartlogistics.dto.LoginResponseDetails;
import com.smartlogistics.dto.LogoutDTO;
import com.smartlogistics.dto.UserDetailDTO;
import com.smartlogistics.entity.UserDetailEntity;
import com.smartlogistics.exception.UnauthorizedException;
import com.smartlogistics.exception.UserNotFoundException;
import com.smartlogistics.exception.UserRuntimeException;
import com.smartlogistics.service.UserDetailService;
import com.smartlogistics.util.CommonUtils.Roles;
import com.smartlogistics.util.StringResponse;

@RestController

@RequestMapping(path = "/smartlogistics")
public class UserDetailsController {
	
	

	@Autowired
	UserDetailService userService;
	
	
	
	@PostMapping("/v1/registration")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDetailDTO userDetailsdto) throws UserRuntimeException {
		UserDetailEntity registerUser = userService.registerUser(userDetailsdto, Roles.OWNER);
		return new ResponseEntity<>(registerUser, HttpStatus.OK);
	}


	@PostMapping("/v1/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequestDetails loginDetails) throws UnauthorizedException {
		LoginResponseDetails userLogin = userService.userLogin(loginDetails);
		return new ResponseEntity<>(userLogin, HttpStatus.OK);
	}

	
	@PostMapping("/v1/userLogout")
	public ResponseEntity<StringResponse> userLogout( @Valid @RequestBody LogoutDTO dto) {
		boolean status = userService.userLogout(dto);
		if (status) {
			StringResponse sr = new StringResponse();
			sr.setMessage("Success");
			return new ResponseEntity<>(sr, HttpStatus.OK);
		} else {
			StringResponse sr = new StringResponse();
			sr.setMessage("Failed");
			return new ResponseEntity<>(sr, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

}
