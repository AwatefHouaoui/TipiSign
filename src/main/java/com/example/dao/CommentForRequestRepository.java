package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.CommentForRequest;

public interface CommentForRequestRepository extends JpaRepository<CommentForRequest, Long> {

}
