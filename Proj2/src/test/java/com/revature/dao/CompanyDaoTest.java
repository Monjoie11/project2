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

import com.revature.pojo.Company;
import com.revature.pojo.User;
import com.revature.util.SessionFactoryUtil;

@RunWith(MockitoJUnitRunner.class)
public class CompanyDaoTest {

	@Spy
	CompanyDaoImpl companyDao = new CompanyDaoImpl();
	
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
		String companyName = "testCompany";
		String companyEmail = "testcompany@junit.com";
		String password = "passwordChanged";
		String accessCode = "12345";
		Company testCompany = new Company(companyName, companyEmail, password, accessCode); 
			
		assertTrue(companyDao.updateCompany(testCompany));
	}
	
	@Test
	public void testInsertCompany() {
		String companyName = "testCompany";
		String companyEmail = "testcompany@junit.com";
		String password = "password";
		String accessCode = "12345";
		Company testCompany = new Company(companyName, companyEmail, password, accessCode); 
			
		assertTrue(companyDao.insertCompany(testCompany));
	
	}
	
	@Test
	public void testDeleteCompany() {
		String companyName = "testCompany";
		String companyEmail = "testcompany@junit.com";
		String password = "password";
		String accessCode = "12345";
		Company testCompany = new Company(companyName, companyEmail, password, accessCode); 
		assertTrue(companyDao.deleteCompany(testCompany));
	}
	
	@Test
	public void testGetCompanyByEmail() {
		String email = "testcompany@junit.com";
		Company testCompany = companyDao.getCompanyByEmail(email);
		assertNotNull(testCompany);
	}
	
	@Test
	public void testGetAllCompanies() {
		List<Company> listOfCompanies = companyDao.getAllCompanies();
		assertThat(listOfCompanies.size(), is(6));
	}
	
	@Test
	public void testGetCompanyByAccessCode() {
		String accessCode = "12345";
		List<Company> listOfCompanies = companyDao.getCompanyByAccessCode(accessCode);
		Company testCompany = listOfCompanies.get(0);
		//assertEquals(testUser, user);
		assertNotNull(testCompany);
	}
	
	@Test
	public void testGetCompanyByName() {
		String companyName = "testCompany";
		List<Company> listOfCompanies = companyDao.getCompanyByName(companyName);
		Company testCompany = listOfCompanies.get(0);
		//assertEquals(testUser, user);
		assertNotNull(testCompany);
		
	}

}
