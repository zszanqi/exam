package com.hs.service;

import java.util.List;

import com.hs.model.Menu;

public interface MenuService {
	
	public List<Menu> getMenuByRoleId(Integer roleId);
}
