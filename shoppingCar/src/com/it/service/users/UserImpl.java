/**
 * <一句话功能简述>
 * <用户service层实现类>
 *
 * @author sunmeng
 * @create 2019/11/12   10:49
 */
package com.it.service.users;

import com.it.bean.UserInfo;
import com.it.dao.users.IUserDAO;
import com.it.dao.users.UserDAOImpl;

import java.util.List;

public class UserImpl implements IUser {
	IUserDAO userDAO=new UserDAOImpl();
	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		return userDAO.addUserInfo(userInfo);
	}

	@Override
	public boolean delUserInfo(UserInfo userInfo) {
		return userDAO.delUserInfo(userInfo);
	}

	@Override
	public boolean updUserInfo(UserInfo userInfo) {
		return userDAO.updUserInfo(userInfo);
	}

	@Override
	public List<UserInfo> queryAllUserInfo(UserInfo userInfo) {
		return userDAO.queryAllUserInfo(userInfo);
	}

	@Override
	public UserInfo findUserInfoById(UserInfo userInfo) {
		return userDAO.findUserInfoById(userInfo);
	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		return userDAO.login(userInfo);
	}
}
