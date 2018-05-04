package org.side.dao;

import java.io.Serializable;

import org.side.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Serializable> {

}
