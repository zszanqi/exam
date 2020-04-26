package com.hs.servlet.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.model.TeacherClazz;
import com.hs.service.ClazzService;
import com.hs.service.TeacherClazzService;
import com.hs.service.TeacherService;
import com.hs.service.Impl.ClazzServiceImpl;
import com.hs.service.Impl.TeacherClazzServiceImpl;
import com.hs.service.Impl.TeacherServiceImpl;
import com.hs.util.Page;

/**
 * Servlet implementation class TeacherClazzServlet
 */
@WebServlet("/TeacherClazzServlet")
public class TeacherClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherClazzServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if("1".equals(flag)) {
			
			//获取页面参数
			String gradeName = request.getParameter("gradeName");
			String majorName = request.getParameter("majorName");
			String teaId = request.getParameter("id");
			//查询班级列表
			ClazzService clazzService = new ClazzServiceImpl();
			List<Map<String,Object>> list = clazzService.getClazzAll(gradeName, majorName);
			
			//查询已选择的班级
			TeacherClazzService tcService = new TeacherClazzServiceImpl();
			List<TeacherClazz> tcList = tcService.getTeacherClazzListByTeacherId(Integer.parseInt(teaId));
			
			//将查询到的集合返回页面
			request.setAttribute("list", list);
			request.setAttribute("gradeName", gradeName);
			request.setAttribute("majorName", majorName);
			request.setAttribute("teaId", teaId);
			request.setAttribute("tcList", tcList);
			//跳转到班级列表
			request.getRequestDispatcher("/WEB-INF/page/manager/teacher_clazz_list.jsp").forward(request, response);
		}else {
			//跳转到教师管理页面
			String curPage = request.getParameter("curPage");
			if(StringUtils.isBlank(curPage)) {
				curPage="1";
			}
			Page page = (Page) request.getAttribute("page");
			if (page == null) {
				page = new Page();
			}
			String name = request.getParameter("name");
			TeacherService tea = new TeacherServiceImpl();
			page = tea.getTeacherByName(name, Integer.parseInt(curPage));
			request.setAttribute("page", page);
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/page/manager/teacher_list.jsp").forward(request, response);
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
