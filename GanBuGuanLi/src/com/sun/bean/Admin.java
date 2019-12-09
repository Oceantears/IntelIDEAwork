package com.sun.bean;

import java.util.ArrayList;
import java.util.List;
/*
 * ÷∞Œª¿‡
 * */
public class Admin {
	private	 int admin_id;
	private String admin_position;
	
	private List<GroupAdmin> authList=new ArrayList<>();

	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_position() {
		return admin_position;
	}

	public void setAdmin_position(String admin_position) {
		this.admin_position = admin_position;
	}

	public List<GroupAdmin> getAuthList() {
		return authList;
	}

	public void setAuthList(List<GroupAdmin> authList) {
		this.authList = authList;
	}


	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_position=" + admin_position + ", authList=" + authList + "]";
	}




	public Admin(int admin_id, String admin_position, List<GroupAdmin> authList) {
		super();
		this.admin_id = admin_id;
		this.admin_position = admin_position;
		this.authList = authList;
	}




	public Admin() {
		super();
	}
	
	
}
