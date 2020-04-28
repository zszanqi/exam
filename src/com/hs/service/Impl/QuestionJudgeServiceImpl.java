package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.QuestionJudgeDao;
import com.hs.dao.impl.QuestionJudgeDaoImpl;
import com.hs.model.QuestionJudge;
import com.hs.model.QuestionMulti;
import com.hs.service.QuestionJudgeService;
import com.hs.util.Page;

public class QuestionJudgeServiceImpl implements QuestionJudgeService{

	private QuestionJudgeDao  qjd = new QuestionJudgeDaoImpl();
	
	//鑾峰彇骞寸骇鍒嗛〉鍒楄〃
	public Page<QuestionJudge> getQuestionJudgeByName(String name,Integer curPage) {
		Page page = new Page();
		List<QuestionJudge> list = null;
		int rowsCount = 0;
		try {
			list = qjd.getQuestionJudgesByName(name,page,curPage);
			rowsCount = qjd.getQuestionJudgesCount(name);
			//灏嗘煡璇㈢粨鏋滃皝瑁呭埌page瀵硅薄涓�
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	
	//通过名称保存判断题
	public String saveQuestionJudgeByName(String name, String answer, Double score) {
		String result = null;
		try {
			//鍒ゆ柇鏀瑰勾绾у悕绉版槸鍚﹀凡瀛樺湪
			QuestionJudge questionjudge = qjd.queryByName(name);
			if(questionjudge!=null) {
				result = "exist";
			}else {
				//涓嶅瓨鍦�,璋冪敤娣诲姞鏂规硶
				int rows = qjd.saveQuestionJudge(name,answer,score);
				if(rows == 1) {
					result = "ok";
				}
			}
		} catch (SQLException e) {
			result = "error";
			e.printStackTrace();
		}
		return result;
	}

	
	//获取判断题列表
	public List<QuestionJudge> getQuestionJudgeList() {
		List<QuestionJudge> list = null;
		try {
			list = qjd.getQuestionJudgeList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//编辑判断题
	@Override
	public boolean editQuestionJudgeByid(int id,String title, String answer, double score) {
		boolean flag = false;
		try {
			qjd.editQuestionJudgeById(id,title,answer,score);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	//通过id删除判断题
	@Override
	public String deleteQuestionJudgeById(String id) {
		String result = null;
		try {
			int rows = qjd.deleteQuestionJudgeById(id);
			if(rows==1) {
				result = "ok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	//获取所有
	@Override
	public List<QuestionJudge> getJudgeAll(String title) {
		List<QuestionJudge> list = null;
		try {
			list = qjd.getJudgeAll(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<QuestionJudge> getQuestionJudgeById(int questionId) {
		List<QuestionJudge> list = null;
		try {
			list = qjd.getQuestionJudgeById(questionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



}
