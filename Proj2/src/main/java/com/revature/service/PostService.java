package com.revature.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDao;
import com.revature.pojo.Post;

@Service
public class PostService {
	
	private static PostDao postDao ;
	
	@Autowired
	public void setPostDao(PostDao userDao) {
		this.postDao = userDao;
	}
	

	public Post getPostbyId(String id) {
		return postDao.getPost(id);
	}
	
	public List<Post> getAllPosts() {
		return postDao.getAllPosts();
	}
	
	public Boolean doPostsIntersect() {
		
	}

}
