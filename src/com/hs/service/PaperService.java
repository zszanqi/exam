package com.hs.service;

import com.hs.util.Page;

public interface PaperService {

	Page getPaperByName(String name, int curPage);

}
