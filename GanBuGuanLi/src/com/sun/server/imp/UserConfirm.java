/**
 * <一句话功能简述>
 * <用户登录确认身份和权限>
 *
 * @author sunmeng
 * @create 2019/11/28   16:14
 */
package com.sun.server.imp;

import com.cadre.bean.Cadre;
import com.cadre.dao.Dao;
import com.sun.bean.Auth;
import com.sun.bean.Group_auth;
import com.sun.bean.User;
import com.sun.dao.IUserConfirmDAO;
import com.sun.dao.IauthDAO;
import com.sun.dao.Igroup_authDAO;
import com.sun.dao.imp.AuthDAO_imp;
import com.sun.dao.imp.Group_authDAO_imp;
import com.sun.dao.imp.UserConfirmDAO_imp;
import com.sun.server.IuserConfirm;

import java.util.List;

public class UserConfirm implements IuserConfirm {

	IUserConfirmDAO userConfirmDAO = new UserConfirmDAO_imp();
	Igroup_authDAO group_authDAO = new Group_authDAO_imp();
	IauthDAO authDAO = new AuthDAO_imp();
	Dao cadreDAO = new Dao();
	Cadre cadre = new Cadre();

	@Override
	public Cadre confirmEmp(int userId, String userName) {

		if (!"".equals(userId) && userName != null && (!"".equals(userName))) {
			getUser(userId, userName);
			return userConfirmDAO.confirmEmp(userId, userName);
		}
		throw new RuntimeException("用户名和密码错误！！");
	}

	@Override
	public Cadre findEmpbyID(int employee_id) {
		cadre.setEmployee_id(String.valueOf(employee_id));
		return cadreDAO.findbyid(cadre);
	}

	@Override
	public List<Group_auth> findGroup(int employee_id) {
		cadre.setEmployee_id(String.valueOf(employee_id));
		return group_authDAO.queryAllGroup(cadre);
	}

	@Override
	public List<Auth> findEmpAuth(int employee_id) {
		cadre.setEmployee_id(String.valueOf(employee_id));
		return authDAO.queryAllAuth(cadre);
	}

	@Override
	public List<Auth> findAuths(Group_auth group_auth) {
		return group_authDAO.findAuths(group_auth);
	}

	public User getUser(int userId, String userName) {
		Cadre cadre = this.findEmpbyID(userId);
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		List<Group_auth> groups=this.findGroup(Integer.parseInt(cadre.getEmployee_id()));
		for (Group_auth groupAuth:groups) {
			List<Auth> auths=this.findAuths(groupAuth);
			groupAuth.setChildren(auths);
		}
		user.setGroupAuths(groups);
		// user.setAuths(this.findAuths());
		return user;
	}
}

