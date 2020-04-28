package com.hs.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.QuestionJudge;
import com.hs.model.Teacher;
import com.hs.service.QuestionJudgeService;
import com.hs.service.TeacherService;
import com.hs.service.Impl.QuestionJudgeServiceImpl;
import com.hs.service.Impl.TeacherServiceImpl;

@WebServlet("/teacher/ToQuestionJudgeEditServlet")
public class ToQuestionJudgeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToQuestionJudgeEditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		QuestionJudgeService questionjudge = new QuestionJudgeServiceImpl();
		List<QuestionJudge> qj= questionjudge.getQuestionJudgeById(Integer.parseInt(id));
		request.setAttribute("questionjudge", qj.get(0));
		request.setAttribute("quesId", id);
		request.getRequestDispatcher("/WEB-INF/page/teacher/question_judge_edit.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}