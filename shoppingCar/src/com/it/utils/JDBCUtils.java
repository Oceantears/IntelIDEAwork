/**
 * <一句话功能简述>
 * <获取getConnection>
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

	static BasicDataSource dataSource=new BasicDataSource();                  //连接池

	//静态代码块
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

		//最大连接数量
		dataSource.setMaxActive(10);
		//最小空闲连接
		dataSource.setMinIdle(2);
		//最大空闲连接
		dataSource.setMaxIdle(5);

	}

	public static DataSource getDatasource(){
		return dataSource;
	}
}
