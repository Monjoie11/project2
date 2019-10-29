package com.revature.project2.dao;

import com.revature.project2.pojos.Post;

public interface PostDAO {
	public void insertPost(Post p);
	public void removePost(String name);
	public void updatePost(Post p);
}
