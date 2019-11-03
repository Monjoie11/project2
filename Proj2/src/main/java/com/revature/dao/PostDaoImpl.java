package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.pojo.Post;
import com.revature.util.SessionFactoryUtil;

@Component
public class PostDaoImpl implements PostDao {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	@Override
	public void createPost(Post post) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.save(post);
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
	public void deletePost(Post post) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.delete(post);
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
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.update(post);
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
	public Post getPost(String postName) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		Post p = null;
		try {
			tx = sess.beginTransaction();
			p = (Post) sess.get(Post.class, postName);
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

	@Override
	public List<Post> getPostsByUserEmail(String email) {
		Session sess = sf.openSession();
		Transaction tx = null;
		List<Post> posts = null;

		try {
			tx = sess.beginTransaction();
			String hql = "FROM POSTS as b WHERE b.breed = :posting_email";
			Query query = sess.createQuery(hql);
			String posting_email = email;
			query.setParameter("posting_email", email);
			posts = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sess.close();
		}

		/*
		 * 
		 * SQLQuery nativeSQLQuery =
		 * sess.createSQLQuery("Select * from bears where type = " + type);
		 * 
		 * bears = nativeSQLQuery.list();
		 * 
		 * Query query2 = sess.getNamedQuery("get_small_bears");
		 */

		return posts;
	}

}
