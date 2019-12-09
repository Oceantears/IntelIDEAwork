package com.sun.dao.imp;

import com.jdbcutils.JdbcUtils;
import com.sun.bean.Auth;
import com.sun.bean.GroupAdmin;
import com.sun.dao.IgroupAdminDAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GroupAdminDAO_imp implements IgroupAdminDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	String outString;
	@Override
	public void addGroupAdmin(GroupAdmin groupadmin) {
		String sql="insert into group_admin (group_name,group_info) values (?,?)";
		Object[] params= {groupadmin.getGroup_name(),groupadmin.getGroup_info()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0) {
				outString="执行了"+groupadmin.getGroup_name()+"的添加操作";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加管理组失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delGroupAdmin(GroupAdmin groupadmin) {
		String sql="delete from group_admin where group_id=?";
		Object[] params={groupadmin.getGroupId()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+groupadmin.getGroup_name()+"的删除操作";
				System.out.println(outString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除管理组失败!!");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateGroupAdmin(GroupAdmin groupadmin) {
		String sql="update group_admin set group_name=?,group_info=? where group_id=?";
		Object[] params={groupadmin.getGroup_name(),groupadmin.getGroup_info(),groupadmin.getGroupId()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+groupadmin.getGroup_name()+"的更新操作";
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
	public List<GroupAdmin> queryAllGroupAdmin(GroupAdmin groupadmin) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from group_admin where 1=1 ");
		if(groupadmin!=null){
			if(!"".equals(groupadmin.getGroup_name())){
				sql.append("and group_name like '%"+groupadmin.getGroup_name()+"%'");
			}

		}
		List<GroupAdmin> groupAdminList=null;
		try {
			groupAdminList=queryRunner.query(sql.toString(),new BeanListHandler<>(GroupAdmin.class));
			if(groupAdminList!=null){
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
		return groupAdminList;
	}

	@Override
	public GroupAdmin findGroupAdminByID(GroupAdmin groupadmin) {
		String sql="select * from group_admin where group_id=?";
		Object[] parms={groupadmin.getGroupId()};
		GroupAdmin groupAdmin1=null;
		try {
			groupAdmin1=queryRunner.query(sql,new BeanHandler<>(GroupAdmin.class),parms);
			if(groupAdmin1!=null){
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
		return groupAdmin1;
	}
}
