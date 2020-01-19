/**
 * <一句话功能简述>
 * <p>
 * 学生类
 *
 * @author sunmeng
 * @create 2020/1/6   14:50
 */
package com.it.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private Integer sno;
	private String sname;
	private String ssex;
	private Date sbirthday;
	private String classNo;          //班级号

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public Date getSbirthday() {
		return sbirthday;
	}

	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	@Override
	public String toString() {
		return "Student{" +
				"sno=" + sno +
				", sname='" + sname + '\'' +
				", ssex='" + ssex + '\'' +
				", sbirthday=" + sbirthday +
				", classNo='" + classNo + '\'' +
				'}';
	}
}
