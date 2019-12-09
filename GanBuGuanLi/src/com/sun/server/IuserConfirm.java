/**
 * <һ�仰���ܼ���>
 * <�û���¼ȷ����ݺ�Ȩ�޽ӿ�>
 *
 * @author sunmeng
 * @create 2019/11/28   17:48
 */
package com.sun.server;

import com.cadre.bean.Cadre;
import com.sun.bean.Auth;
import com.sun.bean.Group_auth;
import com.sun.bean.User;

import java.util.List;

public interface IuserConfirm {
	//�����û�����ݺ����������֤�������֤ͨ���������û������Ϣ
	public Cadre confirmEmp(int userId,String userName) throws Exception;
	//�����û��˺Ų�ѯ�û���Ϣ
	public Cadre findEmpbyID(int employee_id) throws Exception;
	//�����û�id��ѯȨ�޷�Χ�ڵĲ˵�
	public List<Group_auth> findGroup(int employee_id) throws Exception;
	//�����û�id��ѯȨ�޷�Χ�ڵ�url
	public List<Auth> findEmpAuth(int employee_id) throws Exception;
	public User getUser(int userId, String userName);
	//ͨ����Ȩ�޲��Ҷ�Ӧ��Ȩ��
	public List<Auth> findAuths(Group_auth group_auth);
}
