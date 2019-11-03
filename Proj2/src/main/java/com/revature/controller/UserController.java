package com.revature.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.User;
import com.revature.pojo.User.WorkType;
import com.revature.service.UserService;

@RestController
public class UserController {
	
	private static UserService userService;
	
	@PostMapping(consumes = "application/json", produces = "application/json", value = "/register-user")
	public boolean registerPost(@RequestBody User user) {
		if(user == null) {
			return false;
		}
		
		userService.registerUser(user);
		
		return true;
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json", value = "/update-user-expertise")
	public boolean updateUserExpertise(@RequestBody String workType, Http) {
		
		userService.updateExpertise(workType);
		return false;
	}
	
	
	
	
	
}
