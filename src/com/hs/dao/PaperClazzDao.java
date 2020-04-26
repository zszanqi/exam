package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.ExamClazz;

public interface PaperClazzDao {

	int saveData(Integer paperId, int parseInt) throws SQLException;

	int deleteData(Integer paperId) throws SQLException;

	List<ExamClazz> getExamClazzListByPaperId(int paperId) throws SQLException;

}
