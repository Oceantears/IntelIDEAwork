package com.sun.dao.imp;

import com.cadre.bean.Cadre;
import com.jdbcutils.JdbcUtils;
import com.sun.bean.Admin;
import com.sun.bean.Auth;
import com.sun.dao.IauthDAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AuthDAO_imp implements IauthDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	String outString;
	@Override
	public void addAuth(Auth auth) {
		String sql="insert into auth (auth_name,auth_icon,group_au_id,action,viewmode) values (?,?,?,?,?)";
		Object[] params= {auth.getAuth_name(),auth.getAuth_icon(),auth.getGroup_au_id(),auth.getAction(),auth.getViewmode()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0) {
				outString="执行了"+auth.getAuth_name()+"的添加操作";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加权限失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateAuth(Auth auth) {
		String sql="update auth set auth_name=?,auth_icon=?,group_au_id=?,action=?,viewmode=? where auth_id=?";
		Object[] params={auth.getAuth_name(),auth.getAuth_icon(),auth.getGroup_au_id(),auth.getAction(),auth.getViewmode(),auth.getAuth_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+auth.getAuth_name()+"的更新操作";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新权限失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delAuth(Auth auth) {
		String sql="delete from auth where auth_id=?";
		Object[] params={auth.getAuth_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+auth.getAuth_name()+"的删除操作";
				System.out.println(outString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除权限失败!!");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Auth> queryAllAuth(Auth auth) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from auth where 1=1 ");
		if(auth!=null){
			if(!"".equals(auth.getGroup_au_id())){
				sql.append("and group_au_id like '%"+auth.getGroup_au_id()+"%'");
			}
			if(!"".equals(auth.getViewmode())){
				sql.append("and viewmode like '%"+auth.getViewmode()+"%'");
			}
		}
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql.toString(),new BeanListHandler<>(Auth.class));
			if(authList!=null){
				System.out.println("查询组权限成功！！");
			}
			else {
				System.out.println("查询组权限失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询组权限失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

	@Override
	public Auth findAuthByID(Auth auth) {
		String sql="select * from auth where auth_id=?";
		Object[] parms={auth.getAuth_id()};
		Auth auth1=null;
		try {
			auth1=queryRunner.query(sql,new BeanHandler<>(Auth.class),parms);
			if(auth1!=null){
				System.out.println("查找单个权限成功！！");
			}
			else {
				System.out.println("查找单个权限失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找单个权限失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return auth1;
	}

	@Override
	public List<Auth> queryAllAuth(Admin admin) {
		String sql="select * from auth where auth_id in (select auth_id from auth_group where group_id in (select group_id from admin_group where admin_id in (select admin_id from admin where admin_position=?)))";
		Object[] params={admin.getAdmin_position()};
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql,new BeanListHandler<>(Auth.class),params);
			if(authList!=null){
				System.out.println("根据职位查询权限成功！！");
			}
			else {
				System.out.println("根据职位查询权限失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据职位查询权限失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

	@Override
	public List<Auth> queryAllAuth(Cadre cadre) {
		String sql="select * from auth where auth_id in (select auth_id from auth_group where group_id in (select group_id from admin_group where admin_id in (select admin_id from cadre where employee_id=?)))";
		Object[] params={cadre.getEmployee_id()};
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql,new BeanListHandler<>(Auth.class),params);
			if(authList!=null){
				System.out.println("根据职位查询权限成功！！");
			}
			else {
				System.out.println("根据职位查询权限失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据职位查询权限失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

	@Override
	public String viewmode(Auth auth) {
		String sql="select viewmode from auth where auth_id=?";
		Object[] params={auth.getAuth_id()};
		String viewmode1=null;
		try {
			viewmode1=queryRunner.query(sql,new BeanHandler<>(String.class),params);
			if(viewmode1!=null){
				System.out.println("权限可见！！");
			}
			else {
				System.out.println("权限不可见！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("权限不可见！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return viewmode1;
	}

	// @Override
	// public int findAuthFather(Auth auth) {
	// 	String sql="select group_au_id from auth where auth_id=?";
	// 	Object[] params={auth.getAuth_id()};
	// 	int authFatherID=-1;
	// 	try {
	// 		authFatherID=queryRunner.query(sql,new BeanHandler<>(Integer.class),params);
	// 		if(authFatherID>=0){
	// 			System.out.println("权限父节点查找成功！！");
	// 		}
	// 		else {
	// 			System.out.println("权限父节点查找失败！！");
	// 		}
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 		throw new RuntimeException("权限父节点查找失败！！");
	// 	}finally {
	// 		try {
	// 			JdbcUtils.getDataSource().getConnection().close();
	// 		} catch (SQLException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	return authFatherID;
	// }
}
