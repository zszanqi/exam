package com.hs.service.Impl;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.dao.LoginDao;
import com.hs.dao.impl.LoginDaoImpl;
import com.hs.model.Manager;
import com.hs.model.Student;
import com.hs.model.Teacher;
import com.hs.service.LoginService;
import com.hs.util.MD5Util;

public class LoginServiceImpl implements LoginService{

	private LoginDao ld = new LoginDaoImpl();
	
	//登录请求
	@Override
	public String Login(Integer roleId, String username, String password,HttpServletRequest request) {
		//定义返回值变量
		String result = null;
		try {
			Object obj = ld.login(roleId, username, MD5Util.getMD5(password));
			if(obj == null) {//登陆失败
				result = "no";
			}else {//登陆成功
				result = "yes";
				if(roleId == 1) {
					request.getSession().setAttribute("roleId", roleId);
					request.getSession().setAttribute("user", (Student)obj);
				}else if(roleId == 2) {
					request.getSession().setAttribute("roleId", roleId);
					request.getSession().setAttribute("user", (Teacher)obj);
				}else if(roleId == 3) {
					request.getSession().setAttribute("roleId", roleId);
					request.getSession().setAttribute("user", (Manager)obj);
				}
			}
		} catch (SQLException e) {
			result = "error";
			e.printStackTrace();
		}
		return result;
	}

}
