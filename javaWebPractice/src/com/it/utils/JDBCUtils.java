/**
 * <一句话功能简述>
 * <>
 *
 * @author sunmeng
 * @create 2019/11/14   10:12
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
	创建连接池BasicDataSource
	 */
	public static BasicDataSource dataSource=new BasicDataSource();

	//静态代码块
	static {
		//Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串,继承自HashTable
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

		//对连接池对象 进行基本的配置
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		//最大连接数量
		dataSource.setMaxActive(10);
		//最小空闲连接
		dataSource.setMinIdle(2);
		//最大空闲连接
		dataSource.setMaxIdle(5);

	}

	/*
	返回连接池对象
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
}
