package org.side.dao;

import java.io.Serializable;

import org.side.entities.LogDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDecisionRepository extends JpaRepository<LogDecision, Serializable> {

}
