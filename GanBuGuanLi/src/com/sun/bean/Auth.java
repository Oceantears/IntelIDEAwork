package com.sun.bean;

import java.util.ArrayList;
import java.util.List;

/*
 * »®œﬁ¿‡
 * */
public class Auth {
	private int auth_id;
	private String auth_name;
	private String auth_icon;
	private int group_au_id;
	private String action;
	private String viewmode;
	
	private List<Admin> adminList=new ArrayList<>();

	public int getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public String getAuth_icon() {
		return auth_icon;
	}

	public void setAuth_icon(String auth_icon) {
		this.auth_icon = auth_icon;
	}

	public int getGroup_au_id() {
		return group_au_id;
	}

	public void setGroup_au_id(int group_au_id) {
		this.group_au_id = group_au_id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getViewmode() {
		return viewmode;
	}

	public void setViewmode(String viewmode) {
		this.viewmode = viewmode;
	}

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}

	@Override
	public String toString() {
		return "Auth [auth_id=" + auth_id + ", auth_name=" + auth_name + ", auth_icon=" + auth_icon + ", group_au_id="
				+ group_au_id + ", action=" + action + ", viewmode=" + viewmode + ", adminList=" + adminList + "]";
	}

	public Auth(int auth_id, String auth_name, String auth_icon, int group_au_id, String action, String viewmode,
			List<Admin> adminList) {
		super();
		this.auth_id = auth_id;
		this.auth_name = auth_name;
		this.auth_icon = auth_icon;
		this.group_au_id = group_au_id;
		this.action = action;
		this.viewmode = viewmode;
		this.adminList = adminList;
	}

	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
