package com.hs.service;

import java.util.List;

import com.hs.model.QuestionJudge;
import com.hs.util.Page;

public interface QuestionJudgeService {
	public abstract Page<QuestionJudge> getQuestionJudgeByName(String name,Integer curPage);

	public abstract String deleteQuestionJudgeById(String id);
	
	public abstract String saveQuestionJudgeByName(String name, String answer, String score);
	
	public abstract List<QuestionJudge> getQuestionJudgeList();

	public abstract List<QuestionJudge> getJudgeAll(String title);
}
