package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	public Page<Authority> findAllAuthority(Pageable pageable);

}
