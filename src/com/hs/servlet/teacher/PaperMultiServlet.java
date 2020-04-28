package com.hs.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.model.QuestionMulti;
import com.hs.service.MultiService;
import com.hs.service.PaperService;
import com.hs.service.Impl.MultiServiceImpl;
import com.hs.service.Impl.PaperServiceImpl;
import com.hs.util.Page;

/**
 * 获取题目列表servlet
 */
@WebServlet("/teacher/PaperMultiServlet")
public class PaperMultiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求参数
		String title = request.getParameter("title");
		String paperId = request.getParameter("paperId");
		List<QuestionMulti> list = null;
		//获取多选题列表
		MultiService ms = new MultiServiceImpl();
		list = ms.getMultiAll(title);
		request.setAttribute("list", list);
		request.setAttribute("paperId", paperId);
		request.getRequestDispatcher("/WEB-INF/page/teacher/paper_choose_question.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
