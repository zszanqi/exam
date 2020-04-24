package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.MultiDao;
import com.hs.dao.impl.MultiDaoImpl;
import com.hs.model.QuestionMulti;
import com.hs.service.MultiService;
import com.hs.util.Page;

public class MultiServiceImpl implements MultiService{
	
	private MultiDao multiDao = new MultiDaoImpl();
	
	@Override
	public Page<QuestionMulti> getMultiByTitle(String title, Integer curPage) {
		Page page = new Page ();
		try {
			//查询当前页面要显示的记录列表
			List<QuestionMulti> list = multiDao.getMultiByTitle(title, page, curPage);
			//查询总记录数
			int rowsCount = multiDao.getMultiCount(title);
			//将查询结果封装到page对象中
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public String addMulti(String title, String optionA, String optionB, String optionC, String optionD, String answer,
			Double score) throws SQLException {
		return multiDao.addMulti(title, optionA, optionB, optionC, optionD, answer, score);
	}
	
	@Override
	public QuestionMulti getMultiById(String id) throws SQLException {
		return multiDao.getMultiById(id);
	}

	@Override
	public String delMulti(String multiId) {
		String result = null;
		try {
			int rows = multiDao.delMulti(multiId);
			if(rows==1) {
				result="ok";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String editMulti(String id, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, Double score) throws SQLException {
		return multiDao.editMulti(id ,title, optionA, optionB, optionC, optionD, answer, score);
	}
}
