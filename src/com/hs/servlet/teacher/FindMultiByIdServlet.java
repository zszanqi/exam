package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.QuestionMulti;
import com.hs.service.MultiService;
import com.hs.service.Impl.MultiServiceImpl;


/**
 * 根据id找题目
 */
@WebServlet("/teacher/FindMultiByIdServlet")
public class FindMultiByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取多选id
		String id = request.getParameter("multiId");
		
		// 调用service 通过id获取多选 返回值 
		QuestionMulti Multi = null;
		MultiService multiService = new MultiServiceImpl();
		try {
			Multi = multiService.getMultiById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 将Multi放入request域中,请求转发到multi_edit.jsp
		request.setAttribute("Multi", Multi);
		request.getRequestDispatcher("/WEB-INF/page/teacher/multi_edit.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
