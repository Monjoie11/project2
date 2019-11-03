package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CompanyDao;
import com.revature.pojo.Company;
import com.revature.pojo.User;

@Service
public class CompanyService {
	
	private CompanyDao companyDao;
	
	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	public Company getCompanyByEmail(String email) {
		return companyDao.getCompanyByEmail(email);
	}
	
	public List<Company> getAllCompanies() {
		return companyDao.getAllCompanies();
	}
	
	public void registerCompany(Company company) {
		companyDao.insertCompany(company);
	}

}
