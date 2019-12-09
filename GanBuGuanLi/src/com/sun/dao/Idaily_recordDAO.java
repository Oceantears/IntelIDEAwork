package com.sun.dao;

import java.util.List;

import com.sun.bean.Daily_record;

public interface Idaily_recordDAO {
	//添加日志
	public void addDaily(Daily_record daily_record);
	// //修改日志
	// public void updateDaily(Daily_record daily_record);
	// //删除日志
	// public void delDaily(Daily_record daily_record);
	//查询日志
	public List<Daily_record> queryAllDaily(Daily_record daily_record);
	//查询单个日志
	public Daily_record findDailyByID(Daily_record daily_record);
}
