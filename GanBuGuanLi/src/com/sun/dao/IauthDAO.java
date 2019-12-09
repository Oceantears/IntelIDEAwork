package com.sun.dao;

import java.util.List;

import com.cadre.bean.Cadre;
import com.sun.bean.Admin;
import com.sun.bean.Auth;

public interface IauthDAO {
		//添加权限
		public void addAuth(Auth auth);
		//修改权限
		public void updateAuth(Auth auth);
		//删除权限
		public void delAuth(Auth auth);
		//查询全部权限
		public List<Auth> queryAllAuth(Auth auth);
		//单个权限查询
		public Auth findAuthByID(Auth auth);
		
		//根据角色查权限
		public List<Auth> queryAllAuth(Admin admin);
		public List<Auth> queryAllAuth(Cadre cadre);
		//查询可见表示
		public String viewmode(Auth auth);
}
