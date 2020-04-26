package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.PaperDao;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class PaperDaoImpl implements PaperDao {

	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	//分页查询试卷
	@Override
	public List<Map<String,Object>> getPaperPerPage4(String name, Page page, int curPage) throws SQLException {
		String sql = "select t1.id,t1.title,t1.time_limit,t1.fk_status,t2.status from exam t1"
				+" left join exam_status t2 on t1.fk_status=t2.id where t1.del_flag=0";
		//判断查询关键字是否为空
		if(StringUtils.isNotBlank(name)) {
			sql += " and t1.title like '%"+name+"%'";
			page.appendParam("name", name);
		}
		sql += " order by t1.id desc limit " + (curPage - 1) * page.getPageSize() + "," + page.getPageSize();
		return qr.query(sql, new MapListHandler());
	}

	@Override
	public int getPaperCount4Page(String name) throws SQLException {
		String sql = "select count(*) from exam t1 where t1.del_flag=0";
		//判断查询关键字是否为空
		if(StringUtils.isNotBlank(name)) {
			sql += " and t1.title like '%"+name+"%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

	//设置试卷状态
	@Override
	public int setStatus(Integer status, Integer paperId) throws Exception {
		String sql = "update exam set fk_status="+status+" where id="+paperId;
		return qr.update(sql);
	}

	//展示试卷中添加的题目
	@Override
	public List<Map<String, Object>> ShowQuestionList(int paperId) throws SQLException {
		String sql = "select t1.id,t2.type,t3.title from exam_questions t1 "
				+ " left join question_type t2 on t1.fk_qtype=t2.id " //关联题目类型表
				+ " left join question_single t3 on t1.fk_question=t3.id "//关联题目列表
				+ " where t1.fk_exam="+paperId+" and t1.del_flag=0 and t1.fk_qtype=1"
				+ " union all"
				+ " select t4.id,t5.type,t6.title from exam_questions t4 "
				+ " left join question_type t5 on t4.fk_qtype=t5.id " //关联题目类型表
				+ " left join question_multi t6 on t4.fk_question=t6.id "//关联题目列表
				+ " where t4.fk_exam="+paperId+" and t4.del_flag=0 and t4.fk_qtype=2"
				+ " union all"
				+ " select t7.id,t8.type,t9.title from exam_questions t7 "
				+ " left join question_type t8 on t7.fk_qtype=t8.id " //关联题目类型表
				+ " left join question_judge t9 on t7.fk_question=t9.id "//关联题目列表
				+ " where t7.fk_exam="+paperId+" and t7.del_flag=0 and t7.fk_qtype=3";
		return qr.query(sql, new MapListHandler());
	}

	//将多选题添加到指定试卷中
	@Override
	public int saveMultiByPaperId(Integer paperId, Integer questionId) throws SQLException {
		String sql = "insert into exam_questions(fk_exam,fk_question,fk_qtype) "
				+ " values("+paperId+","+questionId+",2)";
		return qr.update(sql);
	}

	//通过id删除试卷
	@Override
	public int deletePaperById(int paperId) throws SQLException {
		String sql = "update exam set del_flag=1 where id="+paperId;
		return qr.update(sql);
	}

	//添加试卷
	@Override
	public int addPaperByTitleAndTime(String title, String time,Integer teaId) throws SQLException {
		String sql = "insert into exam(title,time_limit,fk_status,fk_teacher)"
				+ " values('"+title+"','"+time+"',1,"+teaId+")";
		return qr.update(sql);
	}

	//删除不想要的题目
	@Override
	public void delQuestionById(int questionId) throws SQLException {
		String sql = "update exam_questions set del_flag=1 where id="+questionId;
		qr.update(sql);
	}

	//通过试卷id保存单选题
	@Override
	public int saveSingleByPaperId(int paperId, int questionId) throws SQLException {
		String sql = "insert into exam_questions(fk_exam,fk_question,fk_qtype) "
				+ " values("+paperId+","+questionId+",1)";
		return qr.update(sql);
	}

	//保存选中的判断题
	@Override
	public int saveJudgeByPaperId(int paperId, int questionId) throws SQLException {
		String sql = "insert into exam_questions(fk_exam,fk_question,fk_qtype) "
				+ " values("+paperId+","+questionId+",3)";
		return qr.update(sql);
	}

	//提交初始化的试卷
	@Override
	public int commitPaper(int paperId) throws SQLException {
		String sql = "update exam set fk_status=2 where id="+paperId;
		return qr.update(sql);
	}


}
