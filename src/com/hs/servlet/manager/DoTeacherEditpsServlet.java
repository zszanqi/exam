package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.TeacherService;
import com.hs.service.Impl.TeacherServiceImpl;

/**
 * Servlet implementation class DoTeacherEditpsServlet
 */
@WebServlet("/DoTeacherEditpsServlet")
public class DoTeacherEditpsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String editid=request.getParameter("id");
		String newps=request.getParameter("newps");
		TeacherService tea=new TeacherServiceImpl();
		boolean flag=tea.editpsTeacherByid(editid,newps);
		String result=null;
		if(flag) {
			result="ok";
			response.getWriter().write(result);
		}
		else {
			result="no";
			response.getWriter().write(result);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
