package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.service.PostService;
import com.revature.util.LoggerUtil;

@RestController
public class PostController {
	
	private static PostService postService;
	
	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	
	@PostMapping("/post/create")
	public Boolean createPost(@RequestBody Post post, ModelMap map) {
		if(post == null) {
			return false;
		}
		LoggerUtil.debug("Creating a post");
		User user = ((User)map.get("user"));
		post.setPostingUser(user);
		postService.createPostIfValid(post);
		
		return true;
	}
	
	@GetMapping("/post/{post_id}")
	public Post getPostById(@PathVariable String post_id) {
		if(post_id == null) {
			return null;
		}
		LoggerUtil.debug("detected post_id: " + post_id);
		return postService.getPostbyId(post_id);
	}
	

	@GetMapping("/post")
	public List<Post> getAllCompanyPosts( HttpSession session) {
		Company company = (Company) session.getAttribute("company");
		if(company == null) {
			LoggerUtil.debug("Company was null");

			return null;
		}
		
		String companyName = company.getCompanyName();
		LoggerUtil.debug(companyName);

		LoggerUtil.debug("grabbing all posts");
		List<Post> companyPosts = postService.getAllPostsByCompany(companyName);
		
		return companyPosts;
	}

	/*
	@GetMapping("/post")
	public List<Post> getAllCompanyPosts( HttpSession session) {
		Company company = (Company) session.getAttribute("company");
		if(company == null) {
			LoggerUtil.debug("Company was null");

			return null;
		}
		
		String companyName = company.getCompanyName();
		LoggerUtil.debug(companyName);

		LoggerUtil.debug("grabbing all posts");
		return postService.getAllPostsByCompany(company);
	}
	*/
}
