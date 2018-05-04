package org.side.dao;

import java.io.Serializable;

import org.side.entities.LogRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRequestRepository extends JpaRepository<LogRequest, Serializable> {

}
