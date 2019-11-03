package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;
import static com.revature.util.LoggerUtil.debug;


@Component
public class UserDaoImpl implements UserDao {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Override
	public User getUser(String email) {
		Session sess = sf.openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = sess.beginTransaction();
			debug("before get");
			Object o = sess.get(User.class, email);
			user = (User) o;
			if(o != null) {
				debug("Dao: " + o.toString());
			}
			debug("Returned object was null." );

			tx.commit();
		}catch(Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		sess.close();
		return user;
	}

	@Override
	public void createUser(User user) {
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.save(user);
			tx.commit();
		}catch(Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		sess.close();
	}

	@Override
	public List<User> getAllUsers() {
		Session sess = sf.openSession();
		Transaction tx = null;
		List<User> result = null;
		try {
			tx = sess.beginTransaction();
			Criteria crit = sess.createCriteria(User.class);
			result = crit.list();
		}catch(Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		sess.close();
		return result;
	}

	@Override
	public void updateUser(User user) {
		
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.update(user);
			tx.commit();
		}catch(Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		sess.close();
	}

	@Override
	public void deleteUser(User user) {		
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.delete(user);
			tx.commit();
		}catch(Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		sess.close();

	}

}
