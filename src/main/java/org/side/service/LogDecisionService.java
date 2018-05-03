package org.side.service;

import java.util.List;

import org.side.dao.LogDecisionRepository;
import org.side.entities.LogDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogDecisionService {
	@Autowired
	private LogDecisionRepository logDecisionRepository;

	@RequestMapping(value = "/LogDecision", method = RequestMethod.POST)
	public LogDecision saveLogDecision(@RequestBody LogDecision ld) {
		return logDecisionRepository.save(ld);
	}

	@RequestMapping(value = "/getLogDecision", method = RequestMethod.GET)
	public List<LogDecision> listLogDecision() {
		return logDecisionRepository.findAll();
	}
	
}
