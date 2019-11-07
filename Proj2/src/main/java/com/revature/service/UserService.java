package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.pojo.Company;
import com.revature.pojo.Post;
import com.revature.pojo.User;
import com.revature.pojo.User.AccessLevel;
import com.revature.pojo.User.WorkType;

@Service
public class UserService {

	private static UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public void registerUser(User user) {
		userDao.insertUser(user);
	}
	
	public void updateEmail(User user, String email) {
		user.setEmail(email);
		userDao.updateUser(user);
	}
	
	public void updateFirstName(User user, String firstName) {
		user.setFirstName(firstName);
		userDao.updateUser(user);
	}
	
	public void updateLastName(User user, String lastName) {
		user.setLastName(lastName);
		userDao.updateUser(user);
	}
	
	public void updatePhoneNumber(User user, String phoneNumber) {
		user.setPhoneNumber(phoneNumber);
		userDao.updateUser(user);
	}
	
	public void updateRating(User user, double rating) {
		user.setRating(rating);
		userDao.updateUser(user);
	}
	
	public void updateAccessLevel(User user, AccessLevel accessLevel) {
		user.setAccessLevel(accessLevel);
		userDao.updateUser(user);
	}
	
	public void updateWorkType(User user, WorkType workType) {
		user.setWorkType(workType);
		userDao.updateUser(user);
	}
	
	public void updateBiography(User user, String biography) {
		user.setBiography(biography);
		userDao.updateUser(user);
	}
	
	public void updateResume(User user, String resume) {
		user.setResume(resume);
		userDao.updateUser(user);
	}
	
	public void addCompanyAffilation(User user, Company company) {
		
		user.getParentCompanies().add(company);
		userDao.updateUser(user);
	}
	
	public void removeCompanyAffilation(User user, Company company) {
		user.getParentCompanies().remove(company);
		userDao.updateUser(user);
	}
	
	public void addPost(User user, Post post) {
		user.getPostedPost().add(post);
		userDao.updateUser(user);
	}
	
	public void deletePost(User user, Post post) {
//		user.getPostedPost().remove(post);
//		userDao.updateUser(user);
		
	}
	
	public void addAcceptedPost(User user, Post post) {
		user.getPostedPost().add(post);
		userDao.updateUser(user);
	}
	
	public void deleteAcceptedPost(User user, Post post) {
		user.getAcceptedPost().remove(post);
		userDao.updateUser(user);
	}
	
}
