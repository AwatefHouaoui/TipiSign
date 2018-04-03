package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.LineProgress;
import com.example.metier.LineProgressMetier;

@RestController
public class LineProgressService {
	
	@Autowired
	LineProgressMetier lineProgressMetier;

	@RequestMapping(value = "/LineProgress", method = RequestMethod.POST)
	public LineProgress saveLineProgress(LineProgress L) {
		return lineProgressMetier.saveLineProgress(L);
	}

	@RequestMapping(value = "/getLineProgress", method = RequestMethod.GET)
	public List<LineProgress> listLineProgress() {
		return lineProgressMetier.listLineProgress();
	}
	
}
