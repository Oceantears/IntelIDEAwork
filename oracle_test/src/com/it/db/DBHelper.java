/**
 * <һ�仰���ܼ���>
 *
 * <Oracle����JDBC>
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
			//1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.��ȡ����
			conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","tiger");

		if(!conn.isClosed()){
				System.out.println("���ӳɹ��� conn is OK.");
			}else {
			System.out.println("����ʧ�ܣ��� conn is error.");
		}
		String sql="select * from emp";           //��䲻�ӷֺ�
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
