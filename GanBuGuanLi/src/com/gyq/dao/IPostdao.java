package com.gyq.dao;

import java.util.List;

import com.gyq.bean.PageBean;
import com.gyq.bean.posinformation;


public interface IPostdao {
	
		//增
	    public boolean add(posinformation post);
	    //删
	    public boolean del(posinformation post);
	    //改
	    public boolean update(posinformation post);
	    //查ALL
	    public List<posinformation> selectall();
	
	  //查单条
	    public posinformation select(posinformation post);
	 

	/*
	 * //登陆 public boolean logion(Postinformation post);
	 */
	  //模糊查询
	    public List<posinformation> mohu(posinformation post);
	    
	 //带分页查询所有
	    public List<posinformation> queryAllPost(PageBean pageBean, posinformation postinformation); 
	//删除多条记录
	    public int postDelete(String delIds);
	//查询总记录数
	    public int postCount(posinformation postformation);
}
