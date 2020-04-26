package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hs.dao.PaperClazzDao;
import com.hs.model.ExamClazz;
import com.hs.model.TeacherClazz;
import com.hs.util.C3P0Utils;

public class PaperClazzDaoImpl implements PaperClazzDao {

	private QueryRunner db = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public int saveData(Integer paperId, int clazzId) throws SQLException {
		String sql = "insert into exam_clazz(fk_exam,fk_clazz) values("+paperId+","+clazzId+")";
		return db.update(sql);
	}

	@Override
	public int deleteData(Integer paperId) throws SQLException {
		String sql = "delete from exam_clazz where fk_exam="+paperId;
		return db.update(sql);
	}

	@Override
	public List<ExamClazz> getExamClazzListByPaperId(int paperId) throws SQLException {
		String sql = "select * from exam_clazz where fk_exam="+paperId;
		return db.query(sql, new BeanListHandler<ExamClazz>(ExamClazz.class));
	}

}
