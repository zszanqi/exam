package com.hs.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.model.Clazz;
import com.hs.service.ClazzService;
import com.hs.service.GradeService;
import com.hs.service.Impl.ClazzServiceImpl;
import com.hs.service.Impl.GradeServiceImpl;
import com.hs.util.Page;

/**
 * 管理员班级管理
 */
@WebServlet("/manager/ClazzServlet")
public class ClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String curPage = request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)) {
			curPage="1";
		}
		//获取分页对象
		Page page = (Page) request.getAttribute("page");
		if(page == null) {
			page = new Page();
		}
		//获取查询关键字
		String gradeName = request.getParameter("gradeName");
		String majorName = request.getParameter("majorName");
		//查询班级列表
		ClazzService cs = new ClazzServiceImpl();
		page = cs.getClazzByGradeAndMajor(gradeName, majorName, Integer.parseInt(curPage));
		request.setAttribute("page", page);
		//关键字回填
		request.setAttribute("gradeName", gradeName);
		request.setAttribute("majorName", majorName);
		request.getRequestDispatcher("/WEB-INF/page/manager/clazz_list.jsp").forward(request, response);;
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
