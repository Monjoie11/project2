package com.revature.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.pojo.User.AccessLevel;
import com.revature.pojo.User.WorkType;
import com.revature.service.AuthService;
import com.revature.service.UserService;
import com.revature.util.LoggerUtil;

import static com.revature.util.LoggerUtil.debug;

@RestController
public class LoginController{
	
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
		
		if (sess.getAttribute("user") != null) {
			modelMap.addAttribute("user", sess.getAttribute("user"));
			return "home";
		}
		
		return "login";
	}
	
	@GetMapping("/login/{email}")
	public Boolean getUserByUsername(@PathVariable String email) {
		LoggerUtil.debug("detected email: " + email);
		return ( userService.getUserByEmail(email+".com") != null );
	}
	
	/*
	@PostMapping("/login")
	public void loginPost(ModelMap modelMap, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse response) throws JsonProcessingException, IOException {
		LoggerUtil.debug("Post-Login");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = new User(email, password);
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			response.getWriter().write(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}

		User authUser = authService.validateUser(user);
		ObjectMapper om = new ObjectMapper();

		if (authUser != null) {
			modelMap.addAttribute("user", authUser);
			response.getWriter().write(om.writeValueAsString(authUser));

		}
		response.getWriter().write(bindingResult.getAllErrors().get(0).getDefaultMessage());

	}
	*/

	/*
	@PostMapping(consumes = "application/json", value = "/login")
	public User loginPost(@RequestBody User user) {
		debug("Post-Login");
		debug( user.toString() );
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			System.out.println(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		
		
		//User(String email, String password, String firstName, String lastName, String phoneNumber,
			//	Set<Company> parentCompanies, String biography, String resume, Set<Post> postedPost, Post acceptedPost,
				//double rating, AccessLevel accessLevel, WorkType workType)
		
		//User authUser = authService.validateEntity(user);
		Post post1 = new Post();
		User testUser = new User("test@email.com", "pass","first", "last", "number", null, "biography", "resume path", null, post1, 4.0, AccessLevel.OPEN, WorkType.BACKHOUSE);
		//debug(authUser.toString());
		
		return testUser;
	}
	*/
		@PostMapping(consumes = "application/json", produces = "application/json", value = "/login")
		public ResponseEntity<Object> loginPost(@RequestBody User user, BindingResult bindingResult, ModelMap modelMap,
				HttpSession sess) {
			
//			User validatedUser = new User("angularTest@tes.com", "angularTest", "angular", "test", "800-ang-ular",
//	                null, "once upon a time there was angular", "angular is hard", null, null,
//	                5.0, User.AccessLevel.OPEN, User.WorkType.BACKHOUSE);
//	        
//	        return validatedUser;

			if (bindingResult.hasErrors()) {
				modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
				LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
				return null;
			}

			Object authEntity = authService.validateEntity(user.getEmail(), user.getPassword());

			if (authEntity != null && authEntity instanceof Company) {
				sess.setAttribute("company", authEntity);
				modelMap.addAttribute("company", authEntity);
				return new ResponseEntity<Object>((Company) authEntity, HttpStatus.OK);
			} else if (authEntity != null && authEntity instanceof User) {
				sess.setAttribute("user", authEntity);
				modelMap.addAttribute("user", authEntity);
				return new ResponseEntity<Object>((User) authEntity, HttpStatus.OK);
			}

			modelMap.addAttribute("errorMessage", "Username/Password did not match");

			return new ResponseEntity<Object>(authEntity, HttpStatus.OK);
		}
	
}
