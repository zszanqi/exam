package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.MajorDao;
import com.hs.dao.impl.MajorDaoImpl;
import com.hs.model.Grade;
import com.hs.model.Major;
import com.hs.service.MajorService;
import com.hs.util.Page;

public class MajorServiceImpl implements MajorService{
	
	private MajorDao majorDao = new MajorDaoImpl();
	
	//查询所有专业列表
	@Override
	public List<Major> getMajorList() {
		List<Major> list = null;
		try {
			list = majorDao.getMajorList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
   /*
    * 根据年纪名称查询列表
    * @see com.hs.service.MajorService#getGradesByName(java.lang.String)
    */
	@Override
	public List<Major> getMajorsByName(String name) {
		List<Major> list = null;
		try {
			list = majorDao.getMajorByList(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
	

	

