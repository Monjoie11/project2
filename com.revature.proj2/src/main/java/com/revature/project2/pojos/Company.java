package com.revature.project2.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

	@Id
	@Column(name = "COMPANY_NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASS")
	private String password;

	@Column(name = "ACCESS_CODE")
	private String accessCode;

	@Column(name = "RATING")
	private double rating;

	@Column(name = "access_level")
	private AccessLevel accessLevel;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "COMPANY_USER", joinColumns = @JoinColumn(name = "COMPANY_NAME"), inverseJoinColumns = @JoinColumn(name = "EMAIL"))
	private Set<User> employees = new HashSet<User>();

	@OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Post> approvedPosts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Set<User> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<User> employees) {
		this.employees = employees;
	}

	public Set<Post> getApprovedPosts() {
		return approvedPosts;
	}

	public void setApprovedPosts(Set<Post> approvedPosts) {
		this.approvedPosts = approvedPosts;
	}

	public Company(String name, String email, String password, String accessCode, double rating,
			AccessLevel accessLevel, Set<User> employees, Set<Post> approvedPosts) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.accessCode = accessCode;
		this.rating = rating;
		this.accessLevel = accessLevel;
		this.employees = employees;
		this.approvedPosts = approvedPosts;
	}

	public Company(String name, String email, String password, String accessCode) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.accessCode = accessCode;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessCode == null) ? 0 : accessCode.hashCode());
		result = prime * result + ((accessLevel == null) ? 0 : accessLevel.hashCode());
		result = prime * result + ((approvedPosts == null) ? 0 : approvedPosts.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (accessCode == null) {
			if (other.accessCode != null)
				return false;
		} else if (!accessCode.equals(other.accessCode))
			return false;
		if (accessLevel != other.accessLevel)
			return false;
		if (approvedPosts == null) {
			if (other.approvedPosts != null)
				return false;
		} else if (!approvedPosts.equals(other.approvedPosts))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		return true;
	}

	public static enum AccessLevel {
		OPEN, AFFILIATED, CLOSED
	}

}
