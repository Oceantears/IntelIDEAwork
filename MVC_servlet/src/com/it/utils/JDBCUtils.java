/**
 * <һ�仰���ܼ���>
 * <���ݿ����ӳ�>
 *
 * @author sunmeng
 * @create 2019/11/5   22:52
 */
package com.it.utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	/*
	�������ӳ�
	 */
	public static BasicDataSource dataSource=new BasicDataSource();
	//��̬�����
	static {
		//Properties ���ʾ��һ���־õ����Լ���Properties �ɱ��������л�����м��ء������б���ÿ���������Ӧֵ����һ���ַ���,�̳���HashTable
		Properties properties=new Properties();

		try {
			properties.load(JDBCUtils.class.getResourceAsStream("/db.properties"));
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//�����ӳض��� ���л���������
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		//�����������
		dataSource.setMaxActive(10);
		//��С��������
		dataSource.setMinIdle(2);
		//����������
		dataSource.setMaxIdle(5);

	}
	/*
	�������ӳض���
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
}
