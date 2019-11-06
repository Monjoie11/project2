package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<Boolean> registerPost(@RequestBody User user, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if (user != null) {
			LoggerUtil.debug(user.toString());
			userService.registerUser(user);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		}
		
		return null;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-expertise/{workType}")
	public ResponseEntity<Boolean> updateUserExpertise(@PathVariable("workType") String s, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(s == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		user.setWorkType(WorkType.valueOf(s));
		userService.updateExpertise(user, null);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		return responseEntity;
		
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/user-rating")
	public ResponseEntity<Double> userRatingGet(BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		if(user == null) {
			return null;
		}
		
		ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(user.getRating(), HttpStatus.OK);
		return responseEntity;
	}

}
