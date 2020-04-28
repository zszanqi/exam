package com.hs.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.Exam;
import com.hs.service.PaperService;
import com.hs.service.Impl.PaperServiceImpl;

/**
 * 编辑试卷页面
 */
@WebServlet("/teacher/ToEditPaperServlet")
public class ToEditPaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String paperId = request.getParameter("paperId");
		request.setAttribute("paperId", paperId);
		//调用service层方法
		PaperService ps = new PaperServiceImpl();
		List<Exam> paper = ps.getPaperById(Integer.parseInt(paperId));
		request.setAttribute("paper", paper.get(0));
		request.getRequestDispatcher("/WEB-INF/page/teacher/paper_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
