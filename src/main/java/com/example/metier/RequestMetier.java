package com.example.metier;

import java.util.List;

import com.example.entities.Request;

public interface RequestMetier {
	public Request saveRequest(Request r);

	public List<Request> listRequest();

}
