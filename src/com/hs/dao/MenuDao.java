package com.hs.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.Menu;

public interface MenuDao {
	public List<Menu> getMenuListByRoleId(Integer roleId) throws SQLException;
}
