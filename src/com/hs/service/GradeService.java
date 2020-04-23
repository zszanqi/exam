package com.hs.service;

import java.util.List;

import com.hs.model.Grade;
import com.hs.util.Page;

public interface GradeService {
	public Page<Grade> getGradeByName(String name,Integer curPage);

	public String deleteGradeById(String id);
	
	public String saveGradeByName(String name);
	
	public List<Grade> getGradeList();
}
