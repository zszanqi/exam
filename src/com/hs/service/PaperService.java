package com.hs.service;

import com.hs.util.Page;

public interface PaperService {

	Page getPaper4PerPage(String name, int curPage);
	public String setStatus(Integer status,Integer paperId);
}
