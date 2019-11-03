package com.revature.pojo;

import java.util.Calendar;

public interface FlatPost {
	
	int getPostId();
	
	String getContent();
	
	Calendar getTimeCreated();
	
	Calendar getStartTime();
	
	Calendar getEndTime();

}
