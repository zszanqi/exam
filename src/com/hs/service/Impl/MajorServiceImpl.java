package com.hs.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.MajorDao;
import com.hs.dao.impl.MajorDaoImpl;
import com.hs.model.Grade;
import com.hs.model.Major;
import com.hs.service.MajorService;
import com.hs.util.Page;

public class MajorServiceImpl implements MajorService{
	
	private MajorDao md = new MajorDaoImpl();
	
	//查询所有专业列表
	@Override
	public List<Major> getMajorList() {
		List<Major> list = null;
		try {
			list = md.getMajorList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
   /*
    * 根据年纪名称查询列表
    * @see com.hs.service.MajorService#getGradesByName(java.lang.String)
    */

	@Override
	public Page<Major> getMajorsByName(String name, Page page, Integer curPage) {
		try{
			//查询当前页面要显示的记录列表
			List<Major> list=md.getMajorsByName(name, page, curPage);
			//查询总记录数
			int rowsCount=md.getMajorsCount(name);
			//将查询结果封装到page对象中
			page.setParam(list, curPage, rowsCount);
		}catch(Exception e){
			e.printStackTrace();
		}
		return page;
	}
    /*
     *保存专业信息 
     * @see com.hs.service.MajorService#saveGrade(java.lang.String)
     */
	@Override
	public String saveGrade(String name) {
		String result = null;
		//1.判断该年纪名称是否已经被添加
		try{
			Major major=md.queryByName(name);
			if(major!=null){
				//已存在
				result="exist";
			}else{
				//不存在
				int rows=md.saveMajor(name);
				if(rows==1){
					result="ok";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 删除操作  
	 */
	@Override
	public String delMajor(int majorId) {
		String result = null;
		try {
			int rows = md.delMajor(majorId);
			if(rows==1){
				result="ok";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public List<Major> GetAllMajor(){
		List<Major> list = null;
		try {
			list = md.GetAllMajor();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String AddMajor(String name){
		String result = null;
		try {
			if(md.GetMajorByName(name)==null){
				int flag = md.AddMajor(name);
				if(flag == 0){
					result = "error";
				}else{
					result = "ok";
				}
			}else{
				result = "exist";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
	

	

