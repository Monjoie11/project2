package com.revature.proj2.daos;

import pojos.Post;

public interface PostDAO {
	public void insertPost(Post p);
	public void removePost(String name);
	public void updatePost(Post p);
}
