package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.MenuDao;
import com.hs.dao.impl.MenuDaoImpl;
import com.hs.model.Menu;
import com.hs.service.MenuService;

public class MenuServiceImpl implements MenuService{

	private MenuDao md = new MenuDaoImpl();
	
	@Override
	public List<Menu> getMenuByRoleId(Integer roleId) {
		List<Menu> list = null;
		try {
			list = md.getMenuListByRoleId(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
