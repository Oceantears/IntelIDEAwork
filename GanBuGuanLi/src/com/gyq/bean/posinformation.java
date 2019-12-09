package com.gyq.bean;
/**
 * 

 * @author jy
 */
public class posinformation {

	 
	private String ks_no; //科室编号
	private String job_no; //职位编号
	private String job_title; // 职位名称
	private String job_description; //描述职位
	private String job_duenum; //职位应有人数
	private String job_realitynum; // 职位现有人数
	private String shortage_num;  //职位短缺人数
	private String job_preparation; // 职位编制
	public String getKs_no() {
		return ks_no;
	}
	public void setKs_no(String ks_no) {
		this.ks_no = ks_no;
	}
	public String getJob_no() {
		return job_no;
	}
	public void setJob_no(String job_no) {
		this.job_no = job_no;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getJob_duenum() {
		return job_duenum;
	}
	public void setJob_duenum(String job_duenum) {
		this.job_duenum = job_duenum;
	}
	public String getJob_realitynum() {
		return job_realitynum;
	}
	public void setJob_realitynum(String job_realitynum) {
		this.job_realitynum = job_realitynum;
	}
	public String getShortage_num() {
		return shortage_num;
	}
	public void setShortage_num(String shortage_num) {
		this.shortage_num = shortage_num;
	}
	public String getJob_preparation() {
		return job_preparation;
	}
	public void setJob_preparation(String job_preparation) {
		this.job_preparation = job_preparation;
	}
	public posinformation(String ks_no, String job_no, String job_title, String job_description, String job_duenum,
			String job_realitynum, String shortage_num, String job_preparation) {
		super();
		this.ks_no = ks_no;
		this.job_no = job_no;
		this.job_title = job_title;
		this.job_description = job_description;
		this.job_duenum = job_duenum;
		this.job_realitynum = job_realitynum;
		this.shortage_num = shortage_num;
		this.job_preparation = job_preparation;
	}
	public posinformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Post [ks_no=" + ks_no + ", job_no=" + job_no + ", job_title=" + job_title + ", job_description="
				+ job_description + ", job_duenum=" + job_duenum + ", job_realitynum=" + job_realitynum
				+ ", shortage_num=" + shortage_num + ", job_preparation=" + job_preparation + "]";
	}
	
	
	
}
