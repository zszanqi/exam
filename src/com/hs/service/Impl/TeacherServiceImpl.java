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
	@Override
	public String saveTeacherByName(String name,String username) {
		String result = null;
		try {
			//判断改教师名称是否已存在
			Teacher Tea = tea.queryByName(name);
			if(Tea!=null) {
				result = "exist";
			}else {
				//不存在,调用添加方法
				int rows = tea.saveTeacher(name,username);
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
	@Override
	public boolean deleteTeacherById(String id) {
		boolean flag = true;
		try {
			tea.deleteTeacherById(id);
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Teacher> getTeacherByid(String id) {
		List<Teacher> Tea=null;
		try {
			Tea=tea.getTeacherByid(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Tea;
	}
	@Override
	public boolean editTeacherByid(String id, String name, String username) {
		boolean flag = true;
		try {
			tea.editTeacherByid(id,name,username);
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean editpsTeacherByid(String id, String password) {
		boolean flag = true;
		try {
			tea.editpsTeacherByid(id,password);
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
}


