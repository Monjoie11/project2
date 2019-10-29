package dao;

import java.util.List;

import com.revature.proj2.pojos.User;

public interface UserDAO {
	
	public User getUser(String email);
	public void createUser(User user);
	public List<User> getAllUsers();
	public void updateUser(User user);
	public void deleteUser(User user);
	
}
