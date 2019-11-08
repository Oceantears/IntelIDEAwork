/**
 * <一句话功能简述>
 * <sys_user类的DAO实现类>
 *
 * @author sunmeng
 * @create 2019/11/6   0:28
 */
package com.it.dao.sys_user;

import com.it.bean.Sys_user;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Sys_user_DAOImpl implements Isys_user_DAO {
	QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public void addSys_user(Sys_user sys_user) {
		String sql="insert into sys_user (user_code,user_name,user_password,user_state) values (?,?,?,?)";
		Object[] params={sys_user.getUser_code(),sys_user.getUser_name(),sys_user.getUser_password(),sys_user.getUser_state()};

		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("============添加成功===============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("管理员添加操作失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delSys_user(Sys_user sys_user) {
		String sql="delete from sys_user where user_id=?";
		Object[] params={sys_user.getUser_id()};

		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("============删除成功================>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("管理员删除操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updSys_user(Sys_user sys_user) {
		String sql="update sys_user set user_code=?,user_name=?,user_password=?,user_state=?";
		Object[] params={sys_user.getUser_code(),sys_user.getUser_name(),sys_user.getUser_password(),sys_user.getUser_state()};

		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("=========修改成功================>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("管理员修改操作失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Sys_user findUserById(Sys_user sys_user) {
		String sql="select * from sys_user where user_id=?";
		Object[] params={sys_user.getUser_id()};
		Sys_user user=null;
		try {
			user =queryRunner.query(sql,new BeanHandler<Sys_user>(Sys_user.class),params);
			System.out.println("===============查找管理员成功=============>"+user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找管理员操作失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public List<Sys_user> queryAllUsers(Sys_user sys_user) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from sys_user where 1=1 ");
		//1 保证对象不为null,分配了内存空间
		if(sys_user!=null){
			//2 判断哪些字段有模糊查询
			// 用户名，用户账号 做一下模糊查询
			//保证name有值
			if(!"".equals(sys_user.getUser_code())){
				sql.append("and user_code like '%"+sys_user.getUser_code()+"%'");
			}
			if(!"".equals(sys_user.getUser_name())){
				sql.append("and user_name like '%"+sys_user.getUser_name()+"%'");
			}

		}

		List<Sys_user> users=null;
		try {
			users=queryRunner.query(sql.toString(),new BeanListHandler<Sys_user>(Sys_user.class));
			System.out.println("==============模糊查询=================>"+users.size());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询全部/模糊管理员失败");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public boolean logIn(Sys_user sys_user) {
		String sql="select * from sys_user where user_name=? and user_password=?";
		Object[] params={sys_user.getUser_name(),sys_user.getUser_password()};
		Sys_user user=null;
		try {
			user=queryRunner.query(sql,new BeanHandler<>(Sys_user.class),params);
			if(user!=null){
				System.out.println("==========登陆成功===================>"+user);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("登录失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
