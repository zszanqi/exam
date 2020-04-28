package com.hs.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.GradeService;
import com.hs.service.MajorService;
import com.hs.service.Impl.GradeServiceImpl;
import com.hs.service.Impl.MajorServiceImpl;

/**
 * Servlet implementation class DoGradeAddServlet
 */
@WebServlet("/manager/DoMajorAddServlet")
public class DoMajorAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String name = request.getParameter("name");
		//调用service层方法执行保存
		MajorService majorService = new MajorServiceImpl();
		String result = majorService.saveGrade(name);
		//将保存的反馈结果返回页面
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
