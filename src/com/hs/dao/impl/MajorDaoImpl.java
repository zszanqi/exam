package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.MajorDao;
import com.hs.model.Grade;
import com.hs.model.Major;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class MajorDaoImpl implements MajorDao{

	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public List<Major> GetMajorByName(String name,Page page,Integer CurPage) throws SQLException {
		String sql = "select * from major where 1=1";
		if(name!=null&&!"".equals(name)){
			sql+=" and name like '%"+name+"%'";
			page.appendParam("name", name);
		}
		sql+=" order by id desc limit "+(CurPage-1)*page.getPageSize()+" , "+page.getPageSize();
		List<Major> list = qr.query(sql,new BeanListHandler<Major>(Major.class));
		return list;
	}
	@Override
	public int GetMajorCount(String name) throws SQLException {
		String sql = "select count(*) from major where 1=1 ";
		if(StringUtils.isNotBlank(name)){
			sql+=" and name like'%"+name+"%'";
		}		
		Long count = qr.query(sql,new ScalarHandler<>());
		return count.intValue();
	}
	@Override
	public List<Major> GetAllMajor() throws SQLException {
		List<Major> list = null;
		String sql = "select * from major where del_flag = 0";
		list = qr.query(sql,new BeanListHandler<Major>(Major.class));
		return list;
	}
	@Override
	public Major GetMajorByName(String name) throws SQLException {
		String sql = "select * from major where name = '"+name+"'";
		return qr.query(sql,new BeanHandler<Major>(Major.class));
	}
	@Override
	public int AddMajor(String name) throws SQLException {
		String sql = "insert into major(name) values('"+name+"')";
		return qr.update(sql);
	}
	
	
	
}
