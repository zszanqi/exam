package com.hs.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hs.model.Exam;
import com.hs.util.Page;

public interface PaperDao {

	public List<Map<String,Object>> getPaperPerPage4(String name, Page page, int curPage) throws SQLException;

	public int getPaperCount4Page(String name) throws SQLException;

	public int setStatus(Integer status,Integer paperId) throws Exception;
	
	public List<Map<String,Object>> ShowQuestionList(int paperId) throws SQLException;
	
	public int saveMultiByPaperId(Integer paperId,Integer questionId) throws SQLException;

	public int deletePaperById(int paperId) throws SQLException;

	public int addPaperByTitleAndTime(String title, String time,Integer teaId) throws SQLException;

	public void delQuestionById(int questionId) throws SQLException;

	public int saveSingleByPaperId(int paperId, int questionId) throws SQLException;

	public int saveJudgeByPaperId(int paperId, int questionId) throws SQLException;

	public int commitPaper(int paperId) throws SQLException;

}
