package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
