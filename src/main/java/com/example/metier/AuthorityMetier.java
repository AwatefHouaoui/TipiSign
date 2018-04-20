package com.example.metier;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.entities.Authority;

public interface AuthorityMetier {
	public Authority saveAuthority(Authority a);

	public List<Authority> listAuthority();
	
	public Page<Authority> findAllAuthority(Pageable pageable);
}
