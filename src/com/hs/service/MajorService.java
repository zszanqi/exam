package com.hs.service;

import java.sql.SQLException;
import java.util.List;
import com.hs.model.Major;


public interface MajorService {
	

	public List<Major> getMajorList();
	public List<Major> getMajorsByName(String name);
}
