package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDao {

	public void updateUser(User user);
	
	public void insertUser(User user);
	
	public void deleteUser(User user);
	
	public User getUserByEmail(String email);
	
	public List<User> getAllUsers();
	
}

