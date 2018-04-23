package com.example.service;

import java.util.List;
import com.example.dao.RequestRepository;
import com.example.entities.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestService {
	@Autowired
	private RequestRepository requestRepository;

	@RequestMapping(value = "/Request", method = RequestMethod.POST)
	public Request saveRequest(@RequestBody Request r) {
		return requestRepository.save(r);
	}

	@RequestMapping(value = "/getRequest", method = RequestMethod.GET)
	public List<Request> listRequest() {
		return requestRepository.findAll();
	}

	@RequestMapping(value = "/getRequestsById", method = RequestMethod.GET)
	public List<Request> findPendingRequestByToUser(@RequestParam(name = "userId") String userId) {
		return requestRepository.findPendingRequestByToUser(userId);
	}

	@RequestMapping(value = "/getMyRequests", method = RequestMethod.GET)
	public List<Request> findMyRequests(@RequestParam(name = "userId") String userId) {
		return requestRepository.findMyRequests(userId);
	}

}
