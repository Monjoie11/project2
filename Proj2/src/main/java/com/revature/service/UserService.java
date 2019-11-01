package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.UserDao;
import com.revature.pojo.User;
import com.revature.pojo.User.WorkType;
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
		LoggerUtil.debug("UserService-registerUser");
		if( userDao.getUser( user.getEmail() ) != null) {
			LoggerUtil.trace("Registered email: " + user.getEmail());
			userDao.createUser(user);
			return true;
		}
		LoggerUtil.trace("Could not register email: " + user.getEmail());
		return false;
	}
	
	public List<User> getAllUsers() {
		LoggerUtil.debug("UserService-getAllUsers");
		return userDao.getAllUsers();
	}
	
	//	FRONTHOUSE, FLOOR, BACKHOUSE, HOST, MAITRED, WAITER, BARTENDER, BUSSER, BARBACK, SOMMELIER, HEADCHEF, PREPCHEF,
	//LINECHEF
	
	public void updateWorkType(User user, String workType) {
		LoggerUtil.debug("UserService-updateWorkType");
		WorkType x = WorkType.valueOf(workType);
		user.setWorkType(x);
		userDao.updateUser(user);
	}
	
	/*
	 * public void registerUser(User user) { userDao.saveUser(user); }
	 */
	
}
