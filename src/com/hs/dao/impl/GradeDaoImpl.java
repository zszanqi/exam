package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.GradeDao;
import com.hs.model.Grade;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class GradeDaoImpl implements GradeDao{
	
	//创建数据库操作对象
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	//根据年级名称查询年级列表
	@Override
	public List<Grade> getGradesByName(String name,Page page,Integer curPage) throws SQLException {
		String sql  = "select * from grade where 1=1 ";
		if(StringUtils.isNotBlank(name)) {
			sql +=" and name like '%"+name+"%'";
			page.appendParam("name", name);
		}
		sql += " order by id desc limit "+(curPage-1)*page.getPageSize()+","+page.getPageSize();
		List<Grade> list = qr.query(sql, new BeanListHandler<Grade>(Grade.class));
		return list;
	}

	//查询年级总记录数
	public int getGradesCount(String name) throws SQLException {
		String sql = "select count(*) from grade where 1=1";
		if(StringUtils.isNotBlank(name)) {
			sql += " and name like '%"+name+"%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

	//通过id删除年级
	@Override
	public void deleteGradeById(String id) throws SQLException {
		String sql = "delete from grade where id=?";
		qr.update(sql, id);
	}

	//通过名称添加年级
	@Override
	public int saveGrade(String name) throws SQLException {
		String sql = "insert into grade(name) values('"+name+"')";
		return qr.update(sql);
	}

	//根据年纪名查询年级信息
	@Override
	public Grade queryByName(String name) throws SQLException {
		String sql = "select * from grade where name='"+name+"'";
		return qr.query(sql, new BeanHandler<Grade>(Grade.class));
	}

	//获取年级列表，用于下拉框展示
	@Override
	public List<Grade> getGradeList() throws SQLException {
		String sql = "select * from grade where del_flag=0 order by id desc";
		return qr.query(sql, new BeanListHandler<Grade>(Grade.class));
	}
}
