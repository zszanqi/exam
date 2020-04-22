package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.ClazzService;
import com.hs.service.Impl.ClazzServiceImpl;

/**
 * 班级添加servlet
 */
@WebServlet("/manager/DoClazzAddServlet")
public class DoClazzAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String gradeId = request.getParameter("gradeId");
		String majorId = request.getParameter("majorId");
		String cno = request.getParameter("cno");
		//调用service层方法执行保存
		ClazzService cs = new ClazzServiceImpl();
		String result = cs.saveClazz(gradeId, majorId, cno);
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
