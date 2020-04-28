package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.PaperClazzService;
import com.hs.service.Impl.PaperClazzServiceImpl;

/**
 * 保存exam的clazz
 */
@WebServlet("/manager/SelectPaperClazzServlet")
public class SelectPaperClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取元素
		String[] clazzIds = request.getParameterValues("clazzId");
		String paperId = request.getParameter("paperId");
		// 进行添加操作
		PaperClazzService pcService = new PaperClazzServiceImpl();
		String result = pcService.saveData(Integer.parseInt(paperId), clazzIds);
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
