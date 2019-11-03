package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.AuthService;

@RestController
public class LoginController {

	private AuthService authService;

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json", value = "/login")
	public Object loginPost(@RequestBody String email, String password) {

		Object authEntity = authService.validateEntity(email, password);

		return authEntity;
	}

}
