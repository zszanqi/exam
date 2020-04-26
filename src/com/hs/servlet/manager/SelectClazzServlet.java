package com.hs.servlet.manager;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.TeacherClazzService;
import com.hs.service.Impl.TeacherClazzServiceImpl;

/**
 * 保存teacher中的clazz
 */
@WebServlet("/manager/SelectClazzServlet")
public class SelectClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectClazzServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取元素
		String[] clazzIds = request.getParameterValues("clazzId");
		String teaId = request.getParameter("teaId");
		//进行添加操作
		TeacherClazzService tcService = new TeacherClazzServiceImpl();
		String result = tcService.saveData(Integer.parseInt(teaId), clazzIds);
		response.getWriter().write(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
