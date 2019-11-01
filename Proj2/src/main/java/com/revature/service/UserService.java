package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.UserDao;
import com.revature.pojo.User;
import com.revature.util.LoggerUtil;

@Component
public class UserService {

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User getUserFromEmail(String email) {
		return userDao.getUser(email);
	}
	
	public boolean registerUser(User user) {
		if( userDao.getUser( user.getEmail() ) != null) {
			LoggerUtil.trace("Registered email: " + user.getEmail());
			userDao.createUser(user);
			return true;
		}
		LoggerUtil.trace("Could not register email: " + user.getEmail());
		return false;
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	/*
	 * public void registerUser(User user) { userDao.saveUser(user); }
	 */
	
}
