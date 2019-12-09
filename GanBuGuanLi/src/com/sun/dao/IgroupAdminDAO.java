package com.sun.dao;

import java.util.List;

import com.sun.bean.GroupAdmin;

public interface IgroupAdminDAO {
	//添加管理称谓
	public void addGroupAdmin(GroupAdmin groupadmin);
	//删除管理称谓
	public void delGroupAdmin(GroupAdmin groupadmin);
	//修改管理称谓
	public void updateGroupAdmin(GroupAdmin groupadmin);
	//查询所有管理称谓
	public List<GroupAdmin> queryAllGroupAdmin(GroupAdmin groupadmin);
	//查询单个管理称谓
	public GroupAdmin findGroupAdminByID(GroupAdmin groupadmin);

}
