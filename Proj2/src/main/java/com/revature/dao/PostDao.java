package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Post;

public interface PostDao {
	
	public void createPost(Post post);

	public void deletePost(Post post);

	public void updatePost(Post post);

	public List<Post> getAllPosts();

	public Post getPost(int postId);
	
	public List<Post> getPostsByUserEmail(String email);
	
	public ArrayList<Post> getAllPostsByCompany(String companyName);

}
