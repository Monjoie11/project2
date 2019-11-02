package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.UserDao;
import com.revature.pojo.User;
import com.revature.pojo.User.WorkType;
import static com.revature.util.LoggerUtil.debug;

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
	
	public String registerUser(User user) {
		String message = null;
		debug("UserService-registerUser");
		if( userDao.getUser( user.getEmail() ) != null) {
			debug("Registered email: " + user.getEmail());
			userDao.createUser(user);
			message = "Success registering!";
			return message;
		}
		debug("Could not register email: " + user.getEmail());
		message = "Email already registered";
		return message;
	}
	
	public List<User> getAllUsers() {
		debug("UserService-getAllUsers");
		return userDao.getAllUsers();
	}
	
	//	FRONTHOUSE, FLOOR, BACKHOUSE, HOST, MAITRED, WAITER, BARTENDER, BUSSER, BARBACK, SOMMELIER, HEADCHEF, PREPCHEF,
	//LINECHEF
	
	public void updateWorkType(User user, String workType) {
		debug("UserService-updateWorkType");
		WorkType x = WorkType.valueOf(workType);
		user.setWorkType(x);
		userDao.updateUser(user);
	}
	
	/*
	 * public void registerUser(User user) { userDao.saveUser(user); }
	 */
	
}
