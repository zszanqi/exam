package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.GradeService;
import com.hs.service.Impl.GradeServiceImpl;

/**
 * 年级添加servlet
 */
@WebServlet("/manager/DoGradeAddServlet")
public class DoGradeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see get请求处理函数
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String name = request.getParameter("name");
		//调用service层方法
		GradeService gs = new GradeServiceImpl();
		String result = gs.saveGradeByName(name);
		//结果返回给页面
		response.getWriter().write(result);
	}

	/**
	 * @see post请求处理函数
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
