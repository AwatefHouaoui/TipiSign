package com.example.service;

import java.util.List;

import com.example.entities.Authority;
import com.example.metier.AuthorityMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorityService {
	@Autowired
	private AuthorityMetier authorityMetier;

	@RequestMapping(value = "/Authority", method = RequestMethod.POST)
	public Authority saveAuthority(@RequestBody Authority a) {
		return authorityMetier.saveAuthority(a);
	}

	@RequestMapping(value = "/getAuthority", method = RequestMethod.GET)
	public List<Authority> listAuthority() {
		return authorityMetier.listAuthority();
	}

}
