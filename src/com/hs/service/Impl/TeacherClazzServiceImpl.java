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
	 * �����ʦ�Ͱ༶�Ĺ�����ϵ
	 */
	@Override
	public String saveData(Integer teaId, String[] clazzIds) {
		String result = null;
		if(clazzIds!=null && clazzIds.length>0) {
			try {
				//��������
				C3P0Utils.startTransaction();
				//��ɾ��ԭ���Ĺ�����Ϣ
				tcDao.deleteData(teaId);
				//�������ڵĹ�����Ϣ
				for(String clazzId:clazzIds) {
					tcDao.saveData(teaId, Integer.parseInt(clazzId));
				}
				//�ύ����
				C3P0Utils.commitAndClose();
				result="ok";
			}catch (Exception e) {
				e.printStackTrace();
				//�����쳣�ع�����
				C3P0Utils.rollbackAndClose();
				result = "error";
			}
			
		}
		return result;
	}
	
	/**
	 * ���ݽ�ʦID��ѯ��ʦ�Ͱ༶�Ĺ�����Ϣ
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
