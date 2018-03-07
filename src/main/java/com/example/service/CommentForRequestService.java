package com.example.service;

import java.util.List;

import com.example.entities.CommentForRequest;
import com.example.metier.CommentForRequestMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentForRequestService {
	@Autowired
	private CommentForRequestMetier commentForRequestMetier;

	@RequestMapping(value = "/Comment", method = RequestMethod.POST)
	public CommentForRequest saveCommentForRequest(@RequestBody CommentForRequest co) {
		return commentForRequestMetier.saveCommentForRequest(co);
	}

	@RequestMapping(value = "/getComment", method = RequestMethod.GET)
	public List<CommentForRequest> listCommentForRequest() {
		return commentForRequestMetier.listCommentForRequest();
	}

}
