/**
 * <一句话功能简述>
 * <p>
 * Student类Bean层
 *
 * @author sunmeng
 * @create 2020/4/13   18:53
 */
package com.wechatcontext.contextdemo.model;

public class StudentDomain {
	private String sNo;
	private String sName;
	private String sSex;
	private String sBirthday;
	private String classes;

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public String getsBirthday() {
		return sBirthday;
	}

	public void setsBirthday(String sBirthday) {
		this.sBirthday = sBirthday;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "StudentDomain{" +
				"sNo='" + sNo + '\'' +
				", sName='" + sName + '\'' +
				", sSex='" + sSex + '\'' +
				", sBirthday='" + sBirthday + '\'' +
				", classes='" + classes + '\'' +
				'}';
	}
}
