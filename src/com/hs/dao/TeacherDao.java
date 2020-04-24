package com.hs.dao;
import java.sql.SQLException;
import java.util.List;

import com.hs.model.Teacher;
import com.hs.util.Page;
public interface TeacherDao {
   public List<Teacher> getTeacherInformation(String Teaname) throws SQLException;
   public List<Teacher> getTeacherByName(String name ,Page page,Integer curPage) throws SQLException;
   public int getTeacherCount(String name) throws SQLException;
   public void deleteTeacherById(String id) throws SQLException;
   public int saveTeacher(String name,String username) throws SQLException;
   public Teacher queryByName(String name) throws SQLException;
   public List<Teacher> getTeacherByid(String id) throws SQLException;
   public void editTeacherByid(String id,String name,String username) throws SQLException;
   public void editpsTeacherByid(String id, String password) throws SQLException;
}
