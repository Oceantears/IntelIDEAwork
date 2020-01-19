/**
 * <一句话功能简述>
 * <p>
 * 用于创建数据源的工具类
 *
 * @author sunmeng
 * @create 2020/1/7   14:44
 */
package com.it.mybatis.utils;

import com.it.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {
	public static Connection getConnection(Configuration cfg){

		//获取一个链接
		try {
			Class.forName(cfg.getDriver());
			return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
