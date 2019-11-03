package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.Company;
import com.revature.pojo.User;

@Service
public class AuthService {

	private UserService userService;
	private CompanyService companyService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Object validateEntity(String email, String password) {

		User validatedUser = userService.getUserByEmail(email);

		if (validatedUser == null) {
			Company validatedCompany = companyService.getCompanyByEmail(email);

			if (validatedCompany != null && password.equals(validatedCompany.getPassword())) {
				return validatedCompany;
			}
		}

		if (validatedUser != null && password.equals(validatedUser.getPassword())) {
			return validatedUser;
		}

		return null;

	}

}
