/**
 * <一句话功能简述>
 * <用户信息类>
 *
 * @author sunmeng
 * @create 2019/11/11   16:52
 */
package com.it.bean;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String user_id;
	private String user_name;
	private String user_pwd;
	private String user_addr;
	private String user_tel;
	private String user_sex;

	public UserInfo() {
	}

	public UserInfo(String user_id, String user_name, String user_pwd, String user_addr, String user_tel, String user_sex) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_addr = user_addr;
		this.user_tel = user_tel;
		this.user_sex = user_sex;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"user_id='" + user_id + '\'' +
				", user_name='" + user_name + '\'' +
				", user_pwd='" + user_pwd + '\'' +
				", user_addr='" + user_addr + '\'' +
				", user_tel='" + user_tel + '\'' +
				", user_sex='" + user_sex + '\'' +
				'}';
	}
}
