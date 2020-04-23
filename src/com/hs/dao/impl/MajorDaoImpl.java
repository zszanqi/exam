package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.MajorDao;
import com.hs.model.Major;
import com.hs.util.C3P0Utils;


public class MajorDaoImpl implements MajorDao{
	
	private QueryRunner db = new QueryRunner(C3P0Utils.getDataSource());
	private QueryRunner db2 = new QueryRunner(C3P0Utils.getDataSource());
	/**
	 * 查询所有专业列表
	 */
	@Override
	public List<Major> getMajorList() throws SQLException {
		String sql = "select * from major where del_flag=0 order by id desc";
		
		return db.query(sql, new BeanListHandler<Major>(Major.class));
	}
	/**
	 * 根据名称查找专业
	 * @see com.hs.dao.MajorDao#getMajorList(java.lang.String)
	 */
	@Override
	public List<Major> getMajorByList(String name) throws SQLException {
		String sql = "select * from major where 1=1 ";
		if(StringUtils.isNotBlank(name)){
			sql += " and name='"+name+"'";
		}
		sql += " order by id desc";
	   
		List<Major> list=db2.query(sql, new BeanListHandler<Major>(Major.class));
		return list;
	}

}
