/**
 * <一句话功能简述>
 * <Sys_user的DAO接口>
 *
 * @author sunmeng
 * @create 2019/11/6   9:12
 */
package com.it.dao.sys_user;

import com.it.bean.Sys_user;

import java.util.List;

public interface Isys_user_DAO {
	public void addSys_user(Sys_user sys_user);
	public void delSys_user(Sys_user sys_user);
	public void updSys_user(Sys_user sys_user);
	public Sys_user findUserById(Sys_user sys_user);
	public List<Sys_user> queryAllUsers(Sys_user sys_user);
	public boolean logIn(Sys_user sys_user);
}
