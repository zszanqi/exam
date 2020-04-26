package com.hs.service;


import java.sql.SQLException;
import java.util.List;

import com.hs.model.QuestionSingle;
import com.hs.util.Page;

public interface SingleService {
	public Page<QuestionSingle> getSingleByTitle(String title,Integer curPage);
	
	public String addSingle(String title,String optionA, String optionB,String optionC,String optionD,String answer,Double score) throws SQLException;
	
	public QuestionSingle getSingleById(String id) throws SQLException;

	public String delSingle(String singleId);

	public String editSingle(String id, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, Double score)throws SQLException;

	public List<QuestionSingle> getSingleAll(String title);
}
