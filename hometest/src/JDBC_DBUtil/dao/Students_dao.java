/**
 * <一句话功能简述>
 * <对homework1表的增删改查方法>
 *
 * @author sunmeng
 * @create 2019/10/8   15:40
 */
package JDBC_DBUtil.dao;

import JDBC_DBUtil.DBUtil;
import JDBC_DBUtil.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Students_dao {
	public void addStudent(){

	}
	public void updateStudent(){

	}
	public void delStudent(){

	}
	public List<Student> query() throws SQLException {
		Connection connection= DBUtil.getConnection();
		//3.通过数据库的连接操作数据库，实现增删改查
		Statement statement=connection.createStatement();
		ResultSet rs= statement.executeQuery("select * from homework1");

		List<Student> stuList=new ArrayList<Student>();
		Student stu=null;
		while (rs.next()){
			stu=new Student();
			stu.setStu_name(rs.getString("NAME"));
			stu.setId(rs.getInt("Num"));
			stuList.add(stu);
		}
		return stuList;
	}
	public Student getStudent(){
		return null;
	}
}
