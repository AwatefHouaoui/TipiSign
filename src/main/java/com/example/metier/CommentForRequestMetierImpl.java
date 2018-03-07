package com.example.metier;

import java.util.List;

import com.example.dao.CommentForRequestRepository;
import com.example.entities.CommentForRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentForRequestMetierImpl implements CommentForRequestMetier {

	@Autowired
	private CommentForRequestRepository commentForRequestRepository;

	@Override
	public CommentForRequest saveCommentForRequest(CommentForRequest co) {
		return commentForRequestRepository.save(co);
	}

	@Override
	public List<CommentForRequest> listCommentForRequest() {
		return commentForRequestRepository.findAll();
	}

}
