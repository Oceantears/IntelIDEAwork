/**
 * <һ�仰���ܼ���>
 * <ȷ���˺ŵ�¼�ӿ�>
 *
 * @author sunmeng
 * @create 2019/11/28   22:21
 */
package com.sun.dao;

import com.cadre.bean.Cadre;

public interface IUserConfirmDAO {
	//�����û�����ݺ����������֤�������֤ͨ���������û������Ϣ
	public Cadre confirmEmp(int userId,String userName);
}
