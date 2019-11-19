/**
 * <一句话功能简述>
 * <用户DAO层接口>
 *
 * @author sunmeng
 * @create 2019/11/11   17:43
 */
package com.it.dao.users;

import com.it.bean.UserInfo;

import java.util.List;

public interface IUserDAO {
	public boolean addUserInfo(UserInfo userInfo);
	public boolean delUserInfo(UserInfo userInfo);
	public boolean updUserInfo(UserInfo userInfo);
	public List<UserInfo> queryAllUserInfo(UserInfo userInfo);
	public UserInfo findUserInfoById(UserInfo userInfo);
	public UserInfo login(UserInfo userInfo);

}
