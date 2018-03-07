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

@Entity
public class UserInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String accountName;
	private String status;
	private String email;
	private boolean emailVerification;
	private String password;
	private Date createdAt;
	private String detail;
	private Date lastLogin;
	private String systemLanguage;
	private boolean initialSetting;
	@OneToOne
	@JoinColumn(name = "Authority")
	@JsonIgnoreProperties({ "authorityId", "ranking" })
	private Authority authority;
	@OneToMany(mappedBy = "user")
	private Collection<Request> Requests;
	@ManyToMany(mappedBy = "users")
	private Collection<Company> companies;

	public UserInformation() {
		super();
	}

	public UserInformation(long userId, String accountName, String detail, Authority authority) {
		super();
		this.userId = userId;
		this.accountName = accountName;
		this.detail = detail;
		this.authority = authority;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(boolean emailVerification) {
		this.emailVerification = emailVerification;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getSystemLanguage() {
		return systemLanguage;
	}

	public void setSystemLanguage(String systemLanguage) {
		this.systemLanguage = systemLanguage;
	}

	public boolean isInitialSetting() {
		return initialSetting;
	}

	public void setInitialSetting(boolean initialSetting) {
		this.initialSetting = initialSetting;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Collection<Request> getRequests() {
		return Requests;
	}

	public void setRequests(Collection<Request> requests) {
		Requests = requests;
	}

	public Collection<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Collection<Company> companies) {
		this.companies = companies;
	}

}

