package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDao {

	public boolean updateUser(User user);
	
	public boolean insertUser(User user);
	
	public boolean deleteUser(User user);
	
	public User getUserByEmail(String email);
	
	public List<User> getAllUsers();
	
}

