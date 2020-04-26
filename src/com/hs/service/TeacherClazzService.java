package com.hs.service;

import java.util.List;

import com.hs.model.TeacherClazz;

public interface TeacherClazzService {

	public String saveData(Integer teaId,String[] clazzIds);
	
	public List<TeacherClazz> getTeacherClazzListByTeacherId(Integer teaId);
}
