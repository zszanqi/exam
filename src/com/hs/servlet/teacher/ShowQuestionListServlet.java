package com.hs.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.PaperService;
import com.hs.service.Impl.PaperServiceImpl;

/**
 * 展示已添加的题目
 */
@WebServlet("/teacher/ShowQuestionListServlet")
public class ShowQuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String paperId = request.getParameter("paperId");
		List<Map<String,Object>> list = null;
		//调用service层方法
		PaperService ps = new PaperServiceImpl();
		list = ps.ShowQuestionList(paperId);
		request.setAttribute("list", list);
		request.setAttribute("paperId", paperId);
		request.getRequestDispatcher("/WEB-INF/page/teacher/paper_added_question.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
