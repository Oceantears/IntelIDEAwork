/**
 * <一句话功能简述>
 * <确认账号登录接口>
 *
 * @author sunmeng
 * @create 2019/11/28   22:21
 */
package com.sun.dao;

import com.cadre.bean.Cadre;

public interface IUserConfirmDAO {
	//根据用户的身份和密码进行认证，如果认证通过，返回用户身份信息
	public Cadre confirmEmp(int userId,String userName);
}
