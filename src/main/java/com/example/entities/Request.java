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

// TODO: Auto-generated Javadoc
/**
 * The Class Request.
 */
@Entity
public class Request implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The request id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestId;
	
	/** The title. */
	private String title;
	
	/** The hidden. */
	private boolean hidden;
	
	/** The status. */
	private String status = "pending";
	
	/** The from user. */
	private UserInformation fromUser;
	
	/** The to user. */
	private UserInformation toUser;
	
	/** The created at. */
	private Date createdAt;
	
	/** The updated at. */
	private Date updatedAt;
	
	/** The detail. */
	private String detail;
	
	/** The visibility. */
	private long visibility;

	/** The user. */
	@ManyToOne
	@JoinColumn(name = "User_Info")
	private UserInformation user;
	
	/** The comments. */
	@OneToMany(mappedBy = "request")
	private Collection<Comments> comments;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Instantiates a new request.
	 */
	public Request() {
		super();
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Instantiates a new request.
	 * @param requestId the request id
	 * @param hidden the hidden
	 * @param fromUser the from user
	 * @param toUser the to user
	 * @param visibility the visibility
	 */
	public Request(long requestId, boolean hidden, UserInformation fromUser, UserInformation toUser, long visibility) {
		super();
		this.requestId = requestId;
		this.hidden = hidden;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.visibility = visibility;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the request id.
	 * @return the request id
	 */
	public long getRequestId() {
		return requestId;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the request id.
	 * @param requestId the new request id
	 */
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	
	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the title.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the title.
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the updated at.
	 * @return the updated at
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the updated at.
	 * @param updatedAt the new updated at
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the from user.
	 * @return the from user
	 */
	public UserInformation getFromUser() {
		return fromUser;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the from user.
	 * @param fromUser the new from user
	 */
	public void setFromUser(UserInformation fromUser) {
		this.fromUser = fromUser;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the to user.
	 * @return the to user
	 */
	public UserInformation getToUser() {
		return toUser;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the to user.
	 * @param toUser the new to user
	 */
	public void setToUser(UserInformation toUser) {
		this.toUser = toUser;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Checks if is hidden.
	 * @return true, if is hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the hidden.
	 * @param hidden the new hidden
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the status.
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the status.
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the created at.
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the created at.
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the detail.
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the detail.
	 * @param detail the new detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the visibility.
	 * @return the visibility
	 */
	public long getVisibility() {
		return visibility;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the visibility.
	 * @param visibility the new visibility
	 */
	public void setVisibility(long visibility) {
		this.visibility = visibility;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the user.
	 * @return the user
	 */
	public UserInformation getUser() {
		return user;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the user.
	 * @param user the new user
	 */
	public void setUser(UserInformation user) {
		this.user = user;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Gets the comments.
	 * @return the comments
	 */
	public Collection<Comments> getComments() {
		return comments;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: Request.java
	 * 
	 * Sets the comments.
	 * @param comments the new comments
	 */
	public void setComments(Collection<Comments> comments) {
		this.comments = comments;
	}

}