package com.hs.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hs.model.Exam;
import com.hs.util.Page;

public interface PaperDao {

	List<Map<String,Object>> getPaperPerPage4(String name, Page page, int curPage) throws SQLException;

	int getPaperCount4Page(String name) throws SQLException;


	public int setStatus(Integer status,Integer paperId) throws Exception;
}
