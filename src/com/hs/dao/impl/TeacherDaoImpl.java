package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hs.dao.TeacherDao;
import com.hs.model.Teacher;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class TeacherDaoImpl implements TeacherDao{
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public List<Teacher> getTeacherInformation(String Teaname) throws SQLException {
		List<Teacher> teacher=null;
		String sql="select * from teacher where 1=1";
		if(Teaname!=null&&!"".equals(Teaname)) {
			sql+=" and realname like'%"+Teaname+"%'";
		}
		teacher=qr.query(sql, new BeanListHandler<Teacher>(Teacher.class));
		return teacher;
	}
	@Override
	public List<Teacher> getTeacherByName(String name, Page page, Integer curPage) throws SQLException {
		String sql = "select * from teacher where 1=1 ";
		if(name!=null&&!"".equals(name)) {
			sql += " and realname like'%"+name+"%'";
			//将查询关键字封装到page对象中
			page.appendParam("name", name);
		}
		sql += " order by id desc limit "+(curPage-1)*page.getPageSize()+","+page.getPageSize();
		return qr.query(sql, new BeanListHandler<Teacher>(Teacher.class));
	}
	@Override
	public int getTeacherCount(String name) throws SQLException {
		String sql = "select count(*) from teacher where 1=1 ";
		if(name!=null&&!"".equals(name)) {
			sql += " and realname like'%"+name+"%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}
	@Override
	public int saveTeacher(String name,String username) throws SQLException {
		String sql = "insert into teacher(realname,username,password) values(?,?,?)";
		return qr.update(sql,name,username,"123456");
	}
	@Override
	public Teacher queryByName(String name) throws SQLException {
		String sql = "select * from teacher where realname='"+name+"'";
		return qr.query(sql, new BeanHandler<Teacher>(Teacher.class));
	}
	@Override
	public void deleteTeacherById(String id) throws SQLException {
		String sql = "delete from teacher where id=?";
		qr.update(sql, id);
	}
	@Override
	public List<Teacher> getTeacherByid(String id) throws SQLException {
		List<Teacher> teacher=null;
		String sql="select * from teacher where id='"+id+"'";
		teacher=qr.query(sql,new BeanListHandler<Teacher>(Teacher.class));
		return teacher;
	}
	@Override
	public void editTeacherByid(String id, String name, String username) throws SQLException {
		String sql="update teacher set realname=?,username=? where id=?";
		qr.update(sql,name,username,id);
	}
	@Override
	public void editpsTeacherByid(String id, String password) throws SQLException {
		String sql="update teacher set password=? where id=?";
		qr.update(sql,password,id);
	}
	
}
