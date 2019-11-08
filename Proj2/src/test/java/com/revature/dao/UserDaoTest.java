/**
 * 
 */
package com.revature.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

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

import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
	
	@Spy
	UserDaoImpl userDao = new UserDaoImpl();
	
	@Spy
	NullPointerException exceptionSpy = new NullPointerException("catch NullPointerException");
	
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
	public void testUpdateUser() {
		String email = "testinsertuser@junit.com";
		String password = "passwordChanged";
		User testUser = new User();
		testUser.setEmail(email);
		testUser.setPassword(password);
		assertTrue(userDao.updateUser(testUser));
	}
	
	@Test
	public void testInsertUser() {
		String email = "testinsertuser1@junit.com";
		String password = "test";
		User testUser = new User();
		testUser.setEmail(email);
		testUser.setPassword(password);
		assertTrue(userDao.insertUser(testUser));
	}
	
	@Test
	public void testDeleteUser() {
		String email = "testingsertuser2test@junit.com";
		String password = "test";
		User testUser = new User();
		testUser.setEmail(email);
		testUser.setPassword(password);
		assertTrue(userDao.deleteUser(testUser));
	}
	
	@Test
	public void testGetUserByEmail() {
		String email = "testinsertuser@junit.com";
		String password = "passwordChanged";
		User testUser = new User();
		testUser.setEmail(email);
		testUser.setPassword(password);
		User user = userDao.getUserByEmail(email);
		//assertEquals(testUser, user);
		assertNotNull(user);
		
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> listOfUsers = userDao.getAllUsers();
		assertThat(listOfUsers.size(), is(10));
	}
	
	

}
