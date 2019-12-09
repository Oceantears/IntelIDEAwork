package com.sun.dao;

import java.util.List;

import com.sun.bean.Admin;

public interface IadminDAO {
	//添加职位
	public void addAdmin(Admin admin);
	//修改职位
	public void updateAdmin(Admin admin);
	//删除职位
	public void delAdmin(Admin admin);
	//查询全部职位
	public List<Admin> queryAllAdmin(Admin admin);
	//单个查询
	public Admin findAdminByID(Admin admin);
	
}
