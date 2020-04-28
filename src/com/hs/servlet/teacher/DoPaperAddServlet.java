package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.PaperService;
import com.hs.service.Impl.PaperServiceImpl;

/**
 * 添加试卷
 */
@WebServlet("/teacher/DoPaperAddServlet")
public class DoPaperAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取需要用到的参数
		String title = request.getParameter("papertitle");
		String time = request.getParameter("time");
		String teacherId = request.getParameter("teacherId");
		//调用service方法
		PaperService ps = new PaperServiceImpl();
		String result = ps.addPaperByTitleAndTime(title,time,Integer.parseInt(teacherId));
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
