package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.User;
import com.revature.pojo.User.WorkType;
import com.revature.service.UserService;
import com.revature.util.LoggerUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private static UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/register-user")
	public boolean registerPost(@RequestBody User user) {
		if (user == null) {
			return false;
		}
		LoggerUtil.debug(user.toString());

		userService.registerUser(user);

		return true;
	}

	@PutMapping(consumes = "application/json", produces = "application/json", value = "/update-user-expertise/{workType}")
	public boolean updateUserExpertise(@PathVariable("workType") String s, HttpSession session) {
		// TODO: error check workType
		User.WorkType workT = WorkType.valueOf(s);
		LoggerUtil.debug(workT.toString());
		User user = (User) session.getAttribute("user");
		userService.updateExpertise(user, workT);
		return false;
	}

	@GetMapping(produces = "application/json", value = "/user-rating")
	public double userRatingGet(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return -1;
		}
		User user = (User) session.getAttribute("user");

		return user.getRating();
	}

}
