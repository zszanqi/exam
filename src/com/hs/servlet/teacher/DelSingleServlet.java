package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.SingleService;
import com.hs.service.Impl.SingleServiceImpl;


@WebServlet("/teacher/DelSingleServlet")
public class DelSingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String singleId = request.getParameter("singleId");
		SingleService singleService = new SingleServiceImpl();	
		String result = singleService.delSingle(singleId);
		response.getWriter().write(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
