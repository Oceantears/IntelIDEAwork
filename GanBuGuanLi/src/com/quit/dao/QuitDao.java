package com.quit.dao;
import java.sql.SQLException;
import java.util.List;

import com.jdbcutils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.quit.bean.PageBean;
import com.quit.bean.Quit;
public class QuitDao {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	public boolean add(Quit quit) {
		String sql="insert into quit values(?,?,?,?,?,?,?)";
		Object []param= {quit.getEmployee_id(),quit.getName(),quit.getSex(),quit.getAge(),quit.getKs_id(),quit.getAdmin_id(),quit.getCause()};
		int i=0;
		try {
			 i=queryRunner.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i>0;
	}
	public boolean update(Quit quit) {
		String sql="update quit set name=?,sex=?,age=?,ks_id=?,admin_id=?,cause=? where employee_id=? ";
		Object []param= {quit.getName(),quit.getSex(),quit.getAge(),quit.getKs_id(),quit.getAdmin_id(),quit.getCause(),quit.getEmployee_id()};
		int i=0;
		try {
			 i=queryRunner.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i>0;
	}
	public boolean del(Quit quit) {
		String sql="delete from quit where employee_id=?";
		Object []param= {quit.getEmployee_id()};
		int i=0;
		try {
			 i=queryRunner.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i>0;
	}
	public int delarray(String delIds) {
		String sql = "delete from  quit where employee_id in (" + delIds + ")";
		try {
			return queryRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public Quit findbyid(Quit quit) {
		String sql = "select * from quit where employee_id=?";
		Object[] param = { quit.getEmployee_id() };
		Quit quit2 = null;
		try {
			quit2 = queryRunner.query(sql, new BeanHandler<Quit>(Quit.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quit2;
	}
	public List<Quit> query(PageBean pageBean, Quit quit) {
		StringBuffer sql = new StringBuffer("select * from quit where 1=1 ");
		if (quit != null) {
			if (!"".equals(quit.getEmployee_id()) && quit.getEmployee_id() != null) {
				sql.append("and employee_id like '%" + quit.getEmployee_id() + "%' ");
			}
			if (!"".equals(quit.getName()) && quit.getName() != null) {
				sql.append(" and name like '%" + quit.getName() + "%'");
			}
		}
		if (pageBean != null){
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		List<Quit> list = null;
		try {
			list = queryRunner.query(sql.toString(), new BeanListHandler<Quit>(Quit.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		return list;
	}
	public int Count(Quit quit) {
		StringBuffer sb = new StringBuffer("select count(*) from cadre where 1=1 ");
		if (quit != null) {
			if (!"".equals(quit.getEmployee_id()) && quit.getEmployee_id() != null) {
				sb.append("and employee_id like '%" + quit.getEmployee_id() + "%' ");
			}
			if (!"".equals(quit.getName()) && quit.getName() != null) {
				sb.append(" and name like '%" + quit.getName() + "%'");
			}
		}
		Number num;
		try {
			num = (Number) queryRunner.query(sb.toString(), new ScalarHandler<>());
			return num.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
	}
}
