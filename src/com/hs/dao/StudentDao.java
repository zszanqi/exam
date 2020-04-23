package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.Student;
import com.hs.util.Page;

public interface StudentDao {
	
	public int saveStudent(Student student) throws SQLException;

	public List<Student> getStudentsByName(String name,Page page,Integer curPage) throws SQLException;
	public int getStudentsCount(String name) throws SQLException;
	public int deleteStudentById(String id) throws SQLException;
	public Student queryByName(String name) throws SQLException;
	public List<Student> getStudentList() throws SQLException;
}
