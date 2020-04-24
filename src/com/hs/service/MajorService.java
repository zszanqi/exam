package com.hs.service;

import java.sql.SQLException;
import java.util.List;

import com.hs.model.Major;
import com.hs.util.Page;

public interface MajorService {
	public Page<Major> GetMajorByName(String name,Page page,Integer curPage);
	public List<Major> GetAllMajor();
	public String AddMajor(String name);
}
