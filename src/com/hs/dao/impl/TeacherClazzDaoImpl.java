package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hs.dao.TeacherClazzDao;
import com.hs.model.TeacherClazz;
import com.hs.util.C3P0Utils;

public class TeacherClazzDaoImpl implements TeacherClazzDao{

	private QueryRunner db = new QueryRunner(C3P0Utils.getDataSource());
	
	/**
	 * �����ʦ�Ͱ༶�Ĺ�����Ϣ
	 */
	@Override
	public int saveData(Integer teaId, Integer clazzId) throws SQLException {
		String sql = "insert into teacher_clazz(fk_teacher,fk_clazz) values("+teaId+","+clazzId+")";
		return db.update(sql);
	}
	
	/**
	 * ���ݽ�ʦID��ѯ��ʦ�Ͱ༶�Ĺ�����Ϣ
	 */
	@Override
	public List<TeacherClazz> getTeacherClazzListByTeacherId(Integer teaId) throws SQLException {
		String sql = "select * from teacher_clazz where fk_teacher="+teaId;
		return db.query(sql, new BeanListHandler<TeacherClazz>(TeacherClazz.class));
	}
	
	/**
	 * ɾ��������Ϣ
	 */
	@Override
	public int deleteData(Integer teaId) throws SQLException {
		String sql = "delete from teacher_clazz where fk_teacher="+teaId;
		return db.update(sql);
	}
}
