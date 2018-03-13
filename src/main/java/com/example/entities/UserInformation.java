package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class UserInformation.
 */
@Entity
public class UserInformation implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	/** The user name. */
	private String userName;
	
	/** The family name. */
	private String familyName;
	
	/** The status. */
	private String status;
	
	/** The email. */
	private String email;
	
	/** The email verification. */
	private boolean emailVerification;
	
	/** The password. */
	private String password;
	
	/** The created at. */
	private Date createdAt;
	
	/** The detail. */
	private String detail;
	
	/** The last login. */
	private Date lastLogin;
	
	/** The system language. */
	private String systemLanguage = "English";
	
	/** The initial setting. */
	private boolean initialSetting = true;
	
	/** The authority. */
	@OneToOne
	@JoinColumn(name = "authority")
	@JsonIgnoreProperties({ "authorityName", "ranking" })
	private Authority authority;
	
	/** The Requests. */
	@OneToMany(mappedBy = "user")
	private Collection<Request> Requests;
	
	/** The companies. */
	@ManyToMany(mappedBy = "users")
	private Collection<Company> companies;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author awatef
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: TipiSign
	 * 
	 * Class Name: UserInformation.java
	 * 
	 * Instantiates a new user information.
	 */
	public UserInformation() {
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
	 * Class Name: UserInformation.java
	 * 
	 * Instantiates a new user information.
	 * @param userId the user id
	 * @param userName the user name
	 * @param detail the detail
	 * @param authority the authority
	 */
	public UserInformation(long userId, String userName, String detail, Authority authority) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.detail = detail;
		this.authority = authority;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the user id.
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the user id.
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the account name.
	 * @return the account name
	 */
	public String getUserName() {
		return userName;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the account name.
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the family name.
	 * @return the family name
	 */
	public String getFamilyName() {
		return familyName;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the family name.
	 * @param familyName the new family name
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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
	 * Class Name: UserInformation.java
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
	 * Class Name: UserInformation.java
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the email.
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Class Name: UserInformation.java
	 * 
	 * Checks if is email verification.
	 * @return true, if is email verification
	 */
	public boolean isEmailVerification() {
		return emailVerification;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the email verification.
	 * @param emailVerification the new email verification
	 */
	public void setEmailVerification(boolean emailVerification) {
		this.emailVerification = emailVerification;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the password.
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * Class Name: UserInformation.java
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
	 * Class Name: UserInformation.java
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
	 * Class Name: UserInformation.java
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
	 * Class Name: UserInformation.java
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the last login.
	 * @return the last login
	 */
	public Date getLastLogin() {
		return lastLogin;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the last login.
	 * @param lastLogin the new last login
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the system language.
	 * @return the system language
	 */
	public String getSystemLanguage() {
		return systemLanguage;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the system language.
	 * @param systemLanguage the new system language
	 */
	public void setSystemLanguage(String systemLanguage) {
		this.systemLanguage = systemLanguage;
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
	 * Class Name: UserInformation.java
	 * 
	 * Checks if is initial setting.
	 * @return true, if is initial setting
	 */
	public boolean isInitialSetting() {
		return initialSetting;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the initial setting.
	 * @param initialSetting the new initial setting
	 */
	public void setInitialSetting(boolean initialSetting) {
		this.initialSetting = initialSetting;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the authority.
	 * @return the authority
	 */
	public Authority getAuthority() {
		return authority;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the authority.
	 * @param authority the new authority
	 */
	public void setAuthority(Authority authority) {
		this.authority = authority;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the requests.
	 * @return the requests
	 */
	public Collection<Request> getRequests() {
		return Requests;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the requests.
	 * @param requests the new requests
	 */
	public void setRequests(Collection<Request> requests) {
		Requests = requests;
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
	 * Class Name: UserInformation.java
	 * 
	 * Gets the companies.
	 * @return the companies
	 */
	public Collection<Company> getCompanies() {
		return companies;
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
	 * Class Name: UserInformation.java
	 * 
	 * Sets the companies.
	 * @param companies the new companies
	 */
	public void setCompanies(Collection<Company> companies) {
		this.companies = companies;
	}

}

