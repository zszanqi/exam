package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.Exam;
import com.hs.util.Page;

public interface PaperDao {

	List<Exam> getPaperByName(String name, Page page, int curPage) throws SQLException;

	int getPaperCount(String name) throws SQLException;


}
