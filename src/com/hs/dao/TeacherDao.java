package com.hs.dao;
import java.sql.SQLException;
import java.util.List;
import com.hs.model.Teacher;
import com.hs.util.Page;
public interface TeacherDao {
   public List<Teacher> getTeacherInformation(String Teaname) throws SQLException;
   public List<Teacher> getTeacherByName(String name ,Page page,Integer curPage) throws SQLException;
   public int getTeacherCount(String name) throws SQLException;
}
