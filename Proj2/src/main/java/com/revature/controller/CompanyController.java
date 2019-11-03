package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.service.CompanyService;

@RestController
public class CompanyController {
	
	private static CompanyService companyService;
	
	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json", value = "/register-company")
	public boolean registerPost(@RequestBody Company company) {
		if(company == null) {
			return false;
		}
		
		companyService.registerCompany(company);
		
		return true;
	}

}
