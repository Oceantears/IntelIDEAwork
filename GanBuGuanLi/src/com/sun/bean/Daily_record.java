package com.sun.bean;

public class Daily_record {
	private int admin_id;
	private String upd_time;
	private String things;
	private int dailyId;

	public Daily_record() {
	}

	public Daily_record(int admin_id, String upd_time, String things, int dailyId) {
		this.admin_id = admin_id;
		this.upd_time = upd_time;
		this.things = things;
		this.dailyId = dailyId;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getUpd_time() {
		return upd_time;
	}

	public void setUpd_time(String upd_time) {
		this.upd_time = upd_time;
	}

	public String getThings() {
		return things;
	}

	public void setThings(String things) {
		this.things = things;
	}

	public int getDailyId() {
		return dailyId;
	}

	public void setDailyId(int dailyId) {
		this.dailyId = dailyId;
	}

	@Override
	public String toString() {
		return "Daily_record{" +
				"admin_id=" + admin_id +
				", upd_time='" + upd_time + '\'' +
				", things='" + things + '\'' +
				", dailyId=" + dailyId +
				'}';
	}
}
