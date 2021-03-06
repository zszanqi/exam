package com.hs.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hs.dao.LoginDao;
import com.hs.model.Manager;
import com.hs.model.Student;
import com.hs.model.Teacher;
import com.hs.util.C3P0Utils;

public class LoginDaoImpl implements LoginDao{

	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	//登陆验证
	@Override
	public Object login(Integer roleId, String username, String password) throws SQLException {
		String sql = null;
		Object obj = null;
		if(roleId == 1) {//学生
			sql = "select * from student where username='"+username+"' and password='"+password+"' and del_flag=0";
			obj = qr.query(sql, new BeanHandler<Student>(Student.class));
		}
		if(roleId == 2) {//教师
			sql = "select * from teacher where username='"+username+"' and password='"+password+"' and del_flag=0";
			obj = qr.query(sql, new BeanHandler<Teacher>(Teacher.class));
		}
		if(roleId == 3) {
			sql = "select * from manager where username='"+username+"' and password='"+password+"'";
			obj = qr.query(sql, new BeanHandler<Manager>(Manager.class));
		}
		return obj;
	}

	//更新密码
	@Override
	public int updatePassword(Integer roleId, String newPwd, Integer userId) throws SQLException {
		String sql = "";
		int result = 0;
		if(roleId == 1) {//学生
			sql = "update student set password='"+newPwd+"' , modified=1 where id="+userId;
			result = qr.update(sql);
		}
		if(roleId == 2) {//教师
			sql = "update teacher set password='"+newPwd+"' , modified=1 where id="+userId;
			result = qr.update(sql); 
		}
		if(roleId == 3) {//管理员
			sql = "update manager set password='"+newPwd+"' , modified=1 where id="+userId;
			result = qr.update(sql);
		}
		return result;
	}
	
}
