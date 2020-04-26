package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.ClazzDao;
import com.hs.model.Clazz;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class ClazzDaoImpl implements ClazzDao {

	// 创建数据库操作对象
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

	// 获取分页数据
	@Override
	public List<Map<String, Object>> getClazzByGradeAndMajor(String gradeName, String majorName, Page page,
			Integer curPage) throws SQLException {
		// 多表关联查询：已clazz为主表，关联到年级和专业表，获取年级和专业名称
		String sql = "select t1.id,t1.cno,t2.name as gradeName,t3.name as majorName from clazz t1 "
				+ "left join grade t2 on t1.fk_grade=t2.id " 
				+ "left join major t3 on t1.fk_major=t3.id where t1.del_flag=0";
		// 判断查询关键字是否为空
		if (StringUtils.isNotBlank(gradeName)) {
			sql += " and t2.name like '%" + gradeName + "%'";
			page.appendParam("gradeName", gradeName);
		}
		if (StringUtils.isNotBlank(majorName)) {
			sql += " and t3.name like '%" + majorName + "%'";
			page.appendParam("majorName", majorName);
		}
		sql += " order by t1.id desc limit " + (curPage - 1) * page.getPageSize() + "," + page.getPageSize();
		return qr.query(sql, new MapListHandler());
	}

	//查询班级总数
	@Override
	public int getClazzCount(String gradeName, String majorName) throws SQLException {
		String sql = "select count(*) from clazz t1 "
				+ "left join grade t2 on t1.fk_grade=t2.id "
				+ "left join major t3 on t1.fk_major=t3.id where t1.del_flag=0";
		// 判断查询关键字是否为空
		if (StringUtils.isNotBlank(gradeName)) {
			sql += " and t2.name like '%" + gradeName + "%'";
		}
		if (StringUtils.isNotBlank(majorName)) {
			sql += " and t3.name like '%" + majorName + "%'";
		}
		Long rowsCount = qr.query(sql, new ScalarHandler<>());
		return rowsCount.intValue();
	}

	//删除班级
	@Override
	public int deleteClazzById(String clazzId) throws SQLException {
		String sql = "update clazz set del_flag=1 where id="+clazzId;
		return qr.update(sql);
	}

	//保存班级信息
	@Override
	public int saveClazz(String gradeId, String majorId, String cno) throws SQLException {
		String sql = "insert into clazz(cno,fk_grade,fk_major) values("+cno+","+gradeId+","+majorId+")";
		return qr.update(sql);
	}

	//验证班级是否已存在
	@Override
	public Clazz getClazzByGidAndMajAndCno(String gradeId, String majorId, String cno) throws SQLException {
		String sql = "select * from clazz where fk_grade="+gradeId+" and fk_major="+majorId
				+" and cno="+cno+" and del_flag=0";
		return qr.query(sql, new BeanHandler<Clazz>(Clazz.class));
	}

	//根据年级和专业id获取班级列表
	@Override
	public List<Clazz> getClazzByGradeIdAndMajorId(int gradeId, int majorId) throws SQLException {
		String sql = "select * from clazz where fk_grade="+gradeId+" and fk_major="+majorId
				+" and del_flag=0";
		return qr.query(sql, new BeanListHandler<Clazz>(Clazz.class));
	}

	//获取所有班级
	@Override
	public List<Map<String, Object>> queryClazzList(String gradeName, String majorName) throws SQLException {
		String sql = "select t1.id,t1.cno,t2.name as gradeName,t3.name as majorName "
				+ " from clazz t1 "
				+ " left join grade t2 on t1.fk_grade=t2.id "
				+ " left join major t3 on t1.fk_major=t3.id where t1.del_flag=0 ";
		//判断查询关键字是否为空
		if(StringUtils.isNotBlank(gradeName)) {
			sql += " and t2.name like '%"+gradeName+"%'";
		}
		if(StringUtils.isNotBlank(majorName)) {
			sql += " and t3.name like '%"+majorName+"%'";
		}
		sql += " order by t1.id desc";
		return qr.query(sql, new MapListHandler());
	}

}
