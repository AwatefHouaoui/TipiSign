package com.example.metier;

import java.util.List;

import com.example.entities.Authority;

public interface AuthorityMetier {
	public Authority saveAuthority(Authority a);

	public List<Authority> listAuthority();

}
