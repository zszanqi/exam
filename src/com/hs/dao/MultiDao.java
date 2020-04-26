package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.QuestionMulti;
import com.hs.util.Page;

public interface MultiDao {

	public List<QuestionMulti> getMultiByTitle(String title, Page page, Integer curPage)throws SQLException;

	public int getMultiCount(String title)throws SQLException;
		

	public String addMulti(String title, String optionA, String optionB, String optionC, String optionD, String answer,
			Double score)throws SQLException;

	public QuestionMulti getMultiById(String id)throws SQLException;

	public int delMulti(String multiId)throws SQLException; 

	public String editMulti(String id, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, Double score)throws SQLException; 
	public List<QuestionMulti> getMultiAll(String title) throws SQLException;

}
