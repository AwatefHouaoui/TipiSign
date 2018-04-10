package com.example.metier;

import java.util.List;

import com.example.dao.RequestRepository;
import com.example.entities.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestMetierImpl implements RequestMetier {

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public Request saveRequest(Request r) {
		return requestRepository.save(r);
	}

	@Override
	public List<Request> listRequest() {
		return requestRepository.findAll();
	}

	@Override
	public Request saveStatusRequest(long id, String status) {
		Request r = requestRepository.findOne(id);
		r.setStatus(status);
		return requestRepository.save(r);
	}

}
