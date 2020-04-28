package com.hs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.service.LoginService;
import com.hs.service.Impl.LoginServiceImpl;
import com.hs.util.MD5Util;

/**
 * 登录功能servlet
 */
@WebServlet("/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String roleId = request.getParameter("role");
		String auto = request.getParameter("auto");
		//调用service层方法
		LoginService ls = new LoginServiceImpl();
		String result = ls.Login(Integer.parseInt(roleId), username, password, request);
		if("true".equals(auto)) {
			//自动登陆
			String info = username+"<>"+password+"<>"+roleId;
			Cookie cookie = new Cookie("exam_userinfo",info);
			cookie.setMaxAge(30*24*60*60);
			response.addCookie(cookie);
		}else {
			//取消自动登录
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("exam_userinfo")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
