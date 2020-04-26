package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.QuestionSingle;
import com.hs.service.SingleService;
import com.hs.service.Impl.SingleServiceImpl;



@WebServlet("/teacher/FindSingleByIdServlet")
public class FindSingleByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("singleId");
		
	
		QuestionSingle Single = null;
		SingleService singleService = new SingleServiceImpl();
		try {
			Single = singleService.getSingleById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("Single", Single);
		request.getRequestDispatcher("/WEB-INF/page/teacher/single_edit.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
