/**
 * <一句话功能简述>
 * <查询用户ID对应的权限和权限组接口>
 *
 * @author sunmeng
 * @create 2019/11/28   22:08
 */
package com.sun.server;

import com.sun.bean.Auth;
import com.sun.bean.Group_auth;

import java.util.List;

public interface IEmpAuthsShow {
	//根据用户id查询权限范围内的菜单
	public List<Group_auth> findGroup(int employee_id) throws Exception;
	//根据用户id查询权限范围内的url
	public List<Auth> findEmpAuth(int employee_id) throws Exception;
}
