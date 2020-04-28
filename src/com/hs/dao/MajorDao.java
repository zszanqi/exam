package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.Grade;
import com.hs.model.Major;
import com.hs.util.Page;

public interface MajorDao {
	public List<Major> getMajorList() throws SQLException;
	public List<Major> getMajorsByName(String name,Page page,Integer curPage)throws SQLException;
	public int getMajorsCount(String name)throws SQLException;
	public Major queryByName(String name) throws SQLException;
	public int saveMajor(String name) throws SQLException;
	public int delMajor(int majorId) throws SQLException;
	public List<Major> GetAllMajor() throws SQLException;
	
	public Major GetMajorByName(String name)throws SQLException;
	
	public int AddMajor(String name)throws SQLException;
}
