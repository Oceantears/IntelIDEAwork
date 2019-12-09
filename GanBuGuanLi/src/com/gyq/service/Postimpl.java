package com.gyq.service;

import java.util.List;

import com.gyq.bean.PageBean;
import com.gyq.bean.posinformation;
import com.gyq.dao.Postdaoimpl;

public class Postimpl implements Ipost {
	Postdaoimpl postdao=new Postdaoimpl();
//增
	@Override
	public boolean add(posinformation post) {
		return postdao.add(post);

	}
//删
	@Override
	public boolean del(posinformation post) {
		return postdao.del(post);

	}

	@Override
	public boolean update(posinformation post) {
		return postdao.update(post);

	}
//查全部
	@Override
	public List<posinformation> selectall() {
		
		
		return postdao.selectall();
		     
	}

	
	@Override
	public posinformation select(posinformation post) {
		// TODO Auto-generated method stub
		return postdao.select(post);
	}
	
	
//模糊查询
	@Override
	public List<posinformation> mohu(posinformation post) {
		return postdao.mohu(post);
		
	}



	@Override
	  public List<posinformation> queryAllPost(PageBean pageBean, posinformation postinformation){
		// TODO Auto-generated method stub
		return postdao.queryAllPost(pageBean, postinformation);
	}

	@Override
	public int postDelete(String delIds) {
		// TODO Auto-generated method stub
		return postdao.postDelete(delIds);
	}

	@Override
	public int postCount(posinformation postinformation) {
		
		return postdao.postCount(postinformation);
	}


}
