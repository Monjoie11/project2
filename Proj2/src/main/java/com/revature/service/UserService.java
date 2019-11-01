package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.UserDao;
import com.revature.pojo.User;

@Component
public class UserService {

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User getEmail(String email) {
		return userDao.getUser(email);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	/*
	 * public void registerUser(User user) { userDao.saveUser(user); }
	 */
	
}
