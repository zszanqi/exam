package com.hs.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.hs.model.Major;
import com.hs.service.MajorService;
import com.hs.service.Impl.MajorServiceImpl;
import com.hs.util.Page;

/**
 * Servlet implementation class MajorServlet
 */
@WebServlet("/manager/major")
public class MajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //乱码处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("tetx/html;charset=utf-8");
		//获取查询信息
		String name=request.getParameter("name");
		//查询专业列表
		MajorService majorservice=new MajorServiceImpl();
		List<Major> list=majorservice.getMajorsByName(name);
		//将查询结果返回页面
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/page/manager/major_list.jsp").forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
