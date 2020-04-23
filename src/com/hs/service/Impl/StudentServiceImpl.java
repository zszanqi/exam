package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.StudentDao;
import com.hs.dao.impl.StudentDaoImpl;
import com.hs.model.Student;
import com.hs.service.StudentService;
import com.hs.util.MD5Util;
import com.hs.util.Page;

public class StudentServiceImpl implements StudentService{

	private StudentDao sd = new StudentDaoImpl();
	
	/**
	 * 添加学生
	 */
	@Override
	public String saveStudent(Student student) {
		String result = null;
		try {
			//设置默认密码
			student.setPassword(MD5Util.getMD5("666666"));
			//更新学生数据
			int rows = sd.saveStudent(student);
			if(rows==1) {
				result = "ok";
			}
		}catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		return result;
	}
	
	//获取学生页面
	@Override
	public Page<Student> getStudentByName(String name,Integer curPage) {
		Page page = new Page();
		List<Student> list = null;
		int rowsCount = 0;
		try {
			list = sd.getStudentsByName(name,page,curPage);
			rowsCount = sd.getStudentsCount(name);
			//灏嗘煡璇㈢粨鏋滃皝瑁呭埌page瀵硅薄涓�
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	//通过id删除学生
	@Override
	public String deleteStudentById(String id) {
		String result = null;
		try {
			int rows = sd.deleteStudentById(id);
			if(rows==1) {
				result = "ok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	//获取学生列表
	@Override
	public List<Student> getStudentList() {
		List<Student> list = null;
		try {
			list = sd.getStudentList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
