package com.lx.service;


import java.util.List;
import com.lx.bean.PageBean;
import com.lx.bean.Suggest;
import com.lx.dao.SuggestDAO;


public class SuggestService {
	
	SuggestDAO suggestDAO =new SuggestDAO();
	public void addSuggest(Suggest suggest) {
		suggestDAO.addSuggest(suggest);
	}

	public Suggest findSuggestById(Suggest suggest) {
		return suggestDAO.findSuggestById(suggest);
	}
	
     //带分页的查询全部
	public List<Suggest> queryAllSuggest(PageBean pageBean, Suggest suggest) {
		return suggestDAO.queryAllSuggest(pageBean, suggest);
	}


    //总记录数
	public int SuggestCount(Suggest suggest) {
		return suggestDAO.SuggestCount(suggest);
	}
	
	// 删除单个
		public boolean del(Suggest suggest) {
			return suggestDAO.del(suggest);	
		}
	// 删除多个
	public int SuggestDelete(String delIds) {
		return suggestDAO.SuggestDelete(delIds);	
	}
	//查单个
	public Suggest select(Suggest suggest) {
		
		return suggestDAO.select(suggest);
	}
	public List<Suggest> mohu(Suggest suggest) {
		
		return suggestDAO.mohu(suggest);
	}
	//修改
	public boolean updateb(Suggest suggest) {
		
		return suggestDAO.updateb(suggest);
	}
	//增
	public boolean add(Suggest suggest) {
		return suggestDAO.add(suggest);
	}
}