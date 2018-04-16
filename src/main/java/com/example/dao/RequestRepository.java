package com.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.entities.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

	@Query("select c from Request c where c.toUser.userId =:x and (c.status='pending' or c.status='passed')")
	public List<Request> findPendingRequestByToUser(@Param("x") String userId);
	

	@Query("select c from Request c where c.fromUser =:x and (c.status='approved' or c.status='disapproved')")
	public List<Request> findMyRequests(@Param("x") String userId);

}
