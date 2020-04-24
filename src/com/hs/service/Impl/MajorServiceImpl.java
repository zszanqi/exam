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

	MajorDao md = new MajorDaoImpl();
	@Override
	public Page<Major> GetMajorByName(String name,Page page,Integer curPage){
		List<Major> list = null;
		int rowsCount = 0;
		try {
			list = md.GetMajorByName(name, page, curPage);
			rowsCount = md.GetMajorCount(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setParam(list,curPage, rowsCount);
		return page;
	}
	
	public List<Major> GetAllMajor(){
		List<Major> list = null;
		try {
			list = md.GetAllMajor();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String AddMajor(String name){
		String result = null;
		try {
			if(md.GetMajorByName(name)==null){
				int flag = md.AddMajor(name);
				if(flag == 0){
					result = "error";
				}else{
					result = "success";
				}
			}else{
				result = "exist";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
