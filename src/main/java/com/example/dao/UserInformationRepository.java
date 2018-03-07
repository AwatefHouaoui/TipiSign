package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

}
