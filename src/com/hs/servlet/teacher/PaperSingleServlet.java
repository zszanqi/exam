package com.hs.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.QuestionSingle;
import com.hs.service.SingleService;
import com.hs.service.Impl.SingleServiceImpl;

/**
 * 展示所有单选题
 */
@WebServlet("/teacher/PaperSingleServlet")
public class PaperSingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String paperId = request.getParameter("paperId");
		List<QuestionSingle> list = null;
		//获取单选题列表
		SingleService ss = new SingleServiceImpl();
		list = ss.getSingleAll(title);
		request.setAttribute("list", list);
		request.setAttribute("paperId", paperId);
		request.getRequestDispatcher("/WEB-INF/page/teacher/paper_choose_single_question.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
