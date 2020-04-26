package com.hs.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.hs.service.PaperService;
import com.hs.service.Impl.PaperServiceImpl;
import com.hs.util.Page;

/**
 * 提交改变页面状态
 */
@WebServlet("/teacher/CommitServlet")
public class CommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paperId = request.getParameter("paperId");
		PaperService ps = new PaperServiceImpl();
		String result = ps.commitPaper(Integer.parseInt(paperId));
		if(result=="ok") {
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
			page = ps.getPaper4PerPage(name,Integer.parseInt(curPage));
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/page/teacher/paper_index.jsp").forward(request, response);
		}
		else {
			response.getWriter().write("提交错误，五秒后返回");
			response.setHeader("refresh", "5;url=${basePath}teacher/IndexServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
