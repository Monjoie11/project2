package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Company;

public class CompanyDAOImpl implements CompanyDAO {

	@Override
	public void insertCompany(Company c) {
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
	public void removeCompany(String name) {
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

}
