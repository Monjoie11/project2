package com.revature.proj2.daos;

import pojos.Company;

public interface CompanyDAO {
	public void insertCompany(Company c);
	public void removeCompany(String name);
	public void updateCompany(Company c);
}

