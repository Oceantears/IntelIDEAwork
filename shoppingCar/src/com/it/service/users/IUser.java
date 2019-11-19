/**
 * <һ�仰���ܼ���>
 * <�û�service��ӿ�>
 *
 * @author sunmeng
 * @create 2019/11/12   10:48
 */
package com.it.service.users;

import com.it.bean.UserInfo;

import java.util.List;

public interface IUser {
	public boolean addUserInfo(UserInfo userInfo);
	public boolean delUserInfo(UserInfo userInfo);
	public boolean updUserInfo(UserInfo userInfo);
	public List<UserInfo> queryAllUserInfo(UserInfo userInfo);
	public UserInfo findUserInfoById(UserInfo userInfo);
	public UserInfo login(UserInfo userInfo);
}
