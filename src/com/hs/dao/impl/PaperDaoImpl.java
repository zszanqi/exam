package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
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

}
