package com.sun.dao;

import java.util.List;

import com.sun.bean.Daily_record;

public interface Idaily_recordDAO {
	//�����־
	public void addDaily(Daily_record daily_record);
	// //�޸���־
	// public void updateDaily(Daily_record daily_record);
	// //ɾ����־
	// public void delDaily(Daily_record daily_record);
	//��ѯ��־
	public List<Daily_record> queryAllDaily(Daily_record daily_record);
	//��ѯ������־
	public Daily_record findDailyByID(Daily_record daily_record);
}
