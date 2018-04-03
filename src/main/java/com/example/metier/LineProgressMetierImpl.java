package com.example.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LineProgressRepository;
import com.example.entities.LineProgress;

@Service
public class LineProgressMetierImpl implements LineProgressMetier{
	
	@Autowired
	LineProgressRepository lineProgressRepository;

	@Override
	public LineProgress saveLineProgress(LineProgress L) {
		return lineProgressRepository.save(L);
	}

	@Override
	public List<LineProgress> listLineProgress() {
		return lineProgressRepository.findAll();
	}

}
