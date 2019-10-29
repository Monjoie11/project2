package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.proj2.pojos.User;
import com.revature.util.SessionFactoryUtil;

public class UserDAOImpl implements UserDAO{
	
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Override
	public User getUser(String email) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		User user = (User) sess.get(User.class, email);
		tx.commit();
		sess.close();
		return user;
	}

	@Override
	public void createUser(User user) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(user);
		tx.commit();
		sess.close();
	}

	@Override
	public List<User> getAllUsers() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(User.class);
		List<User> result = crit.list();
		sess.close();
		return result;
	}

	@Override
	public void updateUser(User user) {
		Session sess = sf.openSession();
		sess.update(user);
		sess.close();
	}

	@Override
	public void deleteUser(User user) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(user);
		tx.commit();
		sess.close();
		
	}

}
