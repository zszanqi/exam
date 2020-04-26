package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hs.dao.PaperDao;
import com.hs.dao.impl.PaperDaoImpl;
import com.hs.model.Exam;
import com.hs.service.PaperService;
import com.hs.util.C3P0Utils;
import com.hs.util.Page;

public class PaperServiceImpl implements PaperService {

	private PaperDao pd = new PaperDaoImpl();

	// 获取试卷分页page对象
	@Override
	public Page getPaper4PerPage(String name, int curPage) {
		Page page = new Page();
		int rowsCount = 0;
		List<Map<String, Object>> list = null;
		try {
			// 查询列表数据
			list = pd.getPaperPerPage4(name, page, curPage);
			rowsCount = pd.getPaperCount4Page(name);
			// 将查询到的列表数据和总记录数封装到page对象中
			page.setParam(list, curPage, rowsCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public String setStatus(Integer status, Integer paperId) {
		String result = null;
		int rows = 0;
		try {
			rows = pd.setStatus(status, paperId);
			if (rows == 1) {
				result = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Map<String, Object>> ShowQuestionList(String paperId) {
		List<Map<String, Object>> list = null;
		try {
			list = pd.ShowQuestionList(Integer.parseInt(paperId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//将多选题保存到试卷中
	@Override
	public String saveMultiByPaperId(Integer paperId, String[] questionIds) {
		String result = null;
		if (questionIds != null && questionIds.length > 0) {
			try {
				//开启事务
				C3P0Utils.startTransaction();
				for (String questionId : questionIds) {
					pd.saveMultiByPaperId(paperId, Integer.parseInt(questionId));

				}
				//提交事务
				C3P0Utils.commitAndClose();
				result = "ok";
			} catch (Exception e) {
				e.printStackTrace();
				//发生异常回滚事务
				C3P0Utils.rollbackAndClose();
				result = "error";
			}
		}
		return result;
	}

	//删除试卷
	@Override
	public String deletePaperById(int paperId) {
		String result = null;
		int rows = 0;
		try {
			rows = pd.deletePaperById(paperId);
			if(rows==1) {
				result = "ok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//添加试卷
	@Override
	public String addPaperByTitleAndTime(String title, String time,Integer teaId) {
		String result = null;
		int rows = 0;
		try {
			rows = pd.addPaperByTitleAndTime(title,time,teaId);
			if(rows==1) {
				result = "ok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//删除不想要的题目
	@Override
	public String delQuesById(String[] questionIds) {
		String result = null;
		if (questionIds != null && questionIds.length > 0) {
			try {
				//开启事务
				C3P0Utils.startTransaction();
				for (String questionId : questionIds) {
					pd.delQuestionById(Integer.parseInt(questionId));
				}
				//提交事务
				C3P0Utils.commitAndClose();
				result = "ok";
			} catch (Exception e) {
				e.printStackTrace();
				//发生异常回滚事务
				C3P0Utils.rollbackAndClose();
				result = "error";
			}
		}
		return result;
	}

	@Override
	public String saveSingleByPaperId(int paperId, String[] questionIds) {
		String result = null;
		if (questionIds != null && questionIds.length > 0) {
			try {
				//开启事务
				C3P0Utils.startTransaction();
				for (String questionId : questionIds) {
					pd.saveSingleByPaperId(paperId, Integer.parseInt(questionId));

				}
				//提交事务
				C3P0Utils.commitAndClose();
				result = "ok";
			} catch (Exception e) {
				e.printStackTrace();
				//发生异常回滚事务
				C3P0Utils.rollbackAndClose();
				result = "error";
			}
		}
		return result;
	}

	@Override
	public String saveJudgeByPaperId(int paperId, String[] questionIds) {
		String result = null;
		if (questionIds != null && questionIds.length > 0) {
			try {
				//开启事务
				C3P0Utils.startTransaction();
				for (String questionId : questionIds) {
					pd.saveJudgeByPaperId(paperId, Integer.parseInt(questionId));

				}
				//提交事务
				C3P0Utils.commitAndClose();
				result = "ok";
			} catch (Exception e) {
				e.printStackTrace();
				//发生异常回滚事务
				C3P0Utils.rollbackAndClose();
				result = "error";
			}
		}
		return result;
	}

	@Override
	public String commitPaper(int paperId) {
		String result = null;
		int rows = 0;
		try {
			rows = pd.commitPaper(paperId);
			if(rows==1) {
				result = "ok";
			}
		} catch (SQLException e) {
			result = "error";
			e.printStackTrace();
		}
		return result;
	}

}
