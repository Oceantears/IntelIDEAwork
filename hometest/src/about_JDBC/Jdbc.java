/**
 * <一句话功能简述>
 * <JDBC链接MySQL,对数据库进行增删改操作(数据库查操作方式不同)>
 *
 * @author sunmeng
 * @create 2019/10/7   15:21
 */
package about_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;

		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1","root","root");

			if(!connection.isClosed()){
				System.out.println("连接成功！");
			}else {
				System.out.println("连接失败！");
			}

				//编写SQL语句
			String sql="insert into test_table(username,password) values ('tianzhiqiang','jfglka')";      //执行增删改操作只需要修改SQL语句即可
				//打印SQL
			System.out.println("sql=================>"+sql);
				//传送SQL
			statement=connection.createStatement();
				//执行并返回
			int resultNum=statement.executeUpdate(sql);
			if(resultNum>0){
				System.out.println("============>操作成功！");
			}
			else {
				System.out.println("============>操作失败！");
			}
				//资源释放，倒序关闭
			statement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
