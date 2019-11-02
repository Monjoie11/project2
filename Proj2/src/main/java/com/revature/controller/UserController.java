package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.User;
import com.revature.service.UserService;
import com.revature.util.LoggerUtil;

@RestController
public class UserController {
	
	private static UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/updateWork")
	public void updateWorkType(HttpServletRequest req, ModelMap modelMap) {
		LoggerUtil.debug("UserService-Post-UpdateWorkType");
		String workType = req.getParameter("workType");
		String email = req.getParameter("email");
		//grab user here?
		User user = (User) modelMap.get("user");
		userService.updateWorkType(  user , workType);
	}
	
	
	@GetMapping("/user/{email}")
	public User getUserByUsername(@PathVariable String email) {
		LoggerUtil.debug("detected email: " + email);
		return userService.getUserFromEmail(email+".com");
	}
	/*
	@PostMapping(consumes = "application/json", value = "/register")
	public User makeUser(@RequestBody User user) {
		User u = userService.registerUser(user);
		return u;
	}
	*/
}
