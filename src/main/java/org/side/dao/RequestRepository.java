package org.side.dao;

import java.io.Serializable;

import org.side.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Serializable> {

}
