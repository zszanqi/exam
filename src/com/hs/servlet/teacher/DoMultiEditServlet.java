package com.hs.servlet.teacher;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.hs.service.MultiService;
import com.hs.service.Impl.MultiServiceImpl;


/**
 * 多选修改操作
 */
@WebServlet("/teacher/DoMultiEditServlet")
public class DoMultiEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取修改信息
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String answer = request.getParameter("answer");
		String score = request.getParameter("score");

		MultiService multiService = new MultiServiceImpl();		 
		try {
			String ms = multiService.editMulti(id, title, optionA, optionB, optionC, optionD, answer,Double.parseDouble(score));
			response.getWriter().write(ms);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("error");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
