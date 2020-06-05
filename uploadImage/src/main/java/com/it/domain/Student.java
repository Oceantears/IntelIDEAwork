/**
 * <一句话功能简述>
 * <p>
 * 学生类
 *
 * @author sunmeng
 * @create 2020/5/29   9:44
 */
package com.it.domain;

import java.io.Serializable;

public class Student implements Serializable {
	private Integer sNo;
	private String sName;
	private Integer sSex;
	private String sBirthday;
	private Integer sClasses;

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Integer getsSex() {
		return sSex;
	}

	public void setsSex(Integer sSex) {
		this.sSex = sSex;
	}

	public String getsBirthday() {
		return sBirthday;
	}

	public void setsBirthday(String sBirthday) {
		this.sBirthday = sBirthday;
	}

	public Integer getsClasses() {
		return sClasses;
	}

	public void setsClasses(Integer sClasses) {
		this.sClasses = sClasses;
	}

	@Override
	public String toString() {
		return "Student{" +
				"sNo=" + sNo +
				", sName='" + sName + '\'' +
				", sSex=" + sSex +
				", sBirthday='" + sBirthday + '\'' +
				", sClasses=" + sClasses +
				'}';
	}
}
