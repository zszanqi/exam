package com.hs.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.Clazz;
import com.hs.model.Grade;
import com.hs.model.Major;
import com.hs.service.ClazzService;
import com.hs.service.GradeService;
import com.hs.service.MajorService;
import com.hs.service.Impl.ClazzServiceImpl;
import com.hs.service.Impl.GradeServiceImpl;
import com.hs.service.Impl.MajorServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ToStudentAddServlet
 */
@WebServlet("/manager/ToStudentAddServlet")
public class ToStudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if("1".equals(flag)) {
			//处理查询班级列表的ajax请求
			String gradeId = request.getParameter("gradeId");
			String majorId = request.getParameter("majorId");
			ClazzService clazzService = new ClazzServiceImpl();
			List<Clazz> clazzList = clazzService.getClazzListByGradeIdAndMajorId(Integer.parseInt(gradeId), Integer.parseInt(majorId));
			//将集合转换为json字符串
			JSONArray array = new JSONArray().fromObject(clazzList);
			response.getWriter().write(array.toString());
		}else {
			//查询年级和专业列表
			GradeService gradeService = new GradeServiceImpl();
			List<Grade> gradeList = gradeService.getGradeList();
			MajorService majorService = new MajorServiceImpl();
			List<Major> majorList = majorService.getMajorList();
			//将查询到的列表返回页面
			request.setAttribute("gradeList", gradeList);
			request.setAttribute("majorList", majorList);
			request.getRequestDispatcher("/WEB-INF/page/manager/stu_add.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
