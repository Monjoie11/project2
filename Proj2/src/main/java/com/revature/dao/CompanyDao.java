package com.revature.dao;

import java.util.List;

import com.revature.pojo.Company;


public interface CompanyDao {
	
	public void updateCompany(Company company);

	public void insertCompany(Company company);

	public void deleteCompany(Company company);

	public Company getCompanyByEmail(String email);

	public List<Company> getAllCompanies();
	
	public List<Company> getCompanyByAccessCode(String accessCode);
	
	public List<Company> getCompanyByName(String companyName);
}
