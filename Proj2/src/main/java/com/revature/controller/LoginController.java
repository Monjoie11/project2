package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.pojo.User;
import com.revature.service.AuthService;
import com.revature.service.UserService;
import com.revature.util.LoggerUtil;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	private AuthService authService;
	private static UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping("/login")
	public String loginGet(HttpSession sess, ModelMap modelMap) {
		/*
		if (sess.getAttribute("user") != null) {
			modelMap.addAttribute("user", sess.getAttribute("user"));
			return "home";
		}
		*/
		return "index";
	}

	@GetMapping("/login/{email}")
	public Boolean getUserByUsername(@PathVariable String email) {
		LoggerUtil.debug("detected email: " + email);
		return (userService.getUserByEmail(email + ".com") != null);
	}


	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/login")
	public ResponseEntity<Object> loginPost(@RequestBody User user, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		LoggerUtil.debug("Post Login");
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
    
		Object authEntity = authService.validateEntity(user.getEmail(), user.getPassword());
		
		if (authEntity != null && authEntity instanceof Company) {
			Company company = (Company) authEntity;
			sess.setAttribute("company", company);
			modelMap.addAttribute("company", company);
			LoggerUtil.debug("stored into session: " + company.toCustomString());
			ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(company, HttpStatus.OK);
			return responseEntity;
			
		} else if (authEntity != null && authEntity instanceof User) {
			User u = (User) authEntity;
			sess.setAttribute("user", u);
			modelMap.addAttribute("user", u);
			ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(u, HttpStatus.OK);
			LoggerUtil.debug(user.toCustomString());
			return responseEntity;
		}
		modelMap.addAttribute("errorMessage", "Username/Password did not match");
		return null;

	}
	
	@GetMapping("/logout")
	public Boolean logout(@PathVariable String email) {

		return false;
	}

}
