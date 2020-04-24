package com.hs.servlet.manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.MajorService;
import com.hs.service.Impl.MajorServiceImpl;

@WebServlet("/manager/MajorAddServlet")
public class MajorAddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String majorname = request.getParameter("majorname");
		MajorService ms = new MajorServiceImpl();
		String result = ms.AddMajor(majorname);
		System.out.println(result);
		response.getWriter().write(result);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
