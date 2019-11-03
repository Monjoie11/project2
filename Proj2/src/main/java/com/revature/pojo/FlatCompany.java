package com.revature.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.revature.pojo.Company.AccessLevel;

public interface FlatCompany {
	
	String getCompanyName();

	String getCompanyEmail();

	String getCompanyLink();

	String getPassword();

	String getAccessCode();

	double getCompanyRating();

	Company.AccessLevel getAccessLevel();

}
