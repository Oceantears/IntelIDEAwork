package com.lx.jdbcutils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;



public class JdbcUtils {

	
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	
	
	//�������ӳ�
	
	public static BasicDataSource basicDataSource=new BasicDataSource();
	
	//������̬��
	
	static{
		
		
		
		
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
		
		try {
			Properties pp=new Properties();
			pp.load(in);
			//pp.load(new FileReader(System.getProperty("user.dir")+"\\src\\db.properties"));
		
			driver=pp.getProperty("driver");
			url=pp.getProperty("url");
			user=pp.getProperty("user");
			pwd=pp.getProperty("pwd");
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(pwd);

	}
	
	
	public static DataSource getDataSource(){
		
		return basicDataSource;
		
	}
	
}
