package com.hs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.hs.dao.SingleDao;
import com.hs.model.QuestionSingle;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class SingleDaoImpl implements SingleDao{
	//鑾峰彇鏁版嵁搴撴搷浣滃璞�
		private QueryRunner db = new QueryRunner(C3P0Utils.getDataSource());

		/**
		 * 鏍规嵁棰樼洰鍚嶆ā绯婃煡璇㈤鐩紝鍒嗛〉鏄剧ず
		 */
		@Override
		public List<QuestionSingle> getSingleByTitle(String title, Page page, Integer curPage) throws SQLException {
			String sql = "select * from question_single where del_flag=0";
			if(StringUtils.isNotBlank(title)){
				sql +=" and title like'%"+title+"%'";
				//鏌ヨ鍏抽敭瀛楀皝瑁呭埌page瀵硅薄涓�
				page.appendParam("title", title);
			}
			sql +=" order by id desc limit "+(curPage-1)*page.getPageSize()+","+page.getPageSize();
			return db.query(sql,new BeanListHandler<QuestionSingle>(QuestionSingle.class));
		}

		/**
		 * 鏌ヨ棰樼洰鎬昏褰�(鍒嗛〉缁熻鍏卞灏戦〉鍙敤锛�
		 */
		public int getSingleCount(String title) throws SQLException{
			String sql = "select count(*) from question_single where del_flag=0";
			if(StringUtils.isNotBlank(title)){
				sql +=" and title like'%"+title+"%'";
			}
			Long rowsCount = db.query(sql,new ScalarHandler<>());
			return rowsCount.intValue();
		}

		/**
		 * 娣诲姞棰樼洰
		 */
		@Override
		public String addSingle(String title,String optionA, String optionB,String optionC,String optionD,String answer,Double score) throws SQLException {
			String sql = "select count(*) from question_single where del_flag=0 and title= '"+title+"'";
			Long num = db.query(sql,new ScalarHandler<>());
			if(num.intValue()==0){
				//鍐檚ql
				String sql1 = "insert into question_single(title,optionA,optionB,optionC,optionD,answer,score,del_flag) values(?,?,?,?,?,?,?,?) ";
				//鎵ц娣诲姞
				db.update(sql1,title,optionA,optionB,optionC,optionD,answer,score,0);
				return "ok";
			}else{
				return "exist";
			}
			
		}
		
		/**
		 * 鏍规嵁id鏌ヨ棰樼洰
		 */
		@Override
		public QuestionSingle getSingleById(String id) throws SQLException {
			String sql = "select * from question_single where id = ?";
			return db.query(sql, new BeanHandler<>(QuestionSingle.class), id);
		}
		
		/**
		 * 淇敼鍗曢��
		 */
		@Override
		public String editSingle(String id, String title, String optionA, String optionB, String optionC,
				String optionD, String answer, Double score) throws SQLException {
			String sql1 = "update question_single set title = ?,optionA = ?,optionB = ?,optionC = ?,optionD = ?,answer = ?,score = ? where id = ?";
			db.update(sql1,title,optionA,optionB,optionC,optionD,answer,score,id);
			return "ok";
		}
		
		/**
		 * 鍒犻櫎鍗曢��
		 */
		@Override
		public int delSingle(String singleId) throws SQLException {
			String sql = "update question_single set del_flag=1 where id="+singleId;
			return db.update(sql);
		}
		//获取单选题列表
		@Override
		public List<QuestionSingle> getSingleAll(String title) throws SQLException {
			String sql = "select * from question_single where del_flag=0";
			if(StringUtils.isNotBlank(title)){
				sql +=" and title like'%"+title+"%'";
			}
			sql +=" order by id desc ";
			return db.query(sql,new BeanListHandler<QuestionSingle>(QuestionSingle.class));
		}


}
