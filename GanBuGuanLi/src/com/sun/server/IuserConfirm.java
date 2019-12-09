/**
 * <一句话功能简述>
 * <用户登录确认身份和权限接口>
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
	//根据用户的身份和密码进行认证，如果认证通过，返回用户身份信息
	public Cadre confirmEmp(int userId,String userName) throws Exception;
	//根据用户账号查询用户信息
	public Cadre findEmpbyID(int employee_id) throws Exception;
	//根据用户id查询权限范围内的菜单
	public List<Group_auth> findGroup(int employee_id) throws Exception;
	//根据用户id查询权限范围内的url
	public List<Auth> findEmpAuth(int employee_id) throws Exception;
	public User getUser(int userId, String userName);
	//通过父权限查找对应子权限
	public List<Auth> findAuths(Group_auth group_auth);
}
