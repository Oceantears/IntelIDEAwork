/**
 * <一句话功能简述>
 * <联系人类>
 *
 * @author sunmeng
 * @create 2019/11/5   22:32
 */
package com.it.bean;

public class Cst_linkman {
	private long lkm_id;
	private String lkm_name;
	private long lkm_cust_id;
	private String lkm_gender;
	private String lkm_phone;
	private String lkm_mobile;
	private String lkm_email;
	private String lkm_qq;
	private String lkm_position;
	private String lkm_memo;

	public Cst_linkman() {
	}

	public Cst_linkman(long lkm_id, String lkm_name, long lkm_cust_id, String lkm_gender, String lkm_phone, String lkm_mobile, String lkm_email, String lkm_qq, String lkm_position, String lkm_memo) {
		this.lkm_id = lkm_id;
		this.lkm_name = lkm_name;
		this.lkm_cust_id = lkm_cust_id;
		this.lkm_gender = lkm_gender;
		this.lkm_phone = lkm_phone;
		this.lkm_mobile = lkm_mobile;
		this.lkm_email = lkm_email;
		this.lkm_qq = lkm_qq;
		this.lkm_position = lkm_position;
		this.lkm_memo = lkm_memo;
	}

	public long getLkm_id() {
		return lkm_id;
	}

	public void setLkm_id(long lkm_id) {
		this.lkm_id = lkm_id;
	}

	public String getLkm_name() {
		return lkm_name;
	}

	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}

	public long getLkm_cust_id() {
		return lkm_cust_id;
	}

	public void setLkm_cust_id(long lkm_cust_id) {
		this.lkm_cust_id = lkm_cust_id;
	}

	public String getLkm_gender() {
		return lkm_gender;
	}

	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}

	public String getLkm_phone() {
		return lkm_phone;
	}

	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}

	public String getLkm_mobile() {
		return lkm_mobile;
	}

	public void setLkm_mobile(String lkm_mobile) {
		this.lkm_mobile = lkm_mobile;
	}

	public String getLkm_email() {
		return lkm_email;
	}

	public void setLkm_email(String lkm_email) {
		this.lkm_email = lkm_email;
	}

	public String getLkm_qq() {
		return lkm_qq;
	}

	public void setLkm_qq(String lkm_qq) {
		this.lkm_qq = lkm_qq;
	}

	public String getLkm_position() {
		return lkm_position;
	}

	public void setLkm_position(String lkm_position) {
		this.lkm_position = lkm_position;
	}

	public String getLkm_memo() {
		return lkm_memo;
	}

	public void setLkm_memo(String lkm_memo) {
		this.lkm_memo = lkm_memo;
	}

	@Override
	public String toString() {
		return "Cst_linkman{" +
				"lkm_id=" + lkm_id +
				", lkm_name='" + lkm_name + '\'' +
				", lkm_cust_id=" + lkm_cust_id +
				", lkm_gender='" + lkm_gender + '\'' +
				", lkm_phone='" + lkm_phone + '\'' +
				", lkm_mobile='" + lkm_mobile + '\'' +
				", lkm_email='" + lkm_email + '\'' +
				", lkm_qq='" + lkm_qq + '\'' +
				", lkm_position='" + lkm_position + '\'' +
				", lkm_memo='" + lkm_memo + '\'' +
				'}';
	}
}
