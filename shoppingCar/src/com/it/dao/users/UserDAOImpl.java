/**
 * <一句话功能简述>
 * <用户DAO层实现类>
 *
 * @author sunmeng
 * @create 2019/11/11   17:42
 */
package com.it.dao.users;

import com.it.bean.UserInfo;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDatasource());
	// 增
	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		// 1 编写sql
		String sql = "insert into userinfo(user_name,user_pwd,user_addr,user_addr,user_tel,user_sex)values(?,?,?,?,?,?)";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		// 3 处理参数
		Object params[] = { userInfo.getUser_name(),userInfo.getUser_pwd(),userInfo.getUser_addr(),userInfo.getUser_tel(),userInfo.getUser_sex()};
		// 定义标志位

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("添加失败!!");
		} finally {
			// 释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
	}

	// 删
	@Override
	public boolean delUserInfo(UserInfo userInfo) {
		// 1 编写sql
		String sql = "delete from userinfo where user_id=?";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		// 3 处理参数
		Object params[] = {userInfo.getUser_id()};
		// 定义标志位

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("删除失败!!");
		} finally {
			// 释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}

	}

	// 改
	@Override
	public boolean updUserInfo(UserInfo userInfo) {
		// 1 编写sql
		String sql = "update userinfo set user_name =? where user_id=?";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		System.out.println(userInfo);
		// 3 处理参数
		Object params[] = { userInfo.getUser_name(),userInfo.getUser_id() };
		// 定义标志位

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("修改失败!!");
		} finally {
			// 释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
	}

	// 查
	@Override
	public List<UserInfo> queryAllUserInfo(UserInfo userInfo) {
		//编写sql
		String sql = "select * from userinfo where 1=1 ";
		if(userInfo!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(userInfo.getUser_name()) && userInfo.getUser_name()!=null) {

				//拼接sql
				sql+="and user_name like '%"+userInfo.getUser_name()+"%' ";

			}

			/*if(!"".equals(new Integer(UserInfo.getUser_age())) && UserInfo.getUser_age()!=0) {
				sql+=" and user_age like '%"+UserInfo.getUser_age()+"%'";

			}*/
		}

		System.out.println("sql-->"+sql);
		//存放所有UserInfo信息
		List<UserInfo> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(UserInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listU;
	}

	// 查询单个
	@Override
	public UserInfo findUserInfoById(UserInfo userInfo) {
		//编写sql
		String sql = "select * from userinfo where user_id=?";
		//2 打印sql
		System.out.println("sql-->"+sql);
		//3 处理参数
		Object params[] = {userInfo.getUser_id()};

		UserInfo userInfo1 = null;
		try {
			userInfo1 =  queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return userInfo1;
	}
	/**
	 * 由于没有账户名和密码
	 * 本案例按照id和年龄代替
	 * @param userInfo* @return
	 */
	@Override
	public UserInfo login(UserInfo userInfo) {
		//编写sql
		String sql = "select * from userinfo where user_name=? and user_pwd=?";
		//2 打印sql
		System.out.println("sql-->"+sql);
		//3 处理参数
		Object params[] = {userInfo.getUser_name(),userInfo.getUser_pwd()};

		UserInfo userInfo1 = null;
		try {
			userInfo1 =  queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), params);
			if(userInfo1!=null){
				return userInfo1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}

		return null;
	}
}
