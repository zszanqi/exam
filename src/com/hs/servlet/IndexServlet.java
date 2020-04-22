package com.hs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.model.Menu;
import com.hs.service.LoginService;
import com.hs.service.MenuService;
import com.hs.service.Impl.LoginServiceImpl;
import com.hs.service.Impl.MenuServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 跳转到首页
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//判断用户是否登录
		Object obj = request.getSession().getAttribute("user");
		if(obj!=null) {
			//根据角色获取菜单
			//获取角色id
			Integer roleId = (Integer) request.getSession().getAttribute("roleId");
			MenuService ms = new MenuServiceImpl();
			List<Menu> menus = ms.getMenuByRoleId(roleId);
			//将查询结果保存到request域中，传给页面
			request.setAttribute("menus", menus);
			request.getRequestDispatcher("/WEB-INF/page/index.jsp").forward(request, response);
		}else {
			//判断用户是否选择了自动登陆
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie:cookies) {
				if("exam_userinfo".equals(cookie.getName())) {
					String userInfo = cookie.getValue();
					String[] infoArray = userInfo.split("<>");
					String username = infoArray[0];
					String password = infoArray[1];
					Integer roleId = Integer.parseInt(infoArray[2]);
					//执行登录
					LoginService ls = new LoginServiceImpl();
					String result = ls.Login(roleId, username, password, request);
					if(result.equals("yes")) {
						//调用service层的方法
						MenuService menuService = new MenuServiceImpl();
						List<Menu> menus = menuService.getMenuByRoleId(roleId);
						//将查询结果保存到request域中，传给页面
						request.setAttribute("menus", menus);
						request.getRequestDispatcher("/WEB-INF/page/index.jsp").forward(request, response);
						return;
					}else {
						response.sendRedirect("LoginServlet");
						return;
					}
				}else {
		 			response.sendRedirect("LoginServlet");
		 			return;
				}
			}

			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
