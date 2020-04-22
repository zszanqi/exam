package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.TeacherDao;
import com.hs.dao.impl.TeacherDaoImpl;
import com.hs.model.Teacher;
import com.hs.service.TeacherService;
import com.hs.util.Page;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDao tea=new TeacherDaoImpl();
	@Override
	public List<Teacher> getTeacherInformation(String Teaname) throws SQLException {
	    List<Teacher> teacher=null;
	    try {
			teacher= tea.getTeacherInformation(Teaname);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	@Override
	public Page<Teacher> getTeacherByName(String name, Integer curPage) {
		Page page = new Page();
		try {
			//查询当前页面要显示的记录列表
			List<Teacher> list = tea.getTeacherByName(name,page,curPage);
			//查询总记录数
			int rowsCount = tea.getTeacherCount(name);
			//将查询结果封装到page对象中
			page.setParam(list, curPage, rowsCount);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

}
