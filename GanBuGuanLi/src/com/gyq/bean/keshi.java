package com.gyq.bean;

public class keshi {
	
	private int Ks_no;
	private String Ks_name;
	private String Ks_prin;
	private String Ks_desc;
	public int getKs_no() {
		return Ks_no;
	}
	public void setKs_no(int ks_no) {
		Ks_no = ks_no;
	}
	public String getKs_name() {
		return Ks_name;
	}
	public void setKs_name(String ks_name) {
		Ks_name = ks_name;
	}
	public String getKs_prin() {
		return Ks_prin;
	}
	public void setKs_prin(String ks_prin) {
		Ks_prin = ks_prin;
	}
	public String getKs_desc() {
		return Ks_desc;
	}
	public void setKs_desc(String ks_desc) {
		Ks_desc = ks_desc;
	}
	public keshi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public keshi(int ks_no, String ks_name, String ks_prin, String ks_desc) {
		super();
		Ks_no = ks_no;
		Ks_name = ks_name;
		Ks_prin = ks_prin;
		Ks_desc = ks_desc;
	}
	@Override
	public String toString() {
		return "keshi [Ks_no=" + Ks_no + ", Ks_name=" + Ks_name + ", Ks_prin=" + Ks_prin + ", Ks_desc=" + Ks_desc + "]";
	}
	

}
