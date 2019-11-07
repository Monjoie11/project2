package com.revature.dao;

import java.util.List;

import com.revature.pojo.Company;
import com.revature.pojo.Post;

public interface PostDao {
	
	public void createPost(Post post);

	public void deletePost(Post post);

	public void updatePost(Post post);

	public List<Post> getAllPosts();

	public Post getPost(int postId);
	
	public List<Post> getPostsByPostingUserEmail(String email);
	
	public List<Post> getPostsByAcceptingUserEmail(String email);
	
	public List<Post> getAllPostsByCompany(String companyName);

}
