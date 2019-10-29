package com.revature.project2.dao;

import com.revature.project2.pojos.Company;


public interface CompanyDAO {
	public void insertCompany(Company c);
	public void removeCompany(String name);
	public void updateCompany(Company c);
}

