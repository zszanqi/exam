package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;
import com.hs.dao.QuestionJudgeDao;
import com.hs.model.QuestionJudge;
import com.hs.model.QuestionMulti;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class QuestionJudgeDaoImpl implements QuestionJudgeDao{
	//鍒涘缓鏁版嵁搴撴搷浣滃璞�
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	//获取判断题分页对象
	public List<QuestionJudge> getQuestionJudgesByName(String name,Page page,Integer curPage) throws SQLException {
		String sql  = "select * from question_judge where del_flag=0 ";
		if(StringUtils.isNotBlank(name)) {
			sql +=" and name like '%"+name+"%'";
			page.appendParam("name", name);
		}
		sql += " order by id desc limit "+(curPage-1)*page.getPageSize()+","+page.getPageSize();
		List<QuestionJudge> list = qr.query(sql, new BeanListHandler<QuestionJudge>(QuestionJudge.class));
		return list;
	}

	//获取判断题总页数
	public int getQuestionJudgesCount(String name) throws SQLException {
		String sql = "select count(*) from question_judge where del_flag=0";
		if(StringUtils.isNotBlank(name)) {
			sql += " and name like '%"+name+"%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

	//通过id删除判断题
	public int deleteQuestionJudgeById(String id) throws SQLException {
		String sql = "update question_judge set del_flag=1 where id="+id;
		return qr.update(sql);
	}

	//保存判断题对象
	public int saveQuestionJudge(String name) throws SQLException {
		String sql = "insert into question_judge(name) values('"+name+"')";
		return qr.update(sql);
	}

	//通过姓名查找
	public QuestionJudge queryByName(String name) throws SQLException {
		String sql = "select * from question_judge where del_flag=0 and name='"+name+"'";
		return qr.query(sql, new BeanHandler<QuestionJudge>(QuestionJudge.class));
	}

	//鑾峰彇骞寸骇鍒楄〃锛岀敤浜庝笅鎷夋灞曠ず
	public List<QuestionJudge> getQuestionJudgeList() throws SQLException {
		String sql = "select * from question_judge where del_flag=0 order by id desc";
		return qr.query(sql, new BeanListHandler<QuestionJudge>(QuestionJudge.class));
	}

	//获取所有判断题
	@Override
	public List<QuestionJudge> getJudgeAll(String title) throws SQLException {
		String sql = "select * from question_judge where del_flag=0";
		if(StringUtils.isNotBlank(title)){
			sql +=" and title like'%"+title+"%'";
		}
		sql +=" order by id desc ";
		return qr.query(sql,new BeanListHandler<QuestionJudge>(QuestionJudge.class));
	}
}
