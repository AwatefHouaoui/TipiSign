package org.side.dao;

import java.io.Serializable;
import java.util.List;

import org.side.entities.UserToUserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToUserRequestRepository extends JpaRepository<UserToUserRequest, Serializable> {

	@Query("select c from UserToUserRequest c where c.userTo.idUser = :x and (c.request.status='pending' or c.request.status='passed')")
	public List<UserToUserRequest> findPendingRequestByToUser(@Param("x") String idUser);

	@Query("select c from UserToUserRequest c where c.userFrom.idUser =:x  order by c.request.updatedAt desc")
	public Page<UserToUserRequest> findMyRequests(@Param("x") String idUser, Pageable pageable);

	@Query("select c from UserToUserRequest c where c.request.idRequest =:x ")
	public UserToUserRequest findRequest(@Param("x") long idRequest);

}
