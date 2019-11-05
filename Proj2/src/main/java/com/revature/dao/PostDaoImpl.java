package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.revature.domains.Bear;
import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.util.LoggerUtil;
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
	/*
	 * @Override public List<Post> getAllPostsByCompany(String companyName) {
	 * 
	 * Session sess = sf.openSession(); //Company c = new Company(); Criteria crit =
	 * sess.createCriteria(Post.class).add(Restrictions.eq("referencedCompany",
	 * companyName)); List<Post> posts = crit.list(); sess.close(); return posts;
	 * 
	 * }
	 */

	@Override
	public List<Post> getAllPostsByCompany(String c) {

		Session sess = sf.openSession();
		//Transaction tx = sess.beginTransaction();

		// Company c = new Company();
		SQLQuery nativeSQLQuery = sess.createSQLQuery("Select * from posts where referenced_company = " + "\'"+c+"\'");
		List<Post> posts = nativeSQLQuery.list();
//		Criteria crit = sess.createCriteria(Post.class).add(Restrictions.eq("referencedCompany", c));
//		posts = crit.list();
		LoggerUtil.debug(posts.toString());
		sess.close();
		return posts;

	}

}
