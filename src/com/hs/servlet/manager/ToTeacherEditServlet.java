package com.hs.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.Teacher;
import com.hs.service.TeacherService;
import com.hs.service.Impl.TeacherServiceImpl;

/**
 * Servlet implementation class ToTeacherEditServlet
 */
@WebServlet("/ToTeacherEditServlet")
public class ToTeacherEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToTeacherEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		TeacherService tea=new TeacherServiceImpl();
		List<Teacher> teacher=tea.getTeacherByid(id);
		System.out.println(teacher);
		request.setAttribute("teacher", teacher.get(0));
		request.getRequestDispatcher("/WEB-INF/page/manager/teacher_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
