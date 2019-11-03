package com.revature.pojo;

public interface FlatUser {
	
	String getEmail();

	String getPassword();

	String getFirstName();

	String getLastName();

	String getPhoneNumber();

	String getBiography();
	
	String getResume();

	double getRating();

	User.AccessLevel getAccessLevel();

	User.WorkType getWorkType();

}


