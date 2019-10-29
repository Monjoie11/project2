package com.revature.project2.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.project2.pojos.Company;
import com.revature.project2.util.SessionFactoryUtil;

public class CompanyDAOImpl implements CompanyDAO {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@Override
	public void createCompany(Company c) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.save(c);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
	}

	@Override
	public void deleteCompany(Company c) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.delete(c);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
	}

	@Override
	public void updateCompany(Company c) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.update(c);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
	}

	@Override
	public Company getCompany(String name) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		Company c = null;
		try {
			tx = sess.beginTransaction();
			c = (Company) sess.get(Company.class, name);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return c;
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		List<Company> result = null;
		try {
			tx = sess.beginTransaction();
			Criteria crit = sess.createCriteria(Company.class);
			result = crit.list();			
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return result;
	}

}
