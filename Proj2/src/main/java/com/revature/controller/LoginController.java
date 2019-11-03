package com.revature.controller;

import static com.revature.util.LoggerUtil.error;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.pojo.User;
import com.revature.service.AuthService;

@RestController
public class LoginController {

	private AuthService authService;

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/login")
	public ResponseEntity<Object> loginPost(@RequestBody User user, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		Object authEntity = authService.validateEntity(user.getEmail(), user.getPassword());
		
		if (authEntity != null && authEntity instanceof Company) {
			sess.setAttribute("company", authEntity);
			modelMap.addAttribute("company", authEntity);
		//	return ResponseEntity<Object>(authEntity, HttpStatus.CREATED);
		} else if (authEntity != null && authEntity instanceof User) {
			sess.setAttribute("user", authEntity);
			modelMap.addAttribute("user", authEntity);
			ResponseEntity<Object> responseEntity = new ResponseEntity<Object>((User) authEntity, HttpStatus.OK);
			return responseEntity;
			//return authEntity;
		}
		
		modelMap.addAttribute("errorMessage", "Username/Password did not match");
		return null;

	//	return authEntity;
	}

}
