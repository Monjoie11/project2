package pojos;

public class User {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Object affiliatedCompany;
	private String biography;
	private String resume;
	private Object post;
	private double rating;

	public enum AccessLevel {
		open, affiliated, closed;
	}

	private String workType;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Object getAffiliatedCompany() {
		return affiliatedCompany;
	}

	public void setAffiliatedCompany(Object affiliatedCompany) {
		this.affiliatedCompany = affiliatedCompany;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Object getPost() {
		return post;
	}

	public void setPost(Object post) {
		this.post = post;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affiliatedCompany == null) ? 0 : affiliatedCompany.hashCode());
		result = prime * result + ((biography == null) ? 0 : biography.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		result = prime * result + ((workType == null) ? 0 : workType.hashCode());
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
		User other = (User) obj;
		if (affiliatedCompany == null) {
			if (other.affiliatedCompany != null)
				return false;
		} else if (!affiliatedCompany.equals(other.affiliatedCompany))
			return false;
		if (biography == null) {
			if (other.biography != null)
				return false;
		} else if (!biography.equals(other.biography))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		if (workType == null) {
			if (other.workType != null)
				return false;
		} else if (!workType.equals(other.workType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", affiliatedCompany=" + affiliatedCompany + ", biography="
				+ biography + ", resume=" + resume + ", post=" + post + ", rating=" + rating + ", workType=" + workType
				+ "]";
	}

	public User(String email, String password, String firstName, String lastName, String phoneNumber,
			Object affiliatedCompany, String biography, String resume, Object post, double rating, String workType) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.affiliatedCompany = affiliatedCompany;
		this.biography = biography;
		this.resume = resume;
		this.post = post;
		this.rating = rating;
		this.workType = workType;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
