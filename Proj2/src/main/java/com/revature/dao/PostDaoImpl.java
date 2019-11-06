package com.revature.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.pojo.Post.Status;
import com.revature.pojo.User;
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
	public Post getPost(int postId) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = null;
		Post p = null;
		try {
			tx = sess.beginTransaction();
			p = (Post) sess.get(Post.class, postId);
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
	public ArrayList<Post> getAllPostsByCompany(String c) {
 		
 		return null;
 	}
	
//	@Override
//	public ArrayList<Post> getAllPostsByCompany(String c) {
//
//		Session sess = sf.openSession();
//		SQLQuery query = sess.createSQLQuery("Select * from posts where referenced_company = " + "\'" + c + "\'");
//		List<Object[]> rows = query.list();
//		for(Object[] row : rows){
//			for(Object r: row) {
//				LoggerUtil.debug(r.toString());
//			}
//			LoggerUtil.debug("\n");
//		}
//		
//		ArrayList<Post> arr = new ArrayList<Post>();
//		for (Object[] row : rows) {
//			Post p = new Post();
//			for (Object r : row) {
//				p.setPostId((int) row[0]);
//				LoggerUtil.debug("0");
//
//				p.setStatus(Status.valueOf((row[1]).toString().toUpperCase()));
//				LoggerUtil.debug("1");
//
//				p.setPostingUser(new User(row[2].toString(), null));
//				LoggerUtil.debug("2");
//
//				p.setReferencedCompany(new Company(row[3].toString()));
//				LoggerUtil.debug("3");
//
//				Calendar cal = Calendar.getInstance();
//				SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd HH:mm:ssss",  Locale.ENGLISH); // 2019-06-22 19:10:25.0
//				LoggerUtil.debug(row[4].toString());
//				try {
//					LoggerUtil.debug("Parsed: " + sdf.parse(row[4].toString()) );
//					cal.setTime(sdf.parse(row[4].toString()));
//					LoggerUtil.debug("Actual: " + cal.getTime().toString() );
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				p.setTimeCreated(cal);
//				p.setTimeCreateString(cal.getTime().toString());
//				
//				LoggerUtil.debug("4");
//				cal = Calendar.getInstance();
//				try {
//					cal.setTime(sdf.parse(row[5].toString()));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				p.setStartTime(cal);
//				p.setStartTimeString(cal.getTime().toString());
//				
//				LoggerUtil.debug("5");
//				cal = Calendar.getInstance();
//				try {
//					cal.setTime(sdf.parse(row[6].toString()));
//					LoggerUtil.debug("test time: ");
//					LoggerUtil.debug(cal.getTime().toString());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				p.setEndTime(cal);
//				p.setEndTimeString(cal.getTime().toString());
//
//				LoggerUtil.debug("6");
//
//				p.setContent(row[7].toString());
//			}
//			arr.add(p);
//		}
//		
//		LoggerUtil.debug("Full aray:");
//		for (Post p : arr) {
//			LoggerUtil.debug(p.toString());
//		}
//		
//		sess.close();
//		return arr;
//	}

}
