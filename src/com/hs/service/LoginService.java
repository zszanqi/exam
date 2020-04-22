package com.hs.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	public String Login(Integer roleId,String username,String password,HttpServletRequest request);
}
