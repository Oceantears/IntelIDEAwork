package com.gyq.dao;

import java.util.List;

import com.gyq.bean.PageBean;
import com.gyq.bean.posinformation;


public interface IPostdao {
	
		//��
	    public boolean add(posinformation post);
	    //ɾ
	    public boolean del(posinformation post);
	    //��
	    public boolean update(posinformation post);
	    //��ALL
	    public List<posinformation> selectall();
	
	  //�鵥��
	    public posinformation select(posinformation post);
	 

	/*
	 * //��½ public boolean logion(Postinformation post);
	 */
	  //ģ����ѯ
	    public List<posinformation> mohu(posinformation post);
	    
	 //����ҳ��ѯ����
	    public List<posinformation> queryAllPost(PageBean pageBean, posinformation postinformation); 
	//ɾ��������¼
	    public int postDelete(String delIds);
	//��ѯ�ܼ�¼��
	    public int postCount(posinformation postformation);
}
