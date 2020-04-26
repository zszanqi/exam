package com.hs.service.Impl;

import java.util.List;

import com.hs.dao.TeacherClazzDao;
import com.hs.dao.impl.TeacherClazzDaoImpl;
import com.hs.model.TeacherClazz;
import com.hs.service.TeacherClazzService;
import com.hs.util.C3P0Utils;

public class TeacherClazzServiceImpl implements TeacherClazzService{

	private TeacherClazzDao tcDao = new TeacherClazzDaoImpl();
	
	/**
	 * 保存教师和班级的关联关系
	 */
	@Override
	public String saveData(Integer teaId, String[] clazzIds) {
		String result = null;
		if(clazzIds!=null && clazzIds.length>0) {
			try {
				//开启事务
				C3P0Utils.startTransaction();
				//先删除原来的关联信息
				tcDao.deleteData(teaId);
				//保存现在的关联信息
				for(String clazzId:clazzIds) {
					tcDao.saveData(teaId, Integer.parseInt(clazzId));
				}
				//提交事务
				C3P0Utils.commitAndClose();
				result="ok";
			}catch (Exception e) {
				e.printStackTrace();
				//发生异常回滚事务
				C3P0Utils.rollbackAndClose();
				result = "error";
			}
			
		}
		return result;
	}
	
	/**
	 * 根据教师ID查询教师和班级的关联信息
	 */
	@Override
	public List<TeacherClazz> getTeacherClazzListByTeacherId(Integer teaId) {
		List<TeacherClazz> list = null;
		try {
			list = tcDao.getTeacherClazzListByTeacherId(teaId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
