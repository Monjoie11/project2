package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Component;

import com.revature.pojo.User;
import com.revature.util.LoggerUtil;
import com.revature.util.SessionFactoryUtil;

@Component
public class UserDaoImpl implements UserDao {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();

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
		sess.save(user);
		tx.commit();
		sess.close();
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(user);
		tx.commit();
		sess.close();
		return true;
		
		
	}

	@Override
	public User getUserByEmail(String email) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		User user = (User) sess.get(User.class, email);
		tx.commit();
		sess.close();
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(User.class);
		List<User> result = crit.list();
		sess.close();
		return result;
	}

}
