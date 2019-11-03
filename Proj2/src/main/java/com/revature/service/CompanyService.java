package com.revature.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CompanyDao;
import com.revature.pojo.Company;

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
	
	public String resetAccessCode(Company company) {
		Random r = new Random();
		int i = r.nextInt(999_999 + 1) + 100_000;
		String accessCode = Integer.toString(i);
		company.setAccessCode(accessCode);
		companyDao.updateCompany(company);
		return accessCode;
	}
	
	public Company getCompanyByAccessCode(String accessCode) {
		return companyDao.getCompanyByAccessCode(accessCode);
	}

}
