package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.MajorDao;
import com.hs.dao.impl.MajorDaoImpl;
import com.hs.model.Major;
import com.hs.service.MajorService;

public class MajorServiceImpl implements MajorService{
	MajorDao md = new MajorDaoImpl();
	
	
	//查询所有专业列表
	@Override
	public List<Major> getMajorList() {
		List<Major> list = null;
		try {
			list = md.getMajorList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
