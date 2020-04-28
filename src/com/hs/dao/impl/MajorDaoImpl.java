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
	
	private QueryRunner db = new QueryRunner(C3P0Utils.getDataSource());
	private QueryRunner db2 = new QueryRunner(C3P0Utils.getDataSource());
	private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	/**
	 * 查询所有专业列表
	 */
	@Override
	public List<Major> getMajorList() throws SQLException {
		String sql = "select * from major where del_flag=0 order by id desc";
		
		return db.query(sql, new BeanListHandler<Major>(Major.class));
	}
	/*
	 * 根据专业名称查询专业列表
	 * @see com.hs.dao.MajorDao#getMajorsByName(java.lang.String, com.hs.utils.Page, java.lang.Integer)
	 */
	
	@Override
	public List<Major> getMajorsByName(String name, Page page, Integer curPage) throws SQLException {
		String sql = "select * from major where 1=1";
		if(StringUtils.isNotBlank(name))
		{
			sql += " and name like'%"+name+"%'";
			//将查询对象封装在page对象中
			page.appendParam("name", name);
		}
		sql += " order by id desc limit "+(curPage-1)*page.getPageSize()+","+page.getPageSize();
		List<Major> list=db.query(sql, new BeanListHandler<Major>(Major.class));
		return list;
	}
	/*/
	 * 查询专业总记录数
	 * @see com.hs.dao.MajorDao#getMajorsCount(java.lang.String)
	 */
	@Override
	public int getMajorsCount(String name) throws SQLException {
		String sql = "select count(*) from major where 1=1";
		if(StringUtils.isNotBlank(name)){
			sql += " and name like '%"+name+"%'";
		}
		Long rowsCount=db.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

	@Override
	public Major queryByName(String name)throws SQLException {
		String sql = "select * from major where name='"+name+"'";
		return  db.query(sql, new BeanHandler<Major>(Major.class));
	}
    /**
     * 保存专业信息
     * @see com.hs.dao.MajorDao#saveMajor(java.lang.String)
     */
	@Override
	public int saveMajor(String name)throws SQLException {
		String sql = "insert into major(name) values('"+name+"')";
		return db.update(sql);
	}

	@Override
	public int delMajor(int majorId) throws SQLException {
		String sql = "DELETE FROM major WHERE id="+majorId;
		return db.update(sql);
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
