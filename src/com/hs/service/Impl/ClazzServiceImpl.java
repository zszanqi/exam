package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hs.dao.ClazzDao;
import com.hs.dao.impl.ClazzDaoImpl;
import com.hs.model.Clazz;
import com.hs.service.ClazzService;
import com.hs.util.Page;

public class ClazzServiceImpl implements ClazzService{

	private ClazzDao cd = new ClazzDaoImpl();
	//分页查询班级列表
	@Override
	public Page<Clazz> getClazzByGradeAndMajor(String gradeName, String majorName, int curPage) {
		Page page = new Page();
		List<Map<String,Object>> list = null;
		int rowsCount = 0;
		try {
			list = cd.getClazzByGradeAndMajor(gradeName, majorName, page, curPage);
			rowsCount = cd.getClazzCount(gradeName, majorName);
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}
	

	//删除班级
	@Override
	public String deleteClazzById(String id) {
		String result = null;
		try {
			int rows = cd.deleteClazzById(id);
			if(rows==1) {
				result = "ok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//保存班级信息
	@Override
	public String saveClazz(String gradeId, String majorId, String cno) {
		String result = null;
		try {
			Clazz clazz = cd.getClazzByGidAndMajAndCno(gradeId, majorId, cno);
			if(clazz!=null) {//已存在
				result = "exist";
			}else {//不存在
				int rows = cd.saveClazz(gradeId, majorId, cno);
				if(rows == 1) {
					result = "ok";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//根据年级序号和专业序号获取班级列表
	@Override
	public List<Clazz> getClazzListByGradeIdAndMajorId(int gradeId, int majorId) {
		List<Clazz> list = null;
		try {
			list = cd.getClazzByGradeIdAndMajorId(gradeId,majorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//获取所有班级
	@Override
	public List<Map<String, Object>> getClazzAll(String gradeName, String majorName) {
		List<Map<String,Object>> list = null;
		try {
			list = cd.queryClazzList(gradeName, majorName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
