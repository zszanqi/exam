package com.hs.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.QuestionJudge;
import com.hs.service.QuestionJudgeService;
import com.hs.service.Impl.MultiServiceImpl;
import com.hs.service.Impl.QuestionJudgeServiceImpl;

/**
 * 展示所有判断题
 */
@WebServlet("/teacher/PaperJudgeServlet")
public class PaperJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String paperId = request.getParameter("paperId");
		List<QuestionJudge> list = null;
		//获取多选题列表
		QuestionJudgeService ms = new QuestionJudgeServiceImpl();
		list = ms.getJudgeAll(title);
		request.setAttribute("list", list);
		request.setAttribute("paperId", paperId);
		request.getRequestDispatcher("/WEB-INF/page/teacher/paper_choose_judge_question.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
