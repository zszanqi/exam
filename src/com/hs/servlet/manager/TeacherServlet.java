package com.hs.servlet.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.model.Teacher;
import com.hs.service.TeacherService;
import com.hs.service.Impl.TeacherServiceImpl;
import com.hs.util.Page;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/manager/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		// 获取分页对象
		Page page = (Page) request.getAttribute("page");
		if (page == null) {
			page = new Page();
		}
		String name = request.getParameter("name");
		TeacherService tea = new TeacherServiceImpl();
		/*
		 * List<Teacher> list = null; try { list = tea.getTeacherInformation(name); }
		 * catch (SQLException e) { e.printStackTrace(); } request.setAttribute("list",
		 * list);
		 */
		System.out.println(curPage);
		page = tea.getTeacherByName(name, Integer.parseInt(curPage));
		// 将查询结果返回页面
		request.setAttribute("page", page);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/page/manager/teacher_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
