package com.revature.project2.dao;

import java.util.List;

import com.revature.project2.pojos.Post;

public interface PostDAO {
	public void createPost(Post p);

	public void deletePost(Post p);

	public void updatePost(Post p);

	public List<Post> getAllPosts();

	public Post getPost(String postName);

}
