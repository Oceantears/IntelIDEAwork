/**
 * <一句话功能简述>
 * <p>
 * 权限类
 *
 * @author sunmeng
 * @create 2019/12/19   0:09
 */
package com.sun.mybatis;

public class Auth {
	private String auth_id;
	private String auth_name;
	private String auth_url;
	private String auth_pid;

	public String getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(String auth_id) {
		this.auth_id = auth_id;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public String getAuth_url() {
		return auth_url;
	}

	public void setAuth_url(String auth_url) {
		this.auth_url = auth_url;
	}

	public String getAuth_pid() {
		return auth_pid;
	}

	public void setAuth_pid(String auth_pid) {
		this.auth_pid = auth_pid;
	}

	@Override
	public String toString() {
		return "Auth{" +
				"auth_id='" + auth_id + '\'' +
				", auth_name='" + auth_name + '\'' +
				", auth_url='" + auth_url + '\'' +
				", auth_pid='" + auth_pid + '\'' +
				'}';
	}
}
