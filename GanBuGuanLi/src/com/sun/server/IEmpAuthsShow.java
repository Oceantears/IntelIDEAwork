/**
 * <һ�仰���ܼ���>
 * <��ѯ�û�ID��Ӧ��Ȩ�޺�Ȩ����ӿ�>
 *
 * @author sunmeng
 * @create 2019/11/28   22:08
 */
package com.sun.server;

import com.sun.bean.Auth;
import com.sun.bean.Group_auth;

import java.util.List;

public interface IEmpAuthsShow {
	//�����û�id��ѯȨ�޷�Χ�ڵĲ˵�
	public List<Group_auth> findGroup(int employee_id) throws Exception;
	//�����û�id��ѯȨ�޷�Χ�ڵ�url
	public List<Auth> findEmpAuth(int employee_id) throws Exception;
}
