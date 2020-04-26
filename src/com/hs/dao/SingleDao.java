package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.QuestionSingle;
import com.hs.util.Page;

public interface SingleDao {
	public List<QuestionSingle> getSingleByTitle(String title,Page page,Integer curPage)throws SQLException;
	public int getSingleCount(String title) throws SQLException;
	public String addSingle(String title, String optionA, String optionB, String optionC, String optionD, String answer,
			Double score) throws SQLException;
	public QuestionSingle getSingleById(String id)throws SQLException;
	public int delSingle(String singleId)throws SQLException;
	public String editSingle(String id, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, Double score)throws SQLException;
	public List<QuestionSingle> getSingleAll(String title) throws SQLException;
}
