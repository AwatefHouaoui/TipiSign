package org.side.dao;

import java.io.Serializable;

import org.side.entities.UserInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Serializable> {
	@Query("select c from UserInformation c where c.accountName like :x and c.idUser != :idUser")
	public Page<UserInformation> findUserByName(@Param("x") String userName, @Param("idUser") String idUser ,Pageable pageable);
	
	@Query("select c from UserInformation c where c.accountName like :x")
    public UserInformation findUserByAccountName(@Param("x") String userName);

}
