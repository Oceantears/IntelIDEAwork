/**
 * <一句话功能简述>
 * <对DBUtil插件的应用>
 *
 * @author sunmeng
 * @create 2019/10/8   14:26
 */
package JDBC_DBUtil;

import java.sql.*;

public class DBUtil {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/homework";
	private static final String NAME="root";
	private static final String PASSWORD="root";
	private static Connection connection=null;

	static{
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库连接
			connection = DriverManager.getConnection(URL,NAME,PASSWORD);
			if(!connection.isClosed()){
				System.out.println("连接成功！");
			}
			else {
				System.out.println("连接失败！");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		return connection;
	}

}
