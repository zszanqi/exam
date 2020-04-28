package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.MultiDao;
import com.hs.model.QuestionMulti;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class MultiDaoImpl implements MultiDao {

	//获取数据库操作对象
	private QueryRunner db = new QueryRunner(C3P0Utils.getDataSource());

	/**
	 * 根据题目名模糊查询题目，分页显示
	 */
	@Override
	public List<QuestionMulti> getMultiByTitle(String title, Page page, Integer curPage)throws SQLException {
		String sql = "select * from question_multi where del_flag=0";
		if(StringUtils.isNotBlank(title)){
			sql +=" and title like'%"+title+"%'";
			//查询关键字封装到page对象中
			page.appendParam("title", title);
		}
		sql +=" order by id desc limit "+(curPage-1)*page.getPageSize()+","+page.getPageSize();
		return db.query(sql,new BeanListHandler<QuestionMulti>(QuestionMulti.class));
	}

	/**
	 * 查询题目总记录(分页统计共多少页可用）
	 */
	public int getMultiCount(String title)throws SQLException{
		String sql = "select count(*) from question_multi where del_flag=0";
		if(StringUtils.isNotBlank(title)){
			sql +=" and title like'%"+title+"%'";
		}
		Long rowsCount = db.query(sql,new ScalarHandler<>());
		return rowsCount.intValue();
	}

	/**
	 * 添加题目
	 */
	@Override
	public String addMulti(String title, String optionA, String optionB, String optionC, String optionD, String answer,
			Double score)throws SQLException{
		String sql = "select count(*) from question_multi where del_flag=0 and title= '"+title+"'";
		Long num = db.query(sql,new ScalarHandler<>());
		if(num.intValue()==0){
			//写sql
			String sql1 = "insert into question_multi(title,optionA,optionB,optionC,optionD,answer,score,del_flag) values(?,?,?,?,?,?,?,?) ";
			//执行添加
			db.update(sql1,title,optionA,optionB,optionC,optionD,answer,score,0);
			return "ok";
		}else{
			return "exist";
		}
	}
	
	/**
	 * 根据id查询题目
	 */
	@Override
	public QuestionMulti getMultiById(String id)throws SQLException {
		String sql = "select * from question_multi where id = ?";
		return db.query(sql, new BeanHandler<>(QuestionMulti.class), id);
	}
	
	/**
	 * 修改多选
	 */
	@Override
	public String editMulti(String id, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, Double score)throws SQLException {
		String sql1 = "update question_multi set title = ?,optionA = ?,optionB = ?,optionC = ?,optionD = ?,answer = ?,score = ? where id = ?";
		db.update(sql1,title,optionA,optionB,optionC,optionD,answer,score,id);
		return "ok";
	}
	
	/**
	 * 删除多选
	 */
	@Override
	public int delMulti(String multiId)throws SQLException {
		String sql = "update question_multi set del_flag=1 where id="+multiId;
		return db.update(sql);
	}

	@Override
	public List<QuestionMulti> getMultiAll(String title) throws SQLException {
		String sql = "select * from question_multi where del_flag=0";
		if(StringUtils.isNotBlank(title)){
			sql +=" and title like'%"+title+"%'";
		}
		sql +=" order by id desc ";
		return db.query(sql,new BeanListHandler<QuestionMulti>(QuestionMulti.class));
	}

}
