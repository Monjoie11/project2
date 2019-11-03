package com.revature.test;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.stereotype.Component;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

@RunWith(MockitoJUnitRunner.class)
@Component
public class UserDAOTest {
	
	private UserDao userDao = new UserDaoImpl();
	
	/*
	@Autowired
	public void setUserDaoImpl(UserDaoImpl userDao) { 
		this.userDao = userDao;
	}
	*/
	private static User u;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		u = new User("email", "password");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	@Test
	public void testRegister() {
		userDao.createUser(u);
		User ret_u = userDao.getUser(u.getEmail());
		assertEquals(u, ret_u);
	}
	*/
	
	@Test
	public void fetchSingleUser() {
		User ret_u = userDao.getUser(u.getEmail());
		assertEquals(u, ret_u);
	}
	
	@Test
	public void testDB() {
		
	}
	
}
