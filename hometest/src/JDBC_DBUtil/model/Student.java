/**
 * <一句话功能简述>
 * <学生类，储存学生信息>
 *
 * @author sunmeng
 * @create 2019/10/8   15:31
 */
package JDBC_DBUtil.model;


import java.util.Date;

public class Student {
	private Integer id;
	private String stu_name;
	private String address;
	private Integer zip;
	private Integer tel;
	private String email;
	private Character depno;
	private Date birthday;
	private Character sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getDepno() {
		return depno;
	}

	public void setDepno(Character depno) {
		this.depno = depno;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}


}
