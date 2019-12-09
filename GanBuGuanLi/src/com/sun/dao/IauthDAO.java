package com.sun.dao;

import java.util.List;

import com.cadre.bean.Cadre;
import com.sun.bean.Admin;
import com.sun.bean.Auth;

public interface IauthDAO {
		//���Ȩ��
		public void addAuth(Auth auth);
		//�޸�Ȩ��
		public void updateAuth(Auth auth);
		//ɾ��Ȩ��
		public void delAuth(Auth auth);
		//��ѯȫ��Ȩ��
		public List<Auth> queryAllAuth(Auth auth);
		//����Ȩ�޲�ѯ
		public Auth findAuthByID(Auth auth);
		
		//���ݽ�ɫ��Ȩ��
		public List<Auth> queryAllAuth(Admin admin);
		public List<Auth> queryAllAuth(Cadre cadre);
		//��ѯ�ɼ���ʾ
		public String viewmode(Auth auth);
}
