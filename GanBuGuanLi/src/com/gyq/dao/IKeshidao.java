package com.gyq.dao;

import java.util.List;

import com.gyq.bean.PageBean;
import com.gyq.bean.keshi;


public interface IKeshidao {
	//增
    public boolean add(keshi ks);
    //删
    public boolean del(keshi ks);
    //改
    public boolean update(keshi ks);
    //查ALL
    public List<keshi> selectall();

  //查单条
    public keshi select(keshi ks);
 

/*
 * //登陆 public boolean logion(Postinformation post);
 */
  //模糊查询
    public List<keshi> mohu(keshi ks);
    
 //带分页查询所有
    public List<keshi> queryAllKs(PageBean pageBean, keshi keshi); 
//删除多条记录
    public int KsDelete(String delksId);
//查询总记录数
    public int KsCount(keshi keshi);
}
