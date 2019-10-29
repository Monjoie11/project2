package com.revature.project2.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.util.SessionFactoryUtil;

import com.revature.project2.pojos.Post;

public class PostDAOImpl implements PostDAO {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@Override
	public void insertPost(Post p) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.save(p);
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
	public void removePost(String name) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.delete(p);
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
	public void updatePost(Post p) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.update(p);
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
