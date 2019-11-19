/**
 * <һ�仰���ܼ���>
 * <��ȡgetConnection>
 *
 * @author sunmeng
 * @create 2019/11/11   17:45
 */
package com.it.utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class JDBCUtils {
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;

	static BasicDataSource dataSource=new BasicDataSource();                  //���ӳ�

	//��̬�����
	static {
		Properties properties=new Properties();
		try {
			properties.load(JDBCUtils.class.getResourceAsStream("/db.properties"));
			driverClassName=properties.getProperty("driverClass");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");


		} catch (IOException e) {
			e.printStackTrace();
		}

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		//�����������
		dataSource.setMaxActive(10);
		//��С��������
		dataSource.setMinIdle(2);
		//����������
		dataSource.setMaxIdle(5);

	}

	public static DataSource getDatasource(){
		return dataSource;
	}
}
