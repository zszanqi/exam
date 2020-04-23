package com.hs.service;

import java.util.List;

import com.hs.model.Clazz;
import com.hs.util.Page;

public interface ClazzService {

	public String deleteClazzById(String id);
	public Page<Clazz> getClazzByGradeAndMajor(String gradeName, String majorName, int curPage);
	public String saveClazz(String gradeId,String majorId,String cno);
	public List<Clazz> getClazzListByGradeIdAndMajorId(int gradeId, int majorId);
}
