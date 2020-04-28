package com.hs.service;

import java.util.List;

import com.hs.model.QuestionJudge;
import com.hs.util.Page;

public interface QuestionJudgeService {
	public abstract Page<QuestionJudge> getQuestionJudgeByName(String name,Integer curPage);

	public abstract String deleteQuestionJudgeById(String id);
	
	public abstract String saveQuestionJudgeByName(String name, String answer, Double score);
	
	public abstract List<QuestionJudge> getQuestionJudgeList();

	public abstract List<QuestionJudge> getJudgeAll(String title);

	public abstract boolean editQuestionJudgeByid(int id,String title, String answer, double score);

	public abstract List<QuestionJudge> getQuestionJudgeById(int questionId);
}
