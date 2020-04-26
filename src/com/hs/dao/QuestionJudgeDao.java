package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.QuestionJudge;
import com.hs.util.Page;

public interface QuestionJudgeDao {
	public abstract List<QuestionJudge> getQuestionJudgesByName(String name,Page page,Integer curPage) throws SQLException ;
	public abstract int getQuestionJudgesCount(String name) throws SQLException;
	public abstract int deleteQuestionJudgeById(String id) throws SQLException;
	public abstract int saveQuestionJudge(String name) throws SQLException;
	public abstract QuestionJudge queryByName(String name) throws SQLException;
	public abstract List<QuestionJudge> getQuestionJudgeList() throws SQLException;
	public abstract List<QuestionJudge> getJudgeAll(String title) throws SQLException;
}
