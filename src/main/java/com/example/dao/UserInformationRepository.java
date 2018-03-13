package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.entities.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
	@Query("select userName from UserInformation c where c.userName like :x")
	public Page<UserInformation> findUserByName(@Param("x") String userName, Pageable pageable);

}
