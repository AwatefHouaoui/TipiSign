package org.side.service;

import java.util.List;

import org.side.dao.LogRequestRepository;
import org.side.entities.LogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogRequestService {
	@Autowired
	private LogRequestRepository logRequestRepository;

	@RequestMapping(value = "/LogRequest", method = RequestMethod.POST)
	public LogRequest saveLogRequest(@RequestBody LogRequest lr) {
		return logRequestRepository.save(lr);
	}

	@RequestMapping(value = "/getLogRequest", method = RequestMethod.GET)
	public List<LogRequest> listLogRequest() {
		return logRequestRepository.findAll();
	}

}
