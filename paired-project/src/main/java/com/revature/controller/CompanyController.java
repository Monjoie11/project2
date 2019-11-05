package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.pojo.Company;
import com.revature.service.CompanyService;
import com.revature.util.LoggerUtil;

@RestController
public class CompanyController {

	private static CompanyService companyService;

	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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

	//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/login")

	//@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/validate-company-access")
	@RequestMapping( method = RequestMethod.POST, consumes = "application/json", produces = "application/json", value = "/validate-company-access")
	public Company validateCompanyAccessCode(@RequestBody Company c, ModelMap modelMap, HttpSession sess) throws JsonProcessingException {
		if (c == null) {
			return null;
		}
		LoggerUtil.trace(c.toString());

		LoggerUtil.trace("RECEIVED CODE: "  + c.getAccessCode());
		Company company = companyService.getCompanyByAccessCode(c.getAccessCode());
		LoggerUtil.debug(company.toCustomString());

		
		//ObjectMapper om = new ObjectMapper();
		//String result = om.writeValueAsString(company);
		//ResponseEntity<Object> re = new ResponseEntity<Object>(company, HttpStatus.OK);
		//LoggerUtil.debug(re.toString());
		return company;

	}
	
	

}
