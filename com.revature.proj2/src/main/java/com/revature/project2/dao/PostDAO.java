package com.revature.project2.dao;

import java.util.List;

import com.revature.project2.pojos.Post;

public interface PostDAO {
	public void createPost(Post post);

	public void deletePost(Post post);

	public void updatePost(Post post);

	public List<Post> getAllPosts();

	public Post getPost(String postName);

}
