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
	
     //����ҳ�Ĳ�ѯȫ��
	public List<Suggest> queryAllSuggest(PageBean pageBean, Suggest suggest) {
		return suggestDAO.queryAllSuggest(pageBean, suggest);
	}


    //�ܼ�¼��
	public int SuggestCount(Suggest suggest) {
		return suggestDAO.SuggestCount(suggest);
	}
	
	// ɾ������
		public boolean del(Suggest suggest) {
			return suggestDAO.del(suggest);	
		}
	// ɾ�����
	public int SuggestDelete(String delIds) {
		return suggestDAO.SuggestDelete(delIds);	
	}
	//�鵥��
	public Suggest select(Suggest suggest) {
		
		return suggestDAO.select(suggest);
	}
	public List<Suggest> mohu(Suggest suggest) {
		
		return suggestDAO.mohu(suggest);
	}
	//�޸�
	public boolean updateb(Suggest suggest) {
		
		return suggestDAO.updateb(suggest);
	}
	//��
	public boolean add(Suggest suggest) {
		return suggestDAO.add(suggest);
	}
}