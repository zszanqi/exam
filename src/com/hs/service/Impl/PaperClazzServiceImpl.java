package com.hs.service.Impl;

import java.util.List;
import java.util.Map;

import com.hs.dao.PaperClazzDao;
import com.hs.dao.impl.PaperClazzDaoImpl;
import com.hs.model.ExamClazz;
import com.hs.model.TeacherClazz;
import com.hs.service.PaperClazzService;
import com.hs.util.C3P0Utils;

public class PaperClazzServiceImpl implements PaperClazzService {

	private PaperClazzDao pcd = new PaperClazzDaoImpl();
	@Override
	public List<ExamClazz> getPaperClazzListByPaperId(int paperId) {
		List<ExamClazz> list = null;
		try {
			list = pcd.getExamClazzListByPaperId(paperId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String saveData(Integer paperId, String[] clazzIds) {
		String result = null;
		if(clazzIds!=null && clazzIds.length>0) {
			try {
				//开启事务
				C3P0Utils.startTransaction();
				//删除
				pcd.deleteData(paperId);
				//循环保存
				for(String clazzId:clazzIds) {
					pcd.saveData(paperId, Integer.parseInt(clazzId));
				}
				//关闭事务
				C3P0Utils.commitAndClose();
				result="ok";
			}catch (Exception e) {
				e.printStackTrace();
				//回滚
				C3P0Utils.rollbackAndClose();
				result = "error";
			}
			
		}
		return result;
	}


}
