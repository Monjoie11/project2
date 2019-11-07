package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.service.CompanyService;
import com.revature.service.PostService;
import com.revature.service.UserService;
import com.revature.util.LoggerUtil;

@RestController
public class CompanyController {

	private static CompanyService companyService;

	private static UserService userService;
	
	private static PostService postService;


	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json", value = "/register-company")
	public boolean registerPost(@RequestBody Company company) {
		LoggerUtil.debug("Registering a user");
		if (company == null) {
			return false;
		}

		companyService.registerCompany(company);

		return true;
	}

	@GetMapping(produces = "application/json", value = "/company-access")
	public String generateCompanyAccessCode(@RequestBody Company company) {
		if (company == null) {
			return null;
		}

		return companyService.resetAccessCode(company);

	}

	// @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	// MediaType.APPLICATION_JSON_VALUE, value = "/login")

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/validate-company-access")
	public ResponseEntity<Company> validateCompanyAccessCode(@RequestBody Company c, ModelMap modelMap,
			HttpSession sess) {
		if (c == null) {
			return null;
		}
		LoggerUtil.trace(c.toString());

		LoggerUtil.trace("RECEIVED CODE: " + c.getAccessCode());
		Company company = companyService.getCompanyByAccessCode(c.getAccessCode());
		LoggerUtil.debug(company.toCustomString());

		ResponseEntity<Company> re = new ResponseEntity<Company>(company, HttpStatus.OK);
		return re;

	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/add-company-acceptedpost/{postID}")
	public ResponseEntity<Boolean> acceptPostAsCompany(@PathVariable String postID) {
		LoggerUtil.debug(("Company accepting postId: " + postID));
		if (postID == null) { // !postService.isPostValid(postService.getPostbyId(Integer.valueOf(postID)))
			return null;
		}

		try {

			userService.addRepliedToPost( postService.getPostbyId(Integer.valueOf(postID)));

			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: addUserAcceptedPost FAILED ON: "
					+ postService.getPostbyId(Integer.valueOf(postID)).toString());
			return null;
		}

	}

}
