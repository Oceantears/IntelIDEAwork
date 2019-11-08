/**
 * <一句话功能简述>
 * <sys_user类service的接口实现>
 *
 * @author sunmeng
 * @create 2019/11/6   9:04
 */
package com.it.service.sys_user;

import com.it.bean.Sys_user;
import com.it.dao.sys_user.Isys_user_DAO;
import com.it.dao.sys_user.Sys_user_DAOImpl;

import java.util.List;

public class Sys_userImpl implements Isys_user {
	Isys_user_DAO sys_user_dao=new Sys_user_DAOImpl();
	@Override
	public void addSys_user(Sys_user sys_user) {
		try {
			sys_user_dao.addSys_user(sys_user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delSys_user(Sys_user sys_user) {
		try {
			sys_user_dao.delSys_user(sys_user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updSys_user(Sys_user sys_user) {
		try {
			sys_user_dao.updSys_user(sys_user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Sys_user findUserById(Sys_user sys_user) {
		return sys_user_dao.findUserById(sys_user);
	}

	@Override
	public List<Sys_user> queryAllUsers(Sys_user sys_user) {
		return sys_user_dao.queryAllUsers(sys_user);
	}

	@Override
	public boolean logIn(Sys_user sys_user) {
		return sys_user_dao.logIn(sys_user);
	}
}
