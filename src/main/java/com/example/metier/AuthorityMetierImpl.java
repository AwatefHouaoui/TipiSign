package com.example.metier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.dao.AuthorityRepository;
import com.example.entities.Authority;

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

	@Override
	public Page<Authority> findAllAuthority(Pageable pageable) {
		return authorityRepository.findAll(pageable);
	}

}
