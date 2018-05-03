package org.side.dao;

import org.side.entities.LogRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRequestRepository extends JpaRepository<LogRequest, Long> {

}
