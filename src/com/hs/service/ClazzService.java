package com.hs.service;

import com.hs.model.Clazz;
import com.hs.util.Page;

public interface ClazzService {

	public boolean deleteClazzById(String id);
	public Page<Clazz> getClazzByGradeAndMajor(String gradeName, String majorName, int curPage);
	public String saveClazz(String gradeId,String majorId,String cno);
}
