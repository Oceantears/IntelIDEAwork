/**
 * <一句话功能简述>
 * <学生类>
 *
 * @author sunmeng
 * @create 2019/10/30   0:11
 */
package com.it.bean;

import java.util.Date;

public class Students {
	private int num;
	private String name;
	private String addr;
	private int zip;
	private int tel;
	private String email;
	private String depno;
	private Date birth;
	private String sex;

	public Students() {
	}

	public Students(int num, String name, String addr, int zip, int tel, String email, String depno, Date birth, String sex) {
		this.num = num;
		this.name = name;
		this.addr = addr;
		this.zip = zip;
		this.tel = tel;
		this.email = email;
		this.depno = depno;
		this.birth = birth;
		this.sex = sex;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepno() {
		return depno;
	}

	public void setDepno(String depno) {
		this.depno = depno;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Students{" +
				"num=" + num +
				", name='" + name + '\'' +
				", addr='" + addr + '\'' +
				", zip=" + zip +
				", tel=" + tel +
				", email='" + email + '\'' +
				", depno=" + depno +
				", birth=" + birth +
				", sex=" + sex +
				'}';
	}

}
