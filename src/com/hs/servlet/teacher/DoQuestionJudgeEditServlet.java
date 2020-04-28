package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.QuestionJudgeService;
import com.hs.service.Impl.QuestionJudgeServiceImpl;



/**
 * 进行判断题编辑
 */
@WebServlet("/teacher/DoQuestionJudgeEditServlet")
public class DoQuestionJudgeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String answer=request.getParameter("answer");
		String score=request.getParameter("score");
		String id = request.getParameter("id");
		QuestionJudgeService qj=new QuestionJudgeServiceImpl();
		boolean flag=qj.editQuestionJudgeByid(Integer.parseInt(id),title, answer, Double.parseDouble(score));
		String result=null;
		if(flag) {
			result="ok";
			response.getWriter().write(result);
		}
		else {
			result="no";
			response.getWriter().write(result);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
