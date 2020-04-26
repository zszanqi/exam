package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.TeacherClazz;

public interface TeacherClazzDao {

	public int saveData(Integer teaId,Integer clazzId) throws SQLException;
	
	public List<TeacherClazz> getTeacherClazzListByTeacherId(Integer teaId)  throws SQLException;
	
	public int deleteData(Integer teaId) throws SQLException;
}
