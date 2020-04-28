package com.hs.service;

import java.sql.SQLException;
import java.util.List;
import com.hs.model.Major;
import com.hs.util.Page;


public interface MajorService {
	

	public List<Major> GetAllMajor();
	public String AddMajor(String name);
	public List<Major> getMajorList();
	public Page<Major> getMajorsByName(String name,Page page ,Integer curPage);
	public String saveGrade(String name);
	public String delMajor(int majorId);
}
