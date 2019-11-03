package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.pojo.User;
import com.revature.pojo.User.WorkType;
import static com.revature.util.LoggerUtil.debug;

@Service
public class UserService {

	private UserDao userDao;
	
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
	
	public void updateExpertise(User user, String workType) {
		user.setWorkType(User.WorkType.valueOf(workType));
		userDao.updateUser(user);
	}
	
}
