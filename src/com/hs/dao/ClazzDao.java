package com.hs.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hs.model.Clazz;
import com.hs.util.Page;

public interface ClazzDao {
	public List<Map<String,Object>> getClazzByGradeAndMajor(String gradeName,String majorName,Page page,Integer curPage) throws SQLException;
	public int getClazzCount(String gradeName,String majorName) throws SQLException;
	public int deleteClazzById(String ClazzId) throws SQLException;
	public int saveClazz(String gradeId,String majorId,String cno) throws SQLException;
	public Clazz getClazzByGidAndMajAndCno(String gradeId,String majorId,String cno) throws SQLException;
	public List<Clazz> getClazzByGradeIdAndMajorId(int gradeId, int majorId) throws SQLException;
	public List<Map<String,Object>> queryClazzList(String gradeName,String majorName) throws SQLException;
}
