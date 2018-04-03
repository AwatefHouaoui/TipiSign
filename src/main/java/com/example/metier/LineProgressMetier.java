package com.example.metier;

import java.util.List;
import com.example.entities.LineProgress;

public interface LineProgressMetier {
	public LineProgress saveLineProgress(LineProgress L);

	public List<LineProgress> listLineProgress();

}
