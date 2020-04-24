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
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class QuestionJudgeDaoImpl implements QuestionJudgeDao{
	//鍒涘缓鏁版嵁搴撴搷浣滃璞�
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	//鏍规嵁骞寸骇鍚嶇О鏌ヨ骞寸骇鍒楄〃
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

	//鏌ヨ骞寸骇鎬昏褰曟暟
	public int getQuestionJudgesCount(String name) throws SQLException {
		String sql = "select count(*) from question_judge where del_flag=0";
		if(StringUtils.isNotBlank(name)) {
			sql += " and name like '%"+name+"%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

	//閫氳繃id鍒犻櫎骞寸骇
	public int deleteQuestionJudgeById(String id) throws SQLException {
		String sql = "update question_judge set del_flag=1 where id="+id;
		return qr.update(sql);
	}

	//閫氳繃鍚嶇О娣诲姞骞寸骇
	public int saveQuestionJudge(String name) throws SQLException {
		String sql = "insert intoquestion_judge(name) values('"+name+"')";
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
}
