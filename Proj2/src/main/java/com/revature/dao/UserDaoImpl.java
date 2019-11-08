package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.pojo.User;
import com.revature.util.LoggerUtil;
import com.revature.util.SessionFactoryUtil;

@Component
public class UserDaoImpl implements UserDao {
	
	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public boolean updateUser(User user) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		
		try {
		sess.update(user);
		tx.commit();
		return true;
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("UserDaoImpl, updateUser, HibernateException");
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
		
	}

	@Override
	public boolean insertUser(User user) {
		Session sess = sf.openSession();
		
		// I want to check if there exists a user
		// with matching email
		// which means a user had already registered
		// with this email
		User u = getUserByEmail(user.getEmail());
		if(u != null) {
			return false;
		}
		
		Transaction tx = sess.beginTransaction();
		
		try {
		sess.save(user);
		tx.commit();
		return true;
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("UserDaoImpl, insertUser, HibernateException");
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public boolean deleteUser(User user) {
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
		sess.delete(user);
		tx.commit();
		return true;
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("UserDaoImpl, deleteUser, HibernateException");
			e.printStackTrace();
			return false;
		} finally {
			sess.close();
		}
		
		
	}

	@Override
	public User getUserByEmail(String email) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();

		try {
		User user = (User) sess.get(User.class, email);
		tx.commit();
		return user;
		} catch (HibernateException e) {
			tx.rollback();
			LoggerUtil.error("UserDaoImpl, getUserByEmail, HibernateException");
			e.printStackTrace();
			return null;
		} finally {
			sess.close();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		Session sess = sf.openSession();
		
		try {
			Criteria crit = sess.createCriteria(User.class);
			List<User> result = crit.list();
			return result;
		} catch (HibernateException e) {
			LoggerUtil.error("UserDaoImpl, getAllUsers, HibernateException");
			e.printStackTrace();
			return null;
		} finally {
			sess.close();
		}
		
	}

}
