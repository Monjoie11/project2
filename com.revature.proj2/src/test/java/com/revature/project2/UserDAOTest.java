package com.revature.project2;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.project2.pojos.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest {
	
	@Mock
	User u;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		String email = "test@gmail.com";
		String pass = "pass";
		u = new User();
		u.setEmail(email);
		u.setPassword(pass);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		//when(calc.mult(.05, 3.0)).thenReturn(.15);
		
	}
	
}
