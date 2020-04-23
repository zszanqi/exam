package com.hs.service;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.Teacher;
import com.hs.util.Page;

public interface TeacherService {
      public List<Teacher> getTeacherInformation(String Teaname)throws SQLException;
      public Page<Teacher> getTeacherByName(String name,Integer curPage);
      public String saveTeacherByName(String name,String username,String password);
      public boolean deleteTeacherById(String id);
      public List<Teacher> getTeacherByid(String id);
      public boolean editTeacherByid(String id,String name,String username,String password);
}
