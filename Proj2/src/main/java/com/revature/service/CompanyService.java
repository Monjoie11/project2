package com.revature.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CompanyDao;
import com.revature.dao.PostDao;
import com.revature.pojo.Company;
import com.revature.pojo.Company.AccessLevel;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.pojo.Post.Status;
import com.revature.pojo.User.WorkType;


@Service
public class CompanyService {

	private CompanyDao companyDao;
	private PostService postService;

	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	private PostDao postDao;

	@Autowired
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;


	public Company getCompanyByEmail(String email) {
		return companyDao.getCompanyByEmail(email);
	}
	
	public List<Company> getCompanyByName(String companyName) {
		// assuming uniqueness in company name
		return companyDao.getCompanyByName(companyName);
	}

	public List<Company> getAllCompanies() {
		return companyDao.getAllCompanies();
	}

	public void registerCompany(Company company) {
		companyDao.insertCompany(company);
	}

	public String resetAccessCode(Company company) {
		Random r = new Random();
		int i = r.nextInt(999_999 + 1) + 100_000;
		String accessCode = Integer.toString(i);
		company.setAccessCode(accessCode);
		companyDao.updateCompany(company);
		return accessCode;
	}

	public Company getCompanyByAccessCode(String accessCode) {
		List<Company> company = companyDao.getCompanyByAccessCode(accessCode);
		return company.get(0);

	}
	
	public void approveUserPost(String postID) {
		int id = Integer.valueOf(postID);
		Post post = postService.getPostbyId(id);
		post.setStatus(Status.ACCEPTED);
	}
	
	public void denyUserPost(String postID) {
		int id = Integer.valueOf(postID);
		Post post = postService.getPostbyId(id);
		post.setStatus(Status.REJECTED);
	}
	
	//-----
	
	public void updateCompanyName(Company company, String companyName) {
		company.setCompanyName(companyName);
		companyDao.updateCompany(company);
	}
	
	public void updateCompanyLink(Company company, String companyLink) {
		company.setCompanyLink(companyLink);
		companyDao.updateCompany(company);
	}
	
	public void updateCompanyPassword(Company company, String password) {
		company.setPassword(password);
		companyDao.updateCompany(company);
	}
	
	public void updateCompanyRating(Company company, double companyRating) {
		company.setCompanyRating(companyRating);
		companyDao.updateCompany(company);
	}
	
	public void updateCompanyAccessLevel(Company company, AccessLevel accessLevel) {
		company.setAccessLevel(accessLevel);
		companyDao.updateCompany(company);
	}
	
	public void addApprovedPost(Company company, Post post) {
		company.getApprovedPosts().add(post);
		companyDao.updateCompany(company);
	}
	
	public void removeApprovedPost(Company company, Post post) {
		company.getApprovedPosts().remove(post);
		companyDao.updateCompany(company);
	}
	
	public void addEmployee(Company company, User user) {
		company.getEmployees().add(user);
		companyDao.updateCompany(company);
	}
	
	public void fireEmployee(Company company, User user) {
		company.getEmployees().remove(user);
		companyDao.updateCompany(company);
	}
	
	public void addAffiliatedCompany(Company company, Company affiliatedCompany) {
		company.getAffiliatedCompanies().add(affiliatedCompany);
		companyDao.updateCompany(company);
	}
	
	public void removeAffiliatedCompany(Company company, Company affiliatedCompany) {
		company.getAffiliatedCompanies().remove(affiliatedCompany);
		companyDao.updateCompany(company);
	}
	
	public void addRepliedToPost( Post post) {
		post.setStatus(Status.ACCEPTED);
		postDao.updatePost(post);
	}
}
