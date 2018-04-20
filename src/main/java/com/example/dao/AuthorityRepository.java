package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	@Query("select a from Authority ")
	public Page<Authority> findAllAuthority(Pageable pageable);

}
