package org.side.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class LineProgress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProgress;

	@ManyToOne
	@JoinColumn(name = "User_Progress")
	@JsonIgnoreProperties({ "status", "email", "emailVerified", "password", "createdAt", "lastLogin",
			"systemLanguage", "initialSetting", "authority", "lineProgresses", "Requests" })
	private UserInformation userLine;
	private String statusLine = "Default";
	private String tiltleRequest;
	private String detailRequest;
	private Authority authority;
	private UserInformation userTo;
	private String name;
	private int nbr = 0;

	public LineProgress() {
		super();
	}

	public LineProgress(UserInformation userLine, String statusLine) {
		super();
		this.userLine = userLine;
		this.statusLine = statusLine;
	}

	public UserInformation getUserLine() {
		return userLine;
	}

	public void setUserLine(UserInformation userLine) {
		this.userLine = userLine;
	}

	public String getStatusLine() {
		return statusLine;
	}

	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}

	public long getIdProgress() {
		return idProgress;
	}

	public void setIdProgress(long idProgress) {
		this.idProgress = idProgress;
	}

	public String getTiltleRequest() {
		return tiltleRequest;
	}

	public void setTiltleRequest(String tiltleRequest) {
		this.tiltleRequest = tiltleRequest;
	}

	public String getDetailRequest() {
		return detailRequest;
	}

	public void setDetailRequest(String detailRequest) {
		this.detailRequest = detailRequest;
	}
	
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public UserInformation getUserTo() {
		return userTo;
	}

	public void setUserTo(UserInformation userTo) {
		this.userTo = userTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	
		
}
