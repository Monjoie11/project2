package com.revature.project2.pojos;

public class User {
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private Company affiliatedCompany;
	
	private String biography;
	
	private String resume;
	
	private Post post;
	
	private double rating;
	
	private AccessLevel accessLevel;


	private String workType;

	
	
	public static enum AccessLevel {
		OPEN, AFFILIATED, CLOSED;
	}
	
	
	public static enum WorkType{
		FRONTHOUSE, FLOOR, BACKHOUSE, HOST, MAITRED, WAITER, BARTENDER, BUSSER, BARBACK, SOMMELIER, HEADCHEF, PREPCHEF, LINECHEF
	}

}
