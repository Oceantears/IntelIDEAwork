package com.sun.dao;

import java.util.List;

import com.cadre.bean.Cadre;
import com.sun.bean.Auth;
import com.sun.bean.Group_auth;

public interface Igroup_authDAO {
	//添加权限组
	public void addGroupAuth(Group_auth groupauth);
	//修改权限组
	public void updateGroupAuth(Group_auth groupauth);
	//删除权限组
	public void delGroupAuth(Group_auth groupauth);
	//查询所有权限组
	public List<Group_auth> queryAllGroup(Group_auth groupauth);
	public List<Group_auth> queryAllGroup(Cadre cadre);
	//通过ID查询权限组
	public Group_auth findGroupByID(Group_auth groupauth);
	
	//通过父节点查询包含的子节点
	public List<Auth> findAuths(Group_auth group_auth);


}
