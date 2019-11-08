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
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class CompanyDaoTest {

	@Spy
	CompanyDaoImpl userDao = new CompanyDaoImpl();
	
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
	public void testUpdateCompany() {
		String email = "testinsertuser@junit.com";
		String password = "passwordChanged";
		Company testUser = new Company();
		testUser.setEmail(email);
		testUser.setPassword(password);
		assertTrue(userDao.updateCompany(testUser));
	}
	
	@Test
	public void testInsertCompany() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteCompany() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetCompanyByEmail() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllCompanies() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetCompanyByAccessCode() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetCompanyByName() {
		fail("Not yet implemented");
	}

}
