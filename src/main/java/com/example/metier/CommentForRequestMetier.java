package com.example.metier;

import java.util.List;

import com.example.entities.CommentForRequest;

public interface CommentForRequestMetier {
	public CommentForRequest saveCommentForRequest(CommentForRequest co);

	public List<CommentForRequest> listCommentForRequest();

}
