package com.revature.project2.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.project2.util.SessionFactoryUtil;
import com.revature.project2.pojos.Company;
import com.revature.project2.pojos.Post;

public class PostDAOImpl implements PostDAO {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@Override
	public void createPost(Post p) {
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
	public void deletePost(Post p) {
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

	@Override
	public List<Post> getAllPosts() {
		Session sess = sf.openSession();
		Transaction tx = null;
		List<Post> result = null;
		try {
			tx = sess.beginTransaction();
			Criteria crit = sess.createCriteria(Post.class);
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

	@Override
	public Post getPost(String name) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		Post p = null;
		try {
			tx = sess.beginTransaction();
			p = (Post) sess.get(Post.class, name);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return p;
	}

}
