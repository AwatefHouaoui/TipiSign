package org.side.dao;

import java.io.Serializable;

import org.side.entities.LineProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineProgressRepository extends JpaRepository<LineProgress, Serializable>{

}
