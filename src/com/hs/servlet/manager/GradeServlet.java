package com.hs.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.model.Grade;
import com.hs.service.GradeService;
import com.hs.service.Impl.GradeServiceImpl;
import com.hs.util.Page;

/**
 * 跳转到年级列表
 */
@WebServlet("/manager/GradeServlet")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GradeServlet() {
		super();
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
		//获取分页对象
		Page page = (Page) request.getAttribute("page");
		if(page == null) {
			page = new Page();
		}
		//获取查询关键字
		String name = request.getParameter("name");
		//查询年级列表
		GradeService gs = new GradeServiceImpl();
		page = gs.getGradeByName(name,Integer.parseInt(curPage));
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/manager/grade_list.jsp").forward(request, response);
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
