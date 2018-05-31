package org.side.dao;

import java.io.Serializable;

import org.side.entities.LineProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LineProgressRepository extends JpaRepository<LineProgress, Serializable>{
	@Query("select c from LineProgress c where c.userLine.idUser =:x")
    public LineProgress findLineProgressByUser(@Param("x") String idUser);

}
