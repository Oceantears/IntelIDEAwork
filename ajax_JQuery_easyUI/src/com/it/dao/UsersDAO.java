package com.it.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.PageBean;
import com.it.bean.Users;
import com.it.utils.JDBCUtils;

/**
 * 
 * Title:
 * Description:com.it.dao.UsersDAO.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class UsersDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
	// 增

	public boolean addUsers(Users users) {
		// 1 编写sql
		String sql = "insert into users(user_name,user_age,user_weight)values(?,?,?)";
		// 2 打印sql
		System.out.println("sql-->" + sql);
		// 3 处理参数
		Object params[] = { users.getUser_name(), users.getUser_age(), users.getUser_weight() };
		// 定义标志位

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			throw new RuntimeException("添加失败!!");
		} finally {
			// 释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
	}

	// 删
	public boolean delUsers(Users users) {
		// 1 编写sql
				String sql = "delete from users where user_id=?";
				// 2 打印sql
				System.out.println("sql-->" + sql);
				// 3 处理参数
				Object params[] = { users.getUser_id() };
				// 定义标志位

				try {
					int rows = queryRunner.update(sql, params);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("删除失败!!");
				} finally {
					// 释放资源到数据库连接池
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!");
					}
				}

	}

	// 改
	public boolean updUsers(Users users) {
		// 1 编写sql
				String sql = "update users set user_name =?,user_age=?,user_weight=? where user_id=?";
				// 2 打印sql
				System.out.println("sql-->" + sql);
				System.out.println(users);
				// 3 处理参数
				Object params[] = { users.getUser_name(), users.getUser_age(), users.getUser_weight(),users.getUser_id() };
				// 定义标志位

				try {
					int rows = queryRunner.update(sql, params);
					return rows > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					throw new RuntimeException("修改失败!!");
				} finally {
					// 释放资源到数据库连接池
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!");
					}
				}
	}

	// 查
	public List<Users> queryAllUsers(Users users) {
		 //编写sql
		String sql = "select * from users where 1=1 ";
		if(users!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(users.getUser_name()) && users.getUser_name()!=null) {
				
				//拼接sql
				sql+="and user_name like '%"+users.getUser_name()+"%' ";
				
			}
			
			if(!"".equals(new Integer(users.getUser_age())) && users.getUser_age()!=0) {
				sql+=" and user_age like '%"+users.getUser_age()+"%'";
				
			}
		}
		
		System.out.println("sql-->"+sql);
		//存放所有Users信息
		List<Users> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(Users.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listU;
	}

	// 查
	public Users findUsersById(Users users) {
		 //编写sql
		String sql = "select * from users where user_id=?";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {users.getUser_id()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return users1;
	}

	/**
	 * 由于没有账户名和密码
	 * 本案例按照id和年龄代替
	 * @param users
	 * @return
	 */
	public boolean login(Users users) {
		 //编写sql
		String sql = "select * from users where user_id=? and user_age=?";
		//2 打印sql
		 System.out.println("sql-->"+sql);
		 //3 处理参数
		 Object params[] = {users.getUser_id(),users.getUser_age()};
		 
		 Users users1 = null;
		 try {
			users1 =  queryRunner.query(sql, new BeanHandler<Users>(Users.class), params);
		    if(users1!=null){
		    	return true;
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("登录失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		
		return false;
	}
	/*
	 * 带分页的查询所有
	 */
	public List<Users> queryAllUsers(PageBean pageBean, Users users) {
		 //编写sql
		StringBuffer sql = new StringBuffer("select * from users where 1=1 ");
		if(users!=null){
			//判定账户名的文本框的合法性
			// "" null判定
			if(!"".equals(users.getUser_name()) && users.getUser_name()!=null) {
				
				//拼接sql
				sql.append("and user_name like '%"+users.getUser_name()+"%' ");
				
			}
			
			if(!"".equals(new Integer(users.getUser_age())) && users.getUser_age()!=0) {
				sql.append(" and user_age like '%"+users.getUser_age()+"%'");
				
			}
		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getRows());
		}
		
		System.out.println("sql-->"+sql);
		//存放所有Users信息
		List<Users> listU = null;
		try {
			listU = queryRunner.query(sql.toString(), new BeanListHandler<>(Users.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return listU;
		
	}
	/**
	 * 查询记录总数
	 * @param user
	 * @return
	 */
	public int userCount(Users user){
		StringBuffer sb = new StringBuffer("select count(*) from users where 1=1 ");
		//有条件判断条件，重新拼接sql
		
		 Number num;
		try {
			num = (Number)queryRunner.query(sb.toString(),new ScalarHandler<>());
		
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		
		
		 
	}
	/**
	 * 删除多条记录
	 * @param delIds
	 * @return
	 */
	public int userDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  users where user_id in (" + delIds + ")";
		 System.out.println("sql--->"+sql);
		try {
			return queryRunner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
