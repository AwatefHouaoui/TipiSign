package com.example.metier;

import java.util.List;

import com.example.dao.AuthorityRepository;
import com.example.entities.Authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of Authority service
 * 
 * @author awatef
 * @category Session beans
 * @since version 0.2.0
 *
 */
@Service
public class AuthorityMetierImpl implements AuthorityMetier {

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public Authority saveAuthority(Authority a) {
		return authorityRepository.save(a);
	}

	@Override
	public List<Authority> listAuthority() {
		return authorityRepository.findAll();
	}

}
