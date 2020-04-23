package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.PaperDao;
import com.hs.dao.impl.PaperDaoImpl;
import com.hs.model.Exam;
import com.hs.service.PaperService;
import com.hs.util.Page;

public class PaperServiceImpl implements PaperService {

	private PaperDao pd = new PaperDaoImpl();
	
	
	//获取试卷分页列表
	@Override
	public Page getPaperByName(String name, int curPage) {
		Page page = new Page();
		List<Exam> list = null;
		int rowsCount = 0;
		try {
			list = pd.getPaperByName(name,page,curPage);
			rowsCount = pd.getPaperCount(name);
			//将查询到的结果封装到page对象中
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

}
