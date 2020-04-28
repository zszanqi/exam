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
 * 保存单选题到exam_question表中
 */
@WebServlet("/teacher/SelectSingleServlet")
public class SelectSingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		String[] questionIds = request.getParameterValues("questionId");
		String paperId = request.getParameter("paperId");
		System.out.println(paperId);
		// 调用service方法保存关联关系
		PaperService ps = new PaperServiceImpl();
		String result = ps.saveSingleByPaperId(Integer.parseInt(paperId), questionIds);
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
