package com.it.bean;

import java.io.Serializable;

/**
 * 
 * Title:
 * Description:com.it.bean.Users.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */

public class Users  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user_name;
	private int user_age;
	private double user_weight;
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the user_age
	 */
	public int getUser_age() {
		return user_age;
	}
	/**
	 * @param user_age the user_age to set
	 */
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	/**
	 * @return the user_weight
	 */
	public double getUser_weight() {
		return user_weight;
	}
	/**
	 * @param user_weight the user_weight to set
	 */
	public void setUser_weight(double user_weight) {
		this.user_weight = user_weight;
	}
	/**
	 * @param user_id
	 * @param user_name
	 * @param user_age
	 * @param user_weight
	 */
	public Users(int user_id, String user_name, int user_age, double user_weight) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_weight = user_weight;
	}
	/**
	 * 
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_name=" + user_name + ", user_age=" + user_age + ", user_weight="
				+ user_weight + "]";
	}
	

}
