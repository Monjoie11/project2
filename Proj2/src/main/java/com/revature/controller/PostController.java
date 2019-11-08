package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.service.CompanyService;
import com.revature.service.PostService;
import com.revature.util.LoggerUtil;

@RestController
public class PostController {

	private static PostService postService;
	private static CompanyService companyService;

	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@Autowired
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	@PutMapping("/post/create/{name}") // Issue persisting user's email to the database
	public Boolean createPost(@PathVariable("name") String name, @RequestBody Post post, HttpSession sess) {
		if (post == null) {
			return false;
		}
		LoggerUtil.debug("Creating a post");
		User user = ((User) sess.getAttribute("user"));
		name = name.replace("_"," ");
		Company c = (companyService.getCompanyByName(name)).get(0);
		post.setReferencedCompany(c); //REQUEST SHOULD HAVE REFERENCEDCOMPANY
		// FIELD FILLED (DROPDOWN)
		postService.createPost(post);
		return true;
	}

	@GetMapping(produces = "application/json", value = "/post/{post_id}")
	public Post getPostById(@PathVariable("post_id") String post_id) {
		LoggerUtil.debug(post_id);
		if (!post_id.chars().allMatch(Character::isDigit)) {
			return null;
		}
		int id = Integer.parseInt(post_id);
		LoggerUtil.debug("detected post_id: " + id);
		Post post = postService.getPostbyId(id);
		LoggerUtil.debug(post.toCustomString());
		return post;
	}

	@GetMapping("/company/posts")
	public List<Post> getAllCompanyPosts(HttpSession session) {
		Company company = (Company) session.getAttribute("company");
		if (company == null) {
			LoggerUtil.debug("Company was null");

			return null;
		}

		String companyName = company.getCompanyName();
		LoggerUtil.debug(companyName);

		LoggerUtil.debug("grabbing all posts");
		List<Post> companyPosts = postService.getAllPostsByCompany(companyName);

		return companyPosts;
	}

	@GetMapping(value = "/posts/all", produces = "application/json")
	public List<Post> getAllPosts() {
		
		LoggerUtil.debug("grabbing all posts");
		List<Post> allPosts = postService.getAllPosts();

		return allPosts;
	}

	@GetMapping("/user/created-posts")
	public List<Post> getAllUserPosts(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			LoggerUtil.debug("Invalid user!");

			return null;
		}

		String email = user.getEmail();
		LoggerUtil.debug("Detected email: " + email);
		List<Post> userPosts = postService.getPostsByPostingUser(email);

		return userPosts;
	}

	@GetMapping("/user/accepted-posts")
	public List<Post> getAllUserAcceptedPosts(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			LoggerUtil.debug("Invalid user!");

			return null;
		}

		String email = user.getEmail();
		LoggerUtil.debug("Detected email: " + email);
		List<Post> userPosts = postService.getPostsByAcceptingUser(email);

		return userPosts;
	}

}
