package com.hs.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.ClazzService;
import com.hs.service.GradeService;
import com.hs.service.Impl.ClazzServiceImpl;
import com.hs.service.Impl.GradeServiceImpl;

/**
 * 管理员删除班级页面
 */
@WebServlet("/manager/DeleteClazzServlet")
public class DeleteClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClazzServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ClazzService cs = new ClazzServiceImpl();
		boolean flag = cs.deleteClazzById(id);
		if(flag) {
			response.sendRedirect("ClazzServlet");
		}else {
			response.getWriter().write("删除失败，两秒后返回年级列表");
			response.setHeader("refresh", "2;url=ClazzServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
