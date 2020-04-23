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
 * Servlet implementation class DoTeacherEditServlet
 */
@WebServlet("/DoTeacherEditServlet")
public class DoTeacherEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoTeacherEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		TeacherService tea=new TeacherServiceImpl();
		boolean flag=tea.editTeacherByid(id, name, username, password);
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
