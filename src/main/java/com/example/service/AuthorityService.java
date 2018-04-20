package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Authority;
import com.example.metier.AuthorityMetier;

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
	
	public Page<Authority> findAllAuthority (@RequestParam(name = "num", defaultValue="0") int num,
			@RequestParam(name = "size", defaultValue = "3") int size){
		return authorityMetier.findAllAuthority(new PageRequest(num, size));
	}

}
