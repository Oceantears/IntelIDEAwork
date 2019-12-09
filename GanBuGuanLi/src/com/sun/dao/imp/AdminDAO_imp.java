package com.sun.dao.imp;

import java.sql.SQLException;
import java.util.List;

import com.jdbcutils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.sun.bean.Admin;
import com.sun.dao.IadminDAO;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class AdminDAO_imp implements IadminDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	String outString;

	@Override
	public void addAdmin(Admin admin) {
		String sql="insert into admin (admin_position) values (?)";
		Object[] params= {admin.getAdmin_position()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0) {
				outString="执行了"+admin.getAdmin_position()+"的添加操作";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加职位失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		String sql="update admin set admin_position=? where admin_id=?";
		Object[] params={admin.getAdmin_position(),admin.getAdmin_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+admin.getAdmin_position()+"的更新操作";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delAdmin(Admin admin) {
		String sql="delete from admin where admin_id=?";
		Object[] params={admin.getAdmin_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="执行了"+admin.getAdmin_id()+"的删除操作";
				System.out.println(outString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败!!");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Admin> queryAllAdmin(Admin admin) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from admin where 1=1 ");
		if(admin!=null){
			if(!"".equals(admin.getAdmin_position())){
				sql.append("and admin_position like '%"+admin.getAdmin_position()+"%'");
			}
		}
		List<Admin> adminList=null;
		try {
			adminList=queryRunner.query(sql.toString(),new BeanListHandler<Admin>(Admin.class));
			if(adminList!=null){
				System.out.println("查询全部职位成功！！");
			}
			else {
				System.out.println("查询全部职位失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询全部职位失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return adminList;
	}

	@Override
	public Admin findAdminByID(Admin admin) {
		String sql="select * from admin where admin_id=?";
		Object[] parms={admin.getAdmin_id()};
		Admin admin1=null;
		try {
			admin1=queryRunner.query(sql,new BeanHandler<>(Admin.class),parms);
			if(admin1!=null){
				System.out.println("查找单个职位成功！！");
			}
			else {
				System.out.println("查找单个职位失败！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找单个职位失败！！");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin1;
	}

}
