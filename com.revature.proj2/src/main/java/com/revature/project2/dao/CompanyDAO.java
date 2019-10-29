package com.revature.project2.dao;

import java.util.List;

import com.revature.project2.pojos.Company;

public interface CompanyDAO {
	public void createCompany(Company c);
	public Company getCompany(String name);
	public void deleteCompany(Company c);
	public void updateCompany(Company c);
	public List<Company> getAllCompanies();}

