package com.hs.servlet.teacher;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.SingleService;
import com.hs.service.Impl.SingleServiceImpl;


@WebServlet("/teacher/DoSingleAddServlet")
public class DoSingleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String answer = request.getParameter("answer");
		String score = request.getParameter("score");
		
		SingleService singleService = new SingleServiceImpl();		 
		try {
			String as = singleService.addSingle(title, optionA, optionB, optionC, optionD, answer,Double.parseDouble(score));
			response.getWriter().write(as);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
