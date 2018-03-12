package com.example.metier;

import java.util.List;

import com.example.entities.Comments;

public interface CommentsMetier {
	public Comments saveComments(Comments co);

	public List<Comments> listComments();

}
