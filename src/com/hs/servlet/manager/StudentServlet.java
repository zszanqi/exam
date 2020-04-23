package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.service.GradeService;
import com.hs.service.StudentService;
import com.hs.service.Impl.GradeServiceImpl;
import com.hs.service.Impl.StudentServiceImpl;
import com.hs.util.Page;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/manager/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String curPage = request.getParameter("curPage");
		if(StringUtils.isBlank(curPage)) {
			curPage="1";
		}
		//获取Page对象
		Page page = (Page) request.getAttribute("page");
		if(page == null) {
			page = new Page();
		}
		//获取姓名
		String name = request.getParameter("name");	
		//获取page
		StudentService ss = new StudentServiceImpl();
		page = ss.getStudentByName(name,Integer.parseInt(curPage));
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/page/manager/stu_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
