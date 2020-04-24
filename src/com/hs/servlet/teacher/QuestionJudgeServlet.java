package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.service.GradeService;
import com.hs.service.QuestionJudgeService;
import com.hs.service.Impl.GradeServiceImpl;
import com.hs.service.Impl.QuestionJudgeServiceImpl;
import com.hs.util.Page;

/**
 * Servlet implementation class QuestionJudgeServlet
 */
@WebServlet("/teacher/QuestionJudgeServlet")
public class QuestionJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String curPage = request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)) {
			curPage="1";
		}
		//创建page对象
		Page page = (Page) request.getAttribute("page");
		if(page == null) {
			page = new Page();
		}
		//获取查询关键字
		String name = request.getParameter("name");
		//获取page对象
		QuestionJudgeServiceImpl qjs = new QuestionJudgeServiceImpl();
		page = qjs.getQuestionJudgeByName(name,Integer.parseInt(curPage));
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/teacher/question_judge_list.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
