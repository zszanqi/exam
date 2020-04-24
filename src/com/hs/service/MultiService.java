package com.hs.service;


import java.sql.SQLException;

import com.hs.model.QuestionMulti;
import com.hs.util.Page;

public interface MultiService {

	public Page<QuestionMulti> getMultiByTitle(String title, Integer curPage);

	public String addMulti(String title, String optionA, String optionB, String optionC, String optionD, String answer,
			Double score) throws SQLException;

	public QuestionMulti getMultiById(String id) throws SQLException;

	public String delMulti(String multiId);

	public String editMulti(String id, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, Double score) throws SQLException;
	
}
