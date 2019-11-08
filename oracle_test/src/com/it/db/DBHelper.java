/**
 * <一句话功能简述>
 *
 * <Oracle连接JDBC>
 *
 * @author sunmeng
 * @create 2019/10/27   15:40
 */
package com.it.db;

import java.sql.*;


public class DBHelper {
	public static void main(String[] args) {
		Connection conn=null;
		Statement state=null;
		ResultSet rs=null;


		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","tiger");

		if(!conn.isClosed()){
				System.out.println("连接成功！ conn is OK.");
			}else {
			System.out.println("连接失败！！ conn is error.");
		}
		String sql="select * from emp";           //语句不加分号
		state=conn.createStatement();
		rs=state.executeQuery(sql);
		while (rs.next()){
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
