/**
 * <一句话功能简述>
 * <JDBC连接数据库>
 *
 * @author sunmeng
 * @create 2019/10/16   10:32
 */
package practice20191016.com.it.cbs.bean;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
	public static final String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
	//需要在后面加上?characterEncoding=UTF-8&serverTimezone=GMT，否则传入MySQL的中文是乱码
	public static final String URL="jdbc:mysql://127.0.0.1:3306/cbs?characterEncoding=UTF-8&serverTimezone=GMT";
	public static final String USERNAME="root";
	public static final String PASSWORD="root";

	private static BasicDataSource dataSource=new BasicDataSource();

	static {
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
	}

	public static DataSource getDataSource(){
		return dataSource;
	}
}
