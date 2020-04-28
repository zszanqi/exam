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
 * 编辑试卷
 */
@WebServlet("/teacher/DoPaperEditServlet")
public class DoPaperEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String paperId = request.getParameter("paperId");
		String title = request.getParameter("title");
		String time = request.getParameter("time");
		//调用service层方法
		PaperService ps = new PaperServiceImpl();
		String result = ps.editPaper(Integer.parseInt(paperId),title,time);
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
