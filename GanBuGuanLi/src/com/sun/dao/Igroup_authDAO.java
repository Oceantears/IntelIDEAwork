package com.sun.dao;

import java.util.List;

import com.cadre.bean.Cadre;
import com.sun.bean.Auth;
import com.sun.bean.Group_auth;

public interface Igroup_authDAO {
	//���Ȩ����
	public void addGroupAuth(Group_auth groupauth);
	//�޸�Ȩ����
	public void updateGroupAuth(Group_auth groupauth);
	//ɾ��Ȩ����
	public void delGroupAuth(Group_auth groupauth);
	//��ѯ����Ȩ����
	public List<Group_auth> queryAllGroup(Group_auth groupauth);
	public List<Group_auth> queryAllGroup(Cadre cadre);
	//ͨ��ID��ѯȨ����
	public Group_auth findGroupByID(Group_auth groupauth);
	
	//ͨ�����ڵ��ѯ�������ӽڵ�
	public List<Auth> findAuths(Group_auth group_auth);


}
