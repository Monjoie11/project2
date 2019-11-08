package com.revature.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
    @Mock
    UserDaoImpl userDaoImpl;
    
    @InjectMocks
    UserService userService = new UserService();
    
    User newUser;
    
    
    /*
     * @Spy HibernateException hibernateException = new
     * HibernateException("Catch HibernateException");
     */
    /*
     * @Mock SessionFactory sf = SessionFactoryUtil.getSessionFactory();
     */
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        newUser = new User("userTest@email.com", "testPassword");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetUserByEmail() {
        
        when(userDaoImpl.getUserByEmail("userTest@email.com")).thenReturn(newUser);
        assertEquals(Optional.of(newUser), userService.getUserByEmail("userTest@email.com"));
        
        /*
         * String email = "testinsertuser@junit.com"; String password =
         * "passwordChanged"; User testUser = new User(); testUser.setEmail(email);
         * testUser.setPassword(password);
         * 
         * User user = userService.getUserByEmail(email); //assertEquals(testUser,
         * user); assertNotNull(user);
         */
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
