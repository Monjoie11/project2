package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "POSTS")
@Component
public class Post {
	
	@Id
	@Column(name = "POST_ID")
	private int postId;

	@Column(name = "POST_CONTENT")
	private String content;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;

	@Column(name = "POSTED_TIME")
	private String timeCreated;

	@Column(name = "START_TIME")
	private String startTime;

	@Column(name = "END_TIME")
	private String endTime;

	@ManyToOne
	@JoinColumn(name = "POSTING_EMAIL")
	@JsonIgnore
	private User postingUser;

	@ManyToOne
	@JoinColumn(name = "ACCEPTING_EMAIL")
	@JsonIgnore
	private User acceptingUser;

	@ManyToOne
	@JoinColumn(name = "REFERENCED_COMPANY")
	@JsonIgnore
	private Company referencedCompany;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public User getPostingUser() {
		return postingUser;
	}

	public void setPostingUser(User postingUser) {
		this.postingUser = postingUser;
	}

	public User getAcceptingUser() {
		return acceptingUser;
	}

	public void setAcceptingUser(User acceptingUser) {
		this.acceptingUser = acceptingUser;
	}

	public Company getReferencedCompany() {
		return referencedCompany;
	}

	public void setReferencedCompany(Company referencedCompany) {
		this.referencedCompany = referencedCompany;
	}

	public Post(int postId, String content, Status status, String timeCreated, String startTime, String endTime,
			User postingUser, User acceptingUser, Company referencedCompany) {
		super();
		this.postId = postId;
		this.content = content;
		this.status = status;
		this.timeCreated = timeCreated;
		this.startTime = startTime;
		this.endTime = endTime;
		this.postingUser = postingUser;
		this.acceptingUser = acceptingUser;
		this.referencedCompany = referencedCompany;
	}
	
	
	public Post(int postId) {
		super();
		this.postId = postId;
	}

	
	public Post() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptingUser == null) ? 0 : acceptingUser.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + postId;
		result = prime * result + ((postingUser == null) ? 0 : postingUser.hashCode());
		result = prime * result + ((referencedCompany == null) ? 0 : referencedCompany.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (acceptingUser == null) {
			if (other.acceptingUser != null)
				return false;
		} else if (!acceptingUser.equals(other.acceptingUser))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (postId != other.postId)
			return false;
		if (postingUser == null) {
			if (other.postingUser != null)
				return false;
		} else if (!postingUser.equals(other.postingUser))
			return false;
		if (referencedCompany == null) {
			if (other.referencedCompany != null)
				return false;
		} else if (!referencedCompany.equals(other.referencedCompany))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status != other.status)
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
		return "Post [postId=" + postId + ", content=" + content + ", status=" + status + ", timeCreated=" + timeCreated
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", postingUser=" + postingUser
				+ ", acceptingUser=" + acceptingUser + ", referencedCompany=" + referencedCompany + "]";
	}

	public String toCustomString() {
		return "Post [postId=" + postId + ", content=" + content + ", status=" + status + ", timeCreated=" + timeCreated
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public static enum Status {
		PENDING, ACCEPTED, COMPLETED, REJECTED, REPLIEDTO
	}

}
