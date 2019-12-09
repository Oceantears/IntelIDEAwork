package com.sun.dao.imp;

import com.cadre.bean.Cadre;
import com.jdbcutils.JdbcUtils;
import com.sun.bean.Auth;
import com.sun.bean.Group_auth;
import com.sun.dao.Igroup_authDAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Group_authDAO_imp implements Igroup_authDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	String outString;
	@Override
	public void addGroupAuth(Group_auth groupauth) {
		String sql="insert into group_auth (group_name,father_id) values (?,?)";
		Object[] params= {groupauth.getGroup_name(),groupauth.getFather_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0) {
				outString="执行了"+groupauth.getGroup_name()+"的添加操作";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加权限组失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateGroupAuth(Group_auth groupauth) {
		String sql="update group_auth set group_name=?,father_id=? where group_id=?";
		Object[] params={groupauth.getGroup_name(),groupauth.getFather_id(),groupauth.getGroup_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+groupauth.getGroup_name()+"的更新操作";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("权限组更新失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delGroupAuth(Group_auth groupauth) {
		String sql="delete from group_auth where group_id=?";
		Object[] params={groupauth.getGroup_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+groupauth.getGroup_name()+"的删除操作";
				System.out.println(outString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("权限组删除失败!!");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Group_auth> queryAllGroup(Group_auth groupauth) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from group_auth where 1=1 ");
		if(groupauth!=null){
			if(!"".equals(groupauth.getFather_id())){
				sql.append("and group_au_id like '%"+groupauth.getFather_id()+"%'");
			}
		}
		List<Group_auth> group_authList=null;
		try {
			group_authList=queryRunner.query(sql.toString(),new BeanListHandler<>(Group_auth.class));
			if(group_authList!=null){
				System.out.println("查询全部权限组成功！！");
			}
			else {
				System.out.println("查询全部权限组失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询全部权限组失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return group_authList;
	}

	@Override
	public List<Group_auth> queryAllGroup(Cadre cadre) {
		String sql="select * from group_auth where group_id in (select group_au_id from auth where auth_id in (select auth_id from auth_group where group_id in (select group_id from group_admin where group_name in (select group_name from admin_group where admin_id in (select admin_id from cadre where employee_id=?)))))";
		Object[] params={cadre.getEmployee_id()};
		List<Group_auth> group_authList=null;
		try {
			group_authList=queryRunner.query(sql,new BeanListHandler<>(Group_auth.class),params);
			if(group_authList!=null){
				System.out.println("根据员工查询权限组成功！！");
			}
			else {
				System.out.println("根据员工查询权限组失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("根据员工查询权限组失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return group_authList;
	}

	@Override
	public Group_auth findGroupByID(Group_auth groupauth) {
		String sql="select * from group_auth where group_id=?";
		Object[] params={groupauth.getGroup_id()};
		Group_auth group_auth=null;
		try {
			group_auth=queryRunner.query(sql,new BeanHandler<>(Group_auth.class),params);
			if(group_auth!=null){
				System.out.println("查询单个权限组成功！！");
			}
			else {
				System.out.println("查询单个权限组失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个权限组失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return group_auth;
	}

	@Override
	public List<Auth> findAuths(Group_auth group_auth) {
		String sql="select * from auth where group_au_id=? and viewmode=1";
		Object[] pararms={group_auth.getGroup_id()};
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql,new BeanListHandler<>(Auth.class),pararms);
			if(authList!=null){
				System.out.println("查询对应权限成功！！");
			}
			else {
				System.out.println("查询对应权限失败！！");
			}
			// for (Auth au:authList) {
			// 	if(!"".equals(iauthDAO.viewmode(au))&&(Integer.parseInt(iauthDAO.viewmode(au))==1)){
			// 		authList1.add(au);
			// 	}
			// }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询对应权限失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

}
