package com.revature.project2.pojos;

public class Post {
	public enum status 
	{
		pending, accepted, completed, rejected, repliedTo
	}
	private String postingUserEmail;
	private String acceptingUserEmail;
	private String affiliatedCompanyName;
	private Object timeCreated;
	private Object startTime;
	private Object endTime;
	public String getPostingUserEmail() {
		return postingUserEmail;
	}
	public void setPostingUserEmail(String postingUserEmail) {
		this.postingUserEmail = postingUserEmail;
	}
	public String getAcceptingUserEmail() {
		return acceptingUserEmail;
	}
	public void setAcceptingUserEmail(String acceptingUserEmail) {
		this.acceptingUserEmail = acceptingUserEmail;
	}
	public String getAffiliatedCompanyName() {
		return affiliatedCompanyName;
	}
	public void setAffiliatedCompanyName(String affiliatedCompanyName) {
		this.affiliatedCompanyName = affiliatedCompanyName;
	}
	public Object getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Object timeCreated) {
		this.timeCreated = timeCreated;
	}
	public Object getStartTime() {
		return startTime;
	}
	public void setStartTime(Object startTime) {
		this.startTime = startTime;
	}
	public Object getEndTime() {
		return endTime;
	}
	public void setEndTime(Object endTime) {
		this.endTime = endTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptingUserEmail == null) ? 0 : acceptingUserEmail.hashCode());
		result = prime * result + ((affiliatedCompanyName == null) ? 0 : affiliatedCompanyName.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((postingUserEmail == null) ? 0 : postingUserEmail.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((timeCreated == null) ? 0 : timeCreated.hashCode());
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
		Post other = (Post) obj;
		if (acceptingUserEmail == null) {
			if (other.acceptingUserEmail != null)
				return false;
		} else if (!acceptingUserEmail.equals(other.acceptingUserEmail))
			return false;
		if (affiliatedCompanyName == null) {
			if (other.affiliatedCompanyName != null)
				return false;
		} else if (!affiliatedCompanyName.equals(other.affiliatedCompanyName))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (postingUserEmail == null) {
			if (other.postingUserEmail != null)
				return false;
		} else if (!postingUserEmail.equals(other.postingUserEmail))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (timeCreated == null) {
			if (other.timeCreated != null)
				return false;
		} else if (!timeCreated.equals(other.timeCreated))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Post [postingUserEmail=" + postingUserEmail + ", acceptingUserEmail=" + acceptingUserEmail
				+ ", affiliatedCompanyName=" + affiliatedCompanyName + ", timeCreated=" + timeCreated + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	public Post(String postingUserEmail, String acceptingUserEmail, String affiliatedCompanyName, Object timeCreated,
			Object startTime, Object endTime) {
		super();
		this.postingUserEmail = postingUserEmail;
		this.acceptingUserEmail = acceptingUserEmail;
		this.affiliatedCompanyName = affiliatedCompanyName;
		this.timeCreated = timeCreated;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
