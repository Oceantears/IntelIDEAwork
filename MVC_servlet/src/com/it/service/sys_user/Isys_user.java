/**
 * <一句话功能简述>
 * <sys_user类的service接口>
 *
 * @author sunmeng
 * @create 2019/11/6   9:08
 */
package com.it.service.sys_user;

import com.it.bean.Sys_user;

import java.util.List;

public interface Isys_user {
	public void addSys_user(Sys_user sys_user);
	public void delSys_user(Sys_user sys_user);
	public void updSys_user(Sys_user sys_user);
	public Sys_user findUserById(Sys_user sys_user);
	public List<Sys_user> queryAllUsers(Sys_user sys_user);
	public boolean logIn(Sys_user sys_user);
}
