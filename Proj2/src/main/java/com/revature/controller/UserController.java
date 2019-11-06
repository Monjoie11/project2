package com.revature.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.pojo.User.AccessLevel;
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
	public ResponseEntity<Boolean> registerUserPost(@RequestBody User user, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
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
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-email/{email}")
	public ResponseEntity<Boolean> updateUserEmail(@PathVariable("email") String email, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(email == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updateEmail(user, email);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: updateUserEmail FAILED ON: " + email);
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-firstname/{firstName}")
	public ResponseEntity<Boolean> updateUserFirstName(@PathVariable("firstName") String firstName, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(firstName == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updateFirstName(user, firstName);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: updateFirstName FAILED ON: " + firstName);
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-lastname/{lastName}")
	public ResponseEntity<Boolean> updateUserLastName(@PathVariable("lastName") String lastName, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(lastName == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updateLastName(user, lastName);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: updateLastName FAILED ON: " + lastName);
			return null;
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-phonenumber/{phoneNumber}")
	public ResponseEntity<Boolean> updateUserPhoneNumber(@PathVariable("phoneNumber") String phoneNumber, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(phoneNumber == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updatePhoneNumber(user, phoneNumber);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: updateUserPhoneNumber FAILED ON: " + phoneNumber);
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-rating/{rating}")
	public ResponseEntity<Boolean> updateUserRating(@PathVariable("rating") double rating, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(rating < 0) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updateRating(user, rating);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: updateUserRating FAILED ON: " + rating);
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-accesslevel/{accessLevel}")
	public ResponseEntity<Boolean> updateUserAccessLevel(@PathVariable("accessLevel") String s, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(s == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updateAccessLevel(user, AccessLevel.valueOf(s));
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("invalid enum type for access level in userController: " + s);
			return null;
		}
		
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
		
		try {
			userService.updateWorkType(user, WorkType.valueOf(s));
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("invalid enum type for workType in userController: " + s);
			return null;
		}
		
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-bio/{biography}")
	public ResponseEntity<Boolean> updateUserBiography(@PathVariable("biography") String biography, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(biography == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updateBiography(user, biography);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: updateUserBiography FAILED ON: " + biography);
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update-user-resume/{resume}")
	public ResponseEntity<Boolean> updateUserResume(@PathVariable("resume") String resume, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(resume == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.updateResume(user, resume);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: updateUserResume FAILED ON: " + resume);
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/add-user-companyaffiliation")
	public ResponseEntity<Boolean> addUserCompanyAffilation(@RequestBody Company company, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(company == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.addCompanyAffilation(user, company);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: addUserCompanyAffilation FAILED ON: " + company.toString());
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/remove-user-companyaffiliation")
	public ResponseEntity<Boolean> removeUserCompanyAffilation(@RequestBody Company company, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(company == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.removeCompanyAffilation(user, company);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: removeUserCompanyAffilation FAILED ON: " + company.toString());
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/add-user-post")
	public ResponseEntity<Boolean> addUserPost(@RequestBody Post post, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(post == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.addPost(user, post);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: addUserPost FAILED ON: " + post.toString());
			return null;
		}

	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/remove-user-post")
	public ResponseEntity<Boolean> removeUserPost(@RequestBody Post post, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(post == null) {
			return null;
		}
		
		User user = (User) sess.getAttribute("user");
		
		try {
			userService.deletePost(user, post);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: removeUserPost FAILED ON: " + post.toString());
			return null;
		}

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/get-user-by-email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(email == null) {
			return null;
		}
		

		
		try {
			User user = userService.getUserByEmail(email);
			ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: getUserByEmail FAILED ON: " + email);
			return null;
		}

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/get-all-user")
	public ResponseEntity<List<User>> getAllUser(BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		try {
			List<User> listOfUsers = userService.getAllUsers();
			ResponseEntity<List<User>> responseEntity = new ResponseEntity<List<User>>(listOfUsers, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: getAllUser FAILED ON: ?");
			return null;
		}

	}
	
	
}
