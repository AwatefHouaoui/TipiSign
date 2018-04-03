package com.example.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class LineProgress.
 */
@Entity
public class LineProgress implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id progress. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProgress;

	/** The user line. */
	@ManyToOne
	@JoinColumn(name = "User_Progress")
	@JsonIgnoreProperties({ "status", "email", "emailVerification", "password", "createdAt", "lastLogin",
			"systemLanguage", "initialSetting", "authority", "lineProgresses", "Requests", "companies" })
	private UserInformation userLine;

	/** The status line. */
	private String statusLine = "Default";

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Instantiates a new line progress.
	 */
	public LineProgress() {
		super();
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Instantiates a new line progress.
	 * @param userLine
	 *            the user line
	 * @param statusLine
	 *            the status line
	 */
	public LineProgress(UserInformation userLine, String statusLine) {
		super();
		this.userLine = userLine;
		this.statusLine = statusLine;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Gets the user line.
	 * @return the user line
	 */
	public UserInformation getUserLine() {
		return userLine;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Sets the user line.
	 * @param userLine
	 *            the new user line
	 */
	public void setUserLine(UserInformation userLine) {
		this.userLine = userLine;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Gets the status line.
	 * @return the status line
	 */
	public String getStatusLine() {
		return statusLine;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Sets the status line.
	 * @param statusLine
	 *            the new status line
	 */
	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Gets the id progress.
	 * @return the id progress
	 */
	public long getIdProgress() {
		return idProgress;
	}

	/**
	 * Copyright (c) 2016 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: TipiSign
	 * 
	 *         Class Name: LineProgress.java
	 * 
	 *         Sets the id progress.
	 * @param idProgress
	 *            the new id progress
	 */
	public void setIdProgress(long idProgress) {
		this.idProgress = idProgress;
	}

}
