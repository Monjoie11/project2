package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.revature.pojo.Company;
import com.revature.util.LoggerUtil;
import com.revature.util.SessionFactoryUtil;

@Component
public class CompanyDaoImpl implements CompanyDao {
	
	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Override
	public void updateCompany(Company company) {
		Session sess = sf.openSession();
		sess.update(company);
		sess.close();
	}

	@Override
	public void insertCompany(Company company) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(company);
		tx.commit();
		sess.close();
	}

	@Override
	public void deleteCompany(Company company) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(company);
		tx.commit();
		sess.close();
	}

	@Override
	public Company getCompanyByEmail(String email) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(Company.class).add(Restrictions.eq("companyEmail", email));
		List<Company> company = crit.list();
		tx.commit();
		sess.close();
		LoggerUtil.debug(company.get(0).toCustomString());
		return company.get(0);
	}

	@Override
	public List<Company> getAllCompanies() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Company.class);
		List<Company> result = crit.list();
		sess.close();
		return result;
	}

	@Override
	public List<Company> getCompanyByAccessCode(String accessCode) {
		
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Company.class).add(Restrictions.eq("accessCode", accessCode));
		List<Company> company = crit.list();
		sess.close();
		return company;
		
	}

	@Override
	public List<Company> getCompanyByName(String companyName) {
		
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Company.class).add(Restrictions.eq("companyName", companyName));
		List<Company> company = crit.list();
		sess.close();
		return company;
		
	}
	
}
