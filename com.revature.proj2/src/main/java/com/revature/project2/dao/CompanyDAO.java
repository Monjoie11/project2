package com.revature.project2.dao;

import java.util.List;

import com.revature.project2.pojos.Company;

public interface CompanyDAO {
	public void createCompany(Company company);

	public Company getCompany(String companyName);

	public void deleteCompany(Company company);

	public void updateCompany(Company company);

	public List<Company> getAllCompanies();

}
