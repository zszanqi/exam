package com.hs.service;

import java.util.List;
import java.util.Map;

import com.hs.util.Page;

public interface PaperService {

	Page getPaper4PerPage(String name, int curPage);
	
	public String setStatus(Integer status,Integer paperId);
	
	public List<Map<String,Object>> ShowQuestionList(String paperId);
	
	public String saveMultiByPaperId(Integer paperId,String[] questionIds);
	
	public String deletePaperById(int paperId);
	
	String addPaperByTitleAndTime(String title, String time,Integer teaId);
	
	String delQuesById(String[] questionIds);

	String saveSingleByPaperId(int paperId, String[] questionIds);

	String saveJudgeByPaperId(int paperId, String[] questionIds);

	String commitPaper(int paperId);

}
