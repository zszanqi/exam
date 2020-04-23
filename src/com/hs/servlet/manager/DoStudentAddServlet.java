package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.Student;
import com.hs.service.StudentService;
import com.hs.service.Impl.StudentServiceImpl;

/**
 * 添加学生
 */
@WebServlet("/manager/DoStudentAddServlet")
public class DoStudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fk_clazz = request.getParameter("fk_clazz");
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		//创建学生对象，用于添加
		Student stu = new Student();
		stu.setFk_clazz((int)Integer.parseInt(fk_clazz));
		stu.setUsername(username);
		stu.setRealname(realname);
		StudentService ss = new StudentServiceImpl();
		String result = ss.saveStudent(stu);
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
