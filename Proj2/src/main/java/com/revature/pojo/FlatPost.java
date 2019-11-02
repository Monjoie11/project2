package com.revature.pojo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public interface FlatPost {
	
	int getPostId();
	
	String getContent();
	
	LocalDateTime getTimeCreated();
	
	LocalDateTime getStartTime();
	
	LocalDateTime getEndTime();

}
