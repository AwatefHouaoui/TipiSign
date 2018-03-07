package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestId;
	private boolean hidden;
	private String status;
	private UserInformation fromUser;
	private UserInformation toUser;
	private Date createdAt;
	private String detail;
	private long visibility;
	@ManyToOne
	@JoinColumn(name = "User_Info")
	private UserInformation user;
	@OneToMany(mappedBy = "request")
	private Collection<CommentForRequest> comments;

	public Request() {
		super();
	}

	public Request(long requestId, boolean hidden, UserInformation fromUser, UserInformation toUser, long visibility) {
		super();
		this.requestId = requestId;
		this.hidden = hidden;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.visibility = visibility;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public UserInformation getFromUser() {
		return fromUser;
	}

	public void setFromUser(UserInformation fromUser) {
		this.fromUser = fromUser;
	}

	public UserInformation getToUser() {
		return toUser;
	}

	public void setToUser(UserInformation toUser) {
		this.toUser = toUser;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public long getVisibility() {
		return visibility;
	}

	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	public UserInformation getUser() {
		return user;
	}

	public void setUser(UserInformation user) {
		this.user = user;
	}

	public Collection<CommentForRequest> getComments() {
		return comments;
	}

	public void setComments(Collection<CommentForRequest> comments) {
		this.comments = comments;
	}

}