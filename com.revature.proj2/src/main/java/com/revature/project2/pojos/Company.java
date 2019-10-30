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
@Table(name = "COMPANIES")
public class Company {

	@Id
	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "EMAIL")
	private String companyEmail;

	@Column(name = "PASS")
	private String password;

	@Column(name = "ACCESS_CODE")
	private String accessCode;

	@Column(name = "RATING")
	private double companyRating;

	@Column(name = "ACCESS_LEVEL")
	private AccessLevel accessLevel;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "COMPANY_USER", joinColumns = @JoinColumn(name = "COMPANY_NAME"), inverseJoinColumns = @JoinColumn(name = "EMAIL"))
	private Set<User> employees = new HashSet<User>();

	@OneToMany(mappedBy = "affiliatedCompany", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Post> approvedPosts;

	public String getName() {
		return companyName;
	}

	public void setName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return companyEmail;
	}

	public void setEmail(String companyEmail) {
		this.companyEmail = companyEmail;
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
		return companyRating;
	}

	public void setRating(double companyRating) {
		this.companyRating = companyRating;
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

	public Company(String companyNamw, String companyEmail, String password, String accessCode, double companyRating,
			AccessLevel accessLevel, Set<User> employees, Set<Post> approvedPosts) {
		super();
		this.companyName = companyNamw;
		this.companyEmail = companyEmail;
		this.password = password;
		this.accessCode = accessCode;
		this.companyRating = companyRating;
		this.accessLevel = accessLevel;
		this.employees = employees;
		this.approvedPosts = approvedPosts;
	}

	public Company(String companyNamw, String companyEmail, String password, String accessCode) {
		super();
		this.companyName = companyNamw;
		this.companyEmail = companyEmail;
		this.password = password;
		this.accessCode = accessCode;
	}

	public Company() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessCode == null) ? 0 : accessCode.hashCode());
		result = prime * result + ((accessLevel == null) ? 0 : accessLevel.hashCode());
		result = prime * result + ((approvedPosts == null) ? 0 : approvedPosts.hashCode());
		result = prime * result + ((companyEmail == null) ? 0 : companyEmail.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		long temp;
		temp = Double.doubleToLongBits(companyRating);
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
		if (companyEmail == null) {
			if (other.companyEmail != null)
				return false;
		} else if (!companyEmail.equals(other.companyEmail))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Double.doubleToLongBits(companyRating) != Double.doubleToLongBits(other.companyRating))
			return false;
		return true;
	}
	
//	open means posts go on open market boards. affiliated means the company has some control over companies. closed mean only employees can see their posts

	public static enum AccessLevel {
		OPEN, AFFILIATED, CLOSED
	}

}
