package com.revature.controller;

import static com.revature.util.LoggerUtil.error;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.pojo.User;
import com.revature.service.AuthService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	private AuthService authService;

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json", value = "/login")
	public Object loginPost(@RequestBody String email, String password, BindingResult bindingResult, ModelMap modelMap,
			HttpSession sess) {

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}

		Object authEntity = authService.validateEntity(email, password);

		if (authEntity != null && authEntity instanceof Company) {
			sess.setAttribute("company", authEntity);
			modelMap.addAttribute("company", authEntity);
			return authEntity;
		} else if (authEntity != null && authEntity instanceof User) {
			sess.setAttribute("user", authEntity);
			modelMap.addAttribute("user", authEntity);
			return authEntity;
		}

		modelMap.addAttribute("errorMessage", "Username/Password did not match");

		return authEntity;
	}

}
