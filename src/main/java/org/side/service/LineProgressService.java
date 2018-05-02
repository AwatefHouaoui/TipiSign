package org.side.service;

import java.util.List;

import org.side.dao.LineProgressRepository;
import org.side.entities.LineProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineProgressService {

	@Autowired
	LineProgressRepository lineProgressRepository;

	@RequestMapping(value = "/LineProgress", method = RequestMethod.POST)
	public LineProgress saveLineProgress(LineProgress L) {
		return lineProgressRepository.save(L);
	}

	@RequestMapping(value = "/getLineProgress", method = RequestMethod.GET)
	public List<LineProgress> listLineProgress() {
		return lineProgressRepository.findAll();
	}

}
