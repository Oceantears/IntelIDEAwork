package com.sun.bean;

import java.util.ArrayList;
import java.util.List;

/*
 * 管理角色类
 * */
public class GroupAdmin {
	private int groupId;
	private String group_name;
	private String group_info;
	
	private List<Admin> adminList=new ArrayList<>();
	private List<Auth> authList=new ArrayList<>();
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_info() {
		return group_info;
	}
	public void setGroup_info(String group_info) {
		this.group_info = group_info;
	}
	public List<Admin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	public List<Auth> getAuthList() {
		return authList;
	}
	public void setAuthList(List<Auth> authList) {
		this.authList = authList;
	}
	@Override
	public String toString() {
		return "GroupAdmin [groupId=" + groupId + ", group_name=" + group_name + ", group_info=" + group_info
				+ ", adminList=" + adminList + ", authList=" + authList + "]";
	}
	public GroupAdmin(int groupId, String group_name, String group_info, List<Admin> adminList, List<Auth> authList) {
		super();
		this.groupId = groupId;
		this.group_name = group_name;
		this.group_info = group_info;
		this.adminList = adminList;
		this.authList = authList;
	}
	public GroupAdmin() {
		super();
	}
	
}
