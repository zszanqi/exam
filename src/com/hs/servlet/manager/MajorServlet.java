package com.hs.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.model.Major;
import com.hs.service.GradeService;
import com.hs.service.MajorService;
import com.hs.service.Impl.MajorServiceImpl;
import com.hs.util.Page;

/**
 * Servlet implementation class MajorServlet
 */
@WebServlet("/manager/MajorServlet")
public class MajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //乱码处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("tetx/html;charset=utf-8");
		//获取当前查询的页码
		String curPage=request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)){
			curPage="1";
		}
		//获取分页对象
		Page page=(Page)request.getAttribute("page");
		if(page==null){
			page=new Page();
		}
		//获取查询信息
		String name=request.getParameter("name");
		//查询专业列表
		MajorService majorservice=new MajorServiceImpl();
		page=majorservice.getMajorsByName(name, page, Integer.parseInt(curPage));
		//将查询结果返回页面
		request.setAttribute("page",page);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/page/manager/major_list.jsp").forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
