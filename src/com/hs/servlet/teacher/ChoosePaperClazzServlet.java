package com.hs.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.model.ExamClazz;
import com.hs.model.QuestionMulti;
import com.hs.model.TeacherClazz;
import com.hs.service.ClazzService;
import com.hs.service.MultiService;
import com.hs.service.PaperClazzService;
import com.hs.service.PaperService;
import com.hs.service.TeacherClazzService;
import com.hs.service.TeacherService;
import com.hs.service.Impl.ClazzServiceImpl;
import com.hs.service.Impl.MultiServiceImpl;
import com.hs.service.Impl.PaperClazzServiceImpl;
import com.hs.service.Impl.PaperServiceImpl;
import com.hs.service.Impl.TeacherClazzServiceImpl;
import com.hs.service.Impl.TeacherServiceImpl;
import com.hs.util.Page;

/**
 * 选择所属班级
 */
@WebServlet("/teacher/ChoosePaperClazzServlet")
public class ChoosePaperClazzServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if("1".equals(flag)) {
			//获取参数
			String gradeName = request.getParameter("gradeName");
			String majorName = request.getParameter("majorName");
			String paperId = request.getParameter("paperId");
			//查询数据库
			ClazzService cs = new ClazzServiceImpl();
			List<Map<String,Object>> list = cs.getClazzAll(gradeName, majorName);
			
			//根据试卷查询班级
			PaperClazzService tcService = new PaperClazzServiceImpl();
			List<ExamClazz> tcList = tcService.getPaperClazzListByPaperId(Integer.parseInt(paperId));
			
			//设置页面参数
			request.setAttribute("list", list);
			request.setAttribute("gradeName", gradeName);
			request.setAttribute("majorName", majorName);
			request.setAttribute("paperId", paperId);
			request.setAttribute("tcList", tcList);
			//跳转到添加班级页面
			request.getRequestDispatcher("/WEB-INF/page/teacher/paper_clazz_list.jsp").forward(request, response);
		}else {
			//获取当前页
			String curPage = request.getParameter("curPage");
			if(StringUtils.isBlank(curPage)) {
				curPage="1";//如果页码为空则初始化为1
			}
			//获取分页对象
			Page page = (Page) request.getAttribute("page");
			if(page == null) {
				page = new Page();
			}
			//获取查询关键字
			String name = request.getParameter("name");
			//调用service层方法查询分页
			PaperService ps = new PaperServiceImpl();
			page = ps.getPaper4PerPage(name,Integer.parseInt(curPage));
			request.setAttribute("page", page);
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/page/teacher/paper_index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
