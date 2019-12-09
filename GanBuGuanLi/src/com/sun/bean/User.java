/**
 * <一句话功能简述>
 * <登录者类>
 *
 * @author sunmeng
 * @create 2019/12/1   20:44
 */
package com.sun.bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	private String userName;
	private int userId;
	private List<Auth> auths;
	private List<Group_auth> groupAuths;
	private String userView;

	public String getUserView() {
		return userView;
	}

	public void setUserView(String userView) {
		this.userView = userView;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Auth> getAuths() {
		return auths;
	}

	public void setAuths(List<Auth> auths) {
		this.auths = auths;
	}

	public List<Group_auth> getGroupAuths() {
		return groupAuths;
	}

	public void setGroupAuths(List<Group_auth> groupAuths) {
		this.groupAuths = groupAuths;
	}
}
