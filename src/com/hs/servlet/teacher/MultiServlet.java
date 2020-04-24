package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.service.MultiService;
import com.hs.service.Impl.MultiServiceImpl;
import com.hs.util.Page;

/**
 * 多选列表分页
 */
@WebServlet("/teacher/MultiServlet")
public class MultiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前页码
		String curPage = request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)) {
			curPage = "1";
		}
		//获取查询关键字
		String title = request.getParameter("title");
		//查询多选列表
		MultiService multiService = new MultiServiceImpl();
		Page page = multiService.getMultiByTitle(title,Integer.parseInt(curPage));
		//将查询结果返回页面
		request.setAttribute("page", page);
		//关键字回填
		request.setAttribute("title", title);
		request.getRequestDispatcher("/WEB-INF/page/teacher/multi_list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
