package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;


import com.hs.service.SingleService;
import com.hs.service.Impl.SingleServiceImpl;
import com.hs.util.Page;


@WebServlet("/teacher/single")
public class SingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//鑾峰彇褰撳墠椤电爜
		String curPage = request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)) {
			curPage = "1";
		}
		//鑾峰彇鏌ヨ鍏抽敭瀛�
		String title = request.getParameter("title");
		//鏌ヨ鍗曢�夊垪琛�
		SingleService singleService = new SingleServiceImpl();
		Page page = singleService.getSingleByTitle(title,Integer.parseInt(curPage));
		//灏嗘煡璇㈢粨鏋滆繑鍥為〉闈�
		request.setAttribute("page", page);
		//鍏抽敭瀛楀洖濉�
		request.setAttribute("title", title);
		request.getRequestDispatcher("/WEB-INF/page/teacher/single_list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
