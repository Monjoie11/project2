/**
 * 
 */
package com.revature.dao;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.pojo.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
	
	private UserDao userDao = new UserDaoImpl();
	User user;
	@Mock
	private SessionFactory sf;
	
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
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetUserByEmail() {
		
	}
	
	@Test
	public void testDB() {
		
	}
	

}
