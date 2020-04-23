package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.StudentDao;
import com.hs.model.Student;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;


public class StudentDaoImpl implements StudentDao{

	private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	/**
	 * 添加学生
	 */
	@Override
	public int saveStudent(Student student) throws SQLException {
		String sql = "insert into student(username,password,realname,fk_clazz) "
				+ "values('"+student.getUsername()+"','"+student.getPassword()+"','"+student.getRealname()+"',"+student.getFk_clazz()+")";
		return qr.update(sql);
	}
	
	//获取分页数据
	@Override
	public List<Student> getStudentsByName(String name,Page page,Integer curPage) throws SQLException {
		String sql  = "select * from student where del_flag=0 ";
		if(StringUtils.isNotBlank(name)) {
			sql +=" and realname like '%"+name+"%'";
			page.appendParam("realname", name);
		}
		sql += " order by id desc limit "+(curPage-1)*page.getPageSize()+","+page.getPageSize();
		List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	//获取总学生数
	public int getStudentsCount(String name) throws SQLException {
		String sql = "select count(*) from student where del_flag=0";
		if(StringUtils.isNotBlank(name)) {
			sql += " and realname like '%"+name+"%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

	//通过id删除学生
	@Override
	public int deleteStudentById(String id) throws SQLException {
		String sql = "update student set del_flag=1 where id="+id;
		return qr.update(sql);
	}

	//通过名字查找学生
	@Override
	public Student queryByName(String name) throws SQLException {
		String sql = "select * from student where del_flag=0 and realname='"+name+"'";
		return qr.query(sql, new BeanHandler<Student>(Student.class));
	}

	//获取学生列表
	@Override
	public List<Student> getStudentList() throws SQLException {
		String sql = "select * from student where del_flag=0 order by id desc";
		return qr.query(sql, new BeanListHandler<Student>(Student.class));
	}

}
