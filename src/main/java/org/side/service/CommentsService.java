package org.side.service;

import java.util.List;

import org.side.dao.CommentsRepository;
import org.side.entities.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsService {
	@Autowired
	private CommentsRepository commentsRepository;

	@RequestMapping(value = "/Comments", method = RequestMethod.POST)
	public Comments saveComments(@RequestBody Comments co) {
		return commentsRepository.save(co);
	}

	@RequestMapping(value = "/getComments", method = RequestMethod.GET)
	public List<Comments> listComments() {
		return commentsRepository.findAll();
	}

}
