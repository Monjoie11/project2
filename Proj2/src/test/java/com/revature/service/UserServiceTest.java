package com.revature.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.UserDao;
import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Spy
	UserService userService = new UserService();
	
	@Spy
	HibernateException hibernateException = new HibernateException("Catch HibernateException");
	
	@Mock
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	@Test
	public void testGetUserByEmail() {
		String email = "testinsertuser@junit.com";
		String password = "passwordChanged";
		User testUser = new User();
		testUser.setEmail(email);
		testUser.setPassword(password);
		
		User user = userService.getUserByEmail(email);
		//assertEquals(testUser, user);
		assertNotNull(user);
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> listOfUsers = userService.getAllUsers();
		assertThat(listOfUsers.size(), is(10));
	}
	
	@Test
	public void testRegisterUser() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateEmail() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateFirstName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateLastName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdatePhoneNumber() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateRating() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateAccessLevel() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateBiography() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateResume() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddCompanyAffilation() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRemoveCompanyAffilation() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddPost() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeletePost() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdatePostToRepliedTo() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteAcceptedPost() {
		fail("Not yet implemented");
	}

}
