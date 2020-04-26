package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.SingleDao;
import com.hs.dao.impl.SingleDaoImpl;
import com.hs.model.QuestionSingle;
import com.hs.service.SingleService;
import com.hs.util.Page;

public class SingleServiceImpl implements SingleService{
	
	private SingleDao singleDao = new SingleDaoImpl();
	
	@Override
	public Page<QuestionSingle> getSingleByTitle(String title, Integer curPage) {
		Page page = new Page ();
		try {
			//鏌ヨ褰撳墠椤甸潰瑕佹樉绀虹殑璁板綍鍒楄〃
			List<QuestionSingle> list = singleDao.getSingleByTitle(title, page, curPage);
			//鏌ヨ鎬昏褰曟暟
			int rowsCount = singleDao.getSingleCount(title);
			//灏嗘煡璇㈢粨鏋滃皝瑁呭埌page瀵硅薄涓�
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public String addSingle(String title, String optionA, String optionB, String optionC, String optionD, String answer,
			Double score) throws SQLException {
		return singleDao.addSingle(title, optionA, optionB, optionC, optionD, answer, score);
	}
	
	@Override
	public QuestionSingle getSingleById(String id) throws SQLException {
		return singleDao.getSingleById(id);
	}

	@Override
	public String delSingle(String singleId) {
		String result = null;
		try {
			int rows = singleDao.delSingle(singleId);
			if(rows==1) {
				result="ok";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String editSingle(String id, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, Double score) throws SQLException {
		return singleDao.editSingle(id ,title, optionA, optionB, optionC, optionD, answer, score);
	}

	//获取单选题列表
	@Override
	public List<QuestionSingle> getSingleAll(String title) {
		List<QuestionSingle> list = null;
		try {
			list = singleDao.getSingleAll(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
