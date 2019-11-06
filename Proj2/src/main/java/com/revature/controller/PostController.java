package com.revature.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	@PostMapping("/post/update/{id}")
	public Boolean acceptPost(@RequestBody Post post ) {
		
		//LoggerUtil.debug("Accepting post # " + id);
		//accept post here
		//postService.createPostIfValid(post);
		//postService.getAndUpdatePostStatus(id, true);
		return true;
	}
	
	@GetMapping("/post/{post_id}")
	public Post getPostById(@PathVariable String post_id) {
		if(!post_id.chars().allMatch( Character::isDigit )) {
			return null;
		}
		int id = Integer.parseInt(post_id);
		LoggerUtil.debug("detected post_id: " + id);
		Post post = postService.getPostbyId(id);
		LoggerUtil.debug(post.toString());
		return post;
	}
	

	@GetMapping(value="/post",produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Post> getAllCompanyPosts( HttpSession session) {
		Company company = (Company) session.getAttribute("company");
		if(company == null) {
			LoggerUtil.debug("Company was null");

			return null;
		}		
		String companyName = company.getCompanyName();
		LoggerUtil.debug("grabbing all posts from " + companyName);
		ArrayList<Post> posts = postService.getAllPostsByCompany(companyName);
//		ArrayList<Post> x = new ArrayList<Post>();
//		x.add(new Post());
//		Post L = new Post();
//		L.setContent("testcont");
//		x.add(L);
//		
		for(Post p: posts) {
			LoggerUtil.debug(p.toString());
		}
//		
//		String result = null;
//		try {
//			result = om.writeValueAsString(x);
//			LoggerUtil.debug(result);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//response.getWriter().write(om.writeValueAsString(reimbList));
		return posts;
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
