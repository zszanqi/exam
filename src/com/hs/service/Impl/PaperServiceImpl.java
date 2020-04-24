package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hs.dao.PaperDao;
import com.hs.dao.impl.PaperDaoImpl;
import com.hs.model.Exam;
import com.hs.service.PaperService;
import com.hs.util.Page;

public class PaperServiceImpl implements PaperService {

	private PaperDao pd = new PaperDaoImpl();
	
	//获取试卷分页page对象
	@Override
	public Page getPaper4PerPage(String name, int curPage) {
		Page page = new Page();
		int rowsCount = 0;
		List<Map<String,Object>> list = null;
		try {
			//查询列表数据
			list = pd.getPaperPerPage4(name, page, curPage);
			rowsCount = pd.getPaperCount4Page(name);
			//将查询到的列表数据和总记录数封装到page对象中
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public String setStatus(Integer status, Integer paperId) {
		String result = null;
		int rows = 0;
		try {
			rows = pd.setStatus(status, paperId);
			if(rows ==1) {
				result = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
