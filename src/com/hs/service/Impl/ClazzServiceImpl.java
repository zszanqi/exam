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
	

	//删除功能暂不可用，有外键
	@Override
	public boolean deleteClazzById(String id) {
		boolean flag = true;
		try {
			cd.deleteClazzById(id);;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
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

	
}