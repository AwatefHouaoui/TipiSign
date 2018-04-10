package com.example.service;

import java.util.List;

import com.example.dao.RequestRepository;
import com.example.entities.Request;
import com.example.metier.RequestMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestService {
	@Autowired
	private RequestMetier requestMetier;

	@Autowired
	 RequestRepository requestRepository;


	@RequestMapping(value = "/Request", method = RequestMethod.POST)
	public Request saveRequest(@RequestBody Request r) {
		return requestMetier.saveRequest(r);
	}

	@RequestMapping(value = "/getRequest", method = RequestMethod.GET)
	public List<Request> listRequest() {
		return requestMetier.listRequest();
	}

	@RequestMapping(value = "/editRequest/{id}", method = RequestMethod.PUT)
	public Request saveStatusRequest(@PathVariable long id,@RequestBody Request r) {
		r.getStatus();
		return requestRepository.save(r);
	}
	
	

}
