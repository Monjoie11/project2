package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.revature.pojo.Company;
import com.revature.pojo.User;
import com.revature.util.LoggerUtil;
import com.revature.util.SessionFactoryUtil;

@Component
public class CompanyDaoImpl implements CompanyDao {
	
	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Override
	public boolean updateCompany(Company company) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		
		try {
		sess.update(company);
		tx.commit();
		return true;
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("CompanyDaoImpl, updateCompany, HibernateException");
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
		
	}

	@Override
	public boolean insertCompany(Company company) {
	Session sess = sf.openSession();
		
		// I want to check if there exists a company
		// with matching email
		// which means a company had already registered
		// with this email
		Company c = getCompanyByEmail(company.getCompanyEmail());
		if(c != null) {
			return false;
		}
		
		Transaction tx = sess.beginTransaction();
		
		try {
		sess.save(company);
		tx.commit();
		return true;
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("CompanyDaoImpl, insertCompany, HibernateException");
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public boolean deleteCompany(Company company) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
		sess.delete(company);
		tx.commit();
		return true;
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("CompanyDaoImpl, deleteCompany, HibernateException");
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
		
		
	}

	@Override
	public Company getCompanyByEmail(String email) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		
		try {
			Criteria crit = sess.createCriteria(Company.class).add(Restrictions.eq("companyEmail", email));
			List<Company> company = crit.list();
			tx.commit();
		return company.get(0);
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("CompanyDaoImpl, getCompanyByEmail, HibernateException");
			e.printStackTrace();
			return null;
		} finally {
			sess.close();
		}
		
	}

	@Override
	public List<Company> getAllCompanies() {
		Session sess = sf.openSession();
		
		try {
			Criteria crit = sess.createCriteria(Company.class);
			List<Company> result = crit.list();
			return result;
		} catch (HibernateException e) {
			LoggerUtil.error("CompanyDaoImpl, getAllCompanies, HibernateException");
			e.printStackTrace();
			return null;
		} finally {
			sess.close();
		}
		
	}
	@Override
	public List<Company> getCompanyByAccessCode(String accessCode) {
		
		Session sess = sf.openSession();
		
		try {
			Criteria crit = sess.createCriteria(Company.class).add(Restrictions.eq("accessCode", accessCode));
			List<Company> company = crit.list();
		
			return company;
		} catch (HibernateException e) {
			LoggerUtil.error("CompanyDaoImpl, getCompanyByAccessCode, HibernateException");
			e.printStackTrace();
			return null;
		} finally {
			sess.close();
		}
		
		
	}

	@Override
	public List<Company> getCompanyByName(String companyName) {
		
		Session sess = sf.openSession();
		
		try {
			Criteria crit = sess.createCriteria(Company.class).add(Restrictions.eq("companyName", companyName));
			List<Company> company = crit.list();
			return company;
		} catch (HibernateException e) {
			LoggerUtil.error("CompanyDaoImpl, getCompanyByName, HibernateException");
			e.printStackTrace();
			return null;
		} finally {
			sess.close();
		}
		
	}
	
}
