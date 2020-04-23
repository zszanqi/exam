package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.PaperDao;
import com.hs.model.Exam;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class PaperDaoImpl implements PaperDao {

	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	//获取试卷列表
	@Override
	public List<Exam> getPaperByName(String name, Page page, int curPage) throws SQLException {
		String sql = "select id,title,time_limit,fk_status from exam where del_flag=0 ";
		//判断查询关键字是否为空
		if(StringUtils.isNotBlank(name)) {
			sql += " and title like '%"+name+"%'";
			page.appendParam("name", name);
		}
		sql += " order by id desc limit " + (curPage - 1) * page.getPageSize() + "," + page.getPageSize();
		return qr.query(sql, new BeanListHandler<Exam>(Exam.class));
	}

	@Override
	public int getPaperCount(String name) throws SQLException {
		String sql = "select count(*) from exam where del_flag=0 ";
		//判断查询关键字是否为空
		if(StringUtils.isNotBlank(name)) {
			sql += " and title like '%"+name+"%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

}
