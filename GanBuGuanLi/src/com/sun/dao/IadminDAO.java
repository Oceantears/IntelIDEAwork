package com.sun.dao;

import java.util.List;

import com.sun.bean.Admin;

public interface IadminDAO {
	//���ְλ
	public void addAdmin(Admin admin);
	//�޸�ְλ
	public void updateAdmin(Admin admin);
	//ɾ��ְλ
	public void delAdmin(Admin admin);
	//��ѯȫ��ְλ
	public List<Admin> queryAllAdmin(Admin admin);
	//������ѯ
	public Admin findAdminByID(Admin admin);
	
}
