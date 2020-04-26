package com.hs.service;

import java.util.List;
import java.util.Map;

import com.hs.model.ExamClazz;

public interface PaperClazzService {


	List<ExamClazz> getPaperClazzListByPaperId(int paperId);

	public String saveData(Integer paperId,String[] clazzIds);
	
}
