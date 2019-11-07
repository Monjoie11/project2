package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.pojo.User;

import com.revature.service.CompanyService;
import com.revature.service.PostService;
import com.revature.service.UserService;
import com.revature.util.LoggerUtil;

@RestController
public class CompanyController {

	private static CompanyService companyService;

	private static PostService postService;

	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/accept-company-acceptedpost/{postID}")
	public ResponseEntity<Boolean> acceptPostAsCompany(@PathVariable String postID) {
		LoggerUtil.debug(("Company accepting postId: " + postID));
		if (postID == null) { // !postService.isPostValid(postService.getPostbyId(Integer.valueOf(postID)))
			return null;
		}

		try {
			companyService.addRepliedToPost(postService.getPostbyId(Integer.valueOf(postID)));

			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: addUserAcceptedPost FAILED ON: "
					+ postService.getPostbyId(Integer.valueOf(postID)).toString());
			return null;
		}

	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/reject-company-acceptedpost/{postID}")
	public ResponseEntity<Boolean> rejectPostAsCompany(@PathVariable String postID) {
		LoggerUtil.debug(("Company accepting postId: " + postID));
		if (postID == null) { // !postService.isPostValid(postService.getPostbyId(Integer.valueOf(postID)))
			return null;
		}

		try {
			companyService.rejectPost(postService.getPostbyId(Integer.valueOf(postID)));

			ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			LoggerUtil.error("CLASS: UserController FUNC: addUserAcceptedPost FAILED ON: "
					+ postService.getPostbyId(Integer.valueOf(postID)).toString());
			return null;
		}

	}
	
	//-----
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/company-action/{postID}/{action}")
	public ResponseEntity<Boolean> companyActionOnPost(@PathVariable String postID, String action, ModelMap modelMap, HttpSession sess) {
		if(postID == null || action == null) {
			ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
			return re;
		}
		
		if("approved".equals(action)) {
			companyService.approveUserPost(postID);
		} else if ("deny".equals(action)) {
			companyService.denyUserPost(postID);
		}
		
		ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		return re;
		
	}
	
	//-----
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/get-company-by-email/{email}")
	public ResponseEntity<Company> getCompanyByEmail(@PathVariable("email") String email, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(email == null) {
			return null;
		}
		

		
		try {
			Company company = companyService.getCompanyByEmail(email);
			ResponseEntity<Company> responseEntity = new ResponseEntity<Company>(company, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: CompanyController FUNC: getCompanyByEmail FAILED ON: " + email);
			return null;
		}

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/get-company-by-name/{companyName}")
	public ResponseEntity<List<Company>> getCompanyByName(@PathVariable("companyName") String companyName, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		if(companyName == null) {
			return null;
		}
		

		
		try {
			List<Company> listOfCompanies = companyService.getCompanyByName(companyName);
			ResponseEntity<List<Company>> responseEntity = new ResponseEntity<List<Company>>(listOfCompanies, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: CompanyController FUNC: getCompanyByName FAILED ON: " + companyName);
			return null;
		}

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/get-all-companies")
	public ResponseEntity<List<Company>> getAllCompanies(BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			LoggerUtil.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
			return null;
		}
		
		try {
			List<Company> listOfCompanies = companyService.getAllCompanies();
			ResponseEntity<List<Company>> responseEntity = new ResponseEntity<List<Company>>(listOfCompanies, HttpStatus.OK);
			return responseEntity;
		} catch(Exception e) {
			LoggerUtil.error("CLASS: CompanyController FUNC: getAllCompanies FAILED ON: ?");
			return null;
		}

	}
	
	
}
