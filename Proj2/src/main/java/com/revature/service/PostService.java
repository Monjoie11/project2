package com.revature.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDao;
import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.util.LoggerUtil;

@Service
public class PostService {
	
	private static PostDao postDao ;
	
	@Autowired
	public void setPostDao(PostDao userDao) {
		this.postDao = userDao;
	}
	

	public Post getPostbyId(int id) {
		return postDao.getPost(id);
	}
	
	public List<Post> getAllPosts() {
		return postDao.getAllPosts();
	}
	
	/*
	public List<Post> getAllPostsByCompany(String companyName){
		return postDao.getAllPostsByCompany(companyName);
	}
	*/
	
	public List<Post> getAllPostsByCompany(String companyName){
		return postDao.getAllPostsByCompany(companyName);
	}
	
	public Boolean isPostOrderedCorrectly(Post post) {
		//value less than 0 if the time of this Calendar is before the time represented by the argument
		Boolean checkOrder =  post.getStartTime().compareTo(post.getEndTime()) < 0 ; //->Returns false if startTime >= endTime
		LoggerUtil.debug("Post " + post.getPostId() + " is valid: " + checkOrder);
		return checkOrder;
	}
	
	public Boolean doPostsIntersect(Post post1, Post post2) {	//we assume that the two posts are valid
		//First Check if these are valid posts (startTimes < endTimes strictly)
		if( !isPostOrderedCorrectly(post1) || !isPostOrderedCorrectly(post2) ) {
			return true;
		}
		Boolean checkInOrder = true;
		//Case1: post1 startTime < post2 startTime		
		if(post1.getStartTime().compareTo(post2.getStartTime()) > 0 ) {	
			checkInOrder = post1.getEndTime().compareTo(post2.getStartTime()) > 0 ;	//check if p1 endtime > p2 startTime -> true if p1.end > p2.start
		}
		//Case2: post2 startTime <= post1 startTime
		else {	
			checkInOrder = post2.getEndTime().compareTo(post1.getStartTime()) >= 0 ;//viceversa
		}
		//Case1: post1 startTime >= post2 startTime
		return checkInOrder;
	}
	
//	public Boolean isPostValid( Post post) {	//check if this post can be added to the user's list of posts
//		boolean check = true;
//		String email = post.getPostingUser().getEmail();
//		List<Post> posts = postDao.getPostsByUserEmail(email);
//		for(Post p : posts) {
//			if(doPostsIntersect(post, p)) {
//				LoggerUtil.debug("post : " + post.getPostId() + " overlapped with incoming post: " + post.getPostId());
//				check = false;
//			}
//		}
//		return check;
//	}
	
//	public Boolean createPostIfValid(Post post) {
//		if(!isPostValid(post)) {
//			return false;
//		}
//		postDao.createPost(post);
//		return true;
//	}


	public List<Post> getPostsByPostingUser(String email) {
		// TODO Auto-generated method stub
		return postDao.getPostsByPostingUserEmail(email);
		
	}
	
	public List<Post> getPostsByAcceptingUser(String email) {
		// TODO Auto-generated method stub
		return postDao.getPostsByAcceptingUserEmail(email);
		
	}


    public void createPost(Post post) {
        // TODO Auto-generated method stub
        post.setStatus(Post.Status.PENDING);
        postDao.createPost(post) ;
        LoggerUtil.debug("Post created");
    }
	
	

}
