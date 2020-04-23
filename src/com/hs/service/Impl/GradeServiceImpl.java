package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.GradeDao;
import com.hs.dao.impl.GradeDaoImpl;
import com.hs.model.Grade;
import com.hs.service.GradeService;
import com.hs.util.Page;

public class GradeServiceImpl implements GradeService{

	private GradeDao  gd = new GradeDaoImpl();
	
	//获取年级分页列表
	@Override
	public Page<Grade> getGradeByName(String name,Integer curPage) {
		Page page = new Page();
		List<Grade> list = null;
		int rowsCount = 0;
		try {
			list = gd.getGradesByName(name,page,curPage);
			rowsCount = gd.getGradesCount(name);
			//将查询结果封装到page对象中
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	//通过id删除年级
	@Override
	public String deleteGradeById(String id) {
		String result = null;
		try {
			int rows = gd.deleteGradeById(id);
			if(rows==1) {
				result = "ok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	//添加年级，不可重复添加
	@Override
	public String saveGradeByName(String name) {
		String result = null;
		try {
			//判断改年级名称是否已存在
			Grade grade = gd.queryByName(name);
			if(grade!=null) {
				result = "exist";
			}else {
				//不存在,调用添加方法
				int rows = gd.saveGrade(name);
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

	
	//获取所有的年级列表
	@Override
	public List<Grade> getGradeList() {
		List<Grade> list = null;
		try {
			list = gd.getGradeList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
