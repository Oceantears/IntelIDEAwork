package com.sun.dao;

import java.util.List;

import com.sun.bean.GroupAdmin;

public interface IgroupAdminDAO {
	//��ӹ����ν
	public void addGroupAdmin(GroupAdmin groupadmin);
	//ɾ�������ν
	public void delGroupAdmin(GroupAdmin groupadmin);
	//�޸Ĺ����ν
	public void updateGroupAdmin(GroupAdmin groupadmin);
	//��ѯ���й����ν
	public List<GroupAdmin> queryAllGroupAdmin(GroupAdmin groupadmin);
	//��ѯ���������ν
	public GroupAdmin findGroupAdminByID(GroupAdmin groupadmin);

}
