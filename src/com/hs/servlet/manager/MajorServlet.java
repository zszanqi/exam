package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.service.MajorService;
import com.hs.service.Impl.MajorServiceImpl;
import com.hs.util.Page;

@WebServlet("/manager/MajorServlet")
public class MajorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curPage = request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)){
			curPage="1";
		}
		//获取分页对象
		Page page = (Page) request.getAttribute("page");
		if(page==null){
			page = new Page();
		}
		String name = request.getParameter("name");
		MajorService ms = new MajorServiceImpl();
		page = ms.GetMajorByName(name, page, Integer.valueOf(curPage));	
		request.setAttribute("page",page);
		request.setAttribute("name",name);
		request.getRequestDispatcher("/WEB-INF/page/manager/major_list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	
}
