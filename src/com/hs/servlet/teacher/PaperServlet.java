package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.service.PaperService;
import com.hs.service.Impl.PaperServiceImpl;
import com.hs.util.Page;

/**
 * 跳转到试卷列表
 */
@WebServlet("/teacher/PaperServlet")
public class PaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前页
		String curPage = request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)) {
			curPage="1";//如果页码为空则初始化为1
		}
		//获取分页对象
		Page page = (Page) request.getAttribute("page");
		if(page == null) {
			page = new Page();
		}
		//获取查询关键字
		String name = request.getParameter("name");
		//调用service层方法查询分页
		PaperService ps = new PaperServiceImpl();
		page = ps.getPaper4PerPage(name,Integer.parseInt(curPage));
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/teacher/paper_index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
