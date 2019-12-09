package com.quit.bean;
public class Quit {
	String employee_id;
	String name;
	String sex;
	String age;
	String ks_id;
	String admin_id;
	String cause;
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getKs_id() {
		return ks_id;
	}
	public void setKs_id(String ks_id) {
		this.ks_id = ks_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Quit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quit(String employee_id, String name, String sex, String age, String ks_id, String admin_id, String cause) {
		this.employee_id = employee_id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.ks_id = ks_id;
		this.admin_id = admin_id;
		this.cause = cause;
	}
	@Override
	public String toString() {
		return "Quit [employee_id=" + employee_id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", ks_id="
				+ ks_id + ", admin_id=" + admin_id + ", cause=" + cause + "]";
	}
}
