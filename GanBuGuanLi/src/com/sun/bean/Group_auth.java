package com.sun.bean;

import java.util.List;

/*
 * 权限组类
 * */
public class Group_auth {
	private int group_id;
	private String group_name;
	private int father_id;
	private List<Auth> children;

	public List<Auth> getChildren() {
		return children;
	}

	public void setChildren(List<Auth> children) {
		this.children = children;
	}

	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public int getFather_id() {
		return father_id;
	}
	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}
	@Override
	public String toString() {
		return "Group_auth [group_id=" + group_id + ", group_name=" + group_name + ", father_id=" + father_id + "]";
	}
	public Group_auth(int group_id, String group_name, int father_id) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.father_id = father_id;
	}
	public Group_auth() {
		super();
	}
	
}
