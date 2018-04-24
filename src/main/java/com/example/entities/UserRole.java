package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	private String role;
	private long ranking;

	@OneToMany(mappedBy = "userRole")
	private Collection<UserInformation> users;

	public UserRole() {
		super();
	}

	public UserRole(long roleId, String role, long ranking) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.ranking = ranking;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getRanking() {
		return ranking;
	}

	public void setRanking(long ranking) {
		this.ranking = ranking;
	}

	@JsonIgnore
	public Collection<UserInformation> getUsers() {
		return users;
	}

	@JsonSetter
	public void setUsers(Collection<UserInformation> users) {
		this.users = users;
	}

}
