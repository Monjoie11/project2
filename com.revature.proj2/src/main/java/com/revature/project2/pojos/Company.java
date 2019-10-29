package com.revature.project2.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="companies")
public class Company {
	
	@Id
	@Column(name="COMPANY_NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASS")
	private String password;
	
	@Column(name="ACCESS_CODE")
	private String accessCode;
	
	@Column(name="RATING")
	private double rating;
	
	@OneToMany(mappedBy="", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> employees = new HashSet<User>();
	
	private Post post;
	
	
	
}
