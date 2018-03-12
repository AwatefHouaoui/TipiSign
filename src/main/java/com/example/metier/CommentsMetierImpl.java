package com.example.metier;

import java.util.List;

import com.example.dao.CommentsRepository;
import com.example.entities.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsMetierImpl implements CommentsMetier {

	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public Comments saveComments(Comments co) {
		return commentsRepository.save(co);
	}

	@Override
	public List<Comments> listComments() {
		return commentsRepository.findAll();
	}

}
