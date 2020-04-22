package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.util.Page;
import com.hs.model.Grade;

public interface GradeDao {
	public List<Grade> getGradesByName(String name,Page page,Integer curPage) throws SQLException;
	public int getGradesCount(String name) throws SQLException;
	public void deleteGradeById(String id) throws SQLException;
	public int saveGrade(String name) throws SQLException;
	public Grade queryByName(String name) throws SQLException;
	public List<Grade> getGradeList() throws SQLException;
}
