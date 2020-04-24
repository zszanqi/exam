package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.Major;
import com.hs.util.Page;

public interface MajorDao {
	
	public List<Major> GetMajorByName(String name,Page page,Integer CurPage) throws SQLException;

	public int GetMajorCount(String name) throws SQLException;
	
	public List<Major> GetAllMajor() throws SQLException;
	
	public Major GetMajorByName(String name)throws SQLException;
	
	public int AddMajor(String name)throws SQLException;
}
