package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.Impl.QuestionJudgeServiceImpl;


/**
 * Servlet implementation class DoQuestionJudgeAddServlet
 */
@WebServlet("/teacher/DoQuestionJudgeAddServlet")
public class DoQuestionJudgeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoQuestionJudgeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String title = request.getParameter("title");
		String answer = request.getParameter("answer");
		String score = request.getParameter("score");
		//调用service层方�?
		QuestionJudgeServiceImpl qj = new QuestionJudgeServiceImpl();
		String result = qj.saveQuestionJudgeByName(title,answer,score);
		//结果返回给页�?
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
