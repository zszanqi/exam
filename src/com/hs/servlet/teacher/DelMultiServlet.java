package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.MultiService;
import com.hs.service.Impl.MultiServiceImpl;



/**
 * 多选删除操作
 */
@WebServlet("/teacher/DelMultiServlet")
public class DelMultiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取多选ID
		String multiId = request.getParameter("multiId");
		MultiService multiService = new MultiServiceImpl();	
		String result = multiService.delMulti(multiId);
		response.getWriter().write(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
