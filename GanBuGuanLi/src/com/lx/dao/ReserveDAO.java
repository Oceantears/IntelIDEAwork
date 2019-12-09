package com.lx.dao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lx.bean.PageBean;

import com.lx.bean.Reserve;
import com.lx.jdbcutils.JdbcUtils;

public class ReserveDAO {

	QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

	// 增
	public void addReserve(Reserve reserve) {
		// 1 编写sql
		String sql = "insert into reservecadre(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		// 2 参数传值
		Object params[] = { reserve.getEmployee_id(), reserve.getWork_exper(), reserve.getName(),
				reserve.getReserveposition() };
		// 3 执行
		System.out.println("sql-->" + sql);
		try {
			int rs = queryRunner.update(sql, params);
			System.out.println(rs);
			if (rs > 0) {
				System.out.println("-----添加成功-------rs-->" + rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("数据库添加操作失败!!");
		} finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 增
	public boolean add(Reserve reserve) {

		// 编写sql语句
		String sql = "insert into reservecadre(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		System.out.println(sql);
		Object params[] = { reserve.getEmployee_id(), reserve.getWork_exper(), reserve.getName(),
				reserve.getReserveposition() };

		try {
			int i = queryRunner.update(sql, params);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加失败!!");
		}

	}

	// 修改
	public boolean updateb(Reserve reserve) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		String sql = "update reservecadre set name=?,work_exper=?,reserveposition=? where employee_id=? ";
		System.out.println(sql);
		Object[] parame = { reserve.getName(), reserve.getWork_exper(), reserve.getReserveposition(),
				reserve.getEmployee_id() };
		try {
			int in = quer.update(sql, parame);
			return in > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改失败!!");
		}

	}

	// 模糊查
	public List<Reserve> mohu(Reserve reserve) {

		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		StringBuffer sql = new StringBuffer();

		sql.append("select * from reservecadre where 1=1");

		// 判断name不为空
		if (reserve.getName() != null) {
			if (!" ".equals(reserve.getName()) && reserve.getName() != null) {
				// 2.拼接sql
				sql.append(" and name like '%" + reserve.getName() + "%' ");

			}
		}
		List<Reserve> list = null;
		try {

			list = quer.query(sql.toString(), new BeanListHandler<Reserve>(Reserve.class));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// 查询单个
	public Reserve findReserveById(Reserve reserve) {
		String sql = "select * from reservecadre where employee_id = ? ";
		// 2 参数传值
		Object params[] = { reserve.getEmployee_id() };

		Reserve reserves = null;
		try {
			reserves = queryRunner.query(sql, new BeanHandler<Reserve>(Reserve.class), params);

			System.out.println("reserves--->" + reserves);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("数据库查询单个操作失败!!");
		} finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return reserves;
	}

	// 带分页查询
	public List<Reserve> queryAllReserve(PageBean pageBean, Reserve reserve) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM reservecadre where 1=1");

		// 1 保证对象不为null,分配了内存空间
		if (reserve != null) {
			// 2 判断哪些字段有模糊查询
			// name,age做一下模糊查询
			// 保证name有值
			if (!"".equals(reserve.getName()) && reserve.getName() != null) {

				// 拼接sql
				sql.append(" and name like '%" + reserve.getName() + "%'");

			}

		}

		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}

		List<Reserve> listU = null;

		System.out.println("sql-->" + sql.toString());

		try {
			listU = queryRunner.query(sql.toString(), new BeanListHandler<Reserve>(Reserve.class));

			System.out.println("listU--->" + listU.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("数据库查询操作失败!!");
		} finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listU;
	}

	// 删除单个
	public boolean del(Reserve reserve) {
		// QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		String sql = "delete from reservecadre where employee_id=?";
		System.out.println(sql);
		Object[] parame = { reserve.getEmployee_id() };
		try {
			int i = queryRunner.update(sql, parame);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除失败!!");
		}

	}

// 总记录数
	public int ReserveCount(Reserve reserve) {
		QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		StringBuffer sb = new StringBuffer("select count(*) from reservecadre ");
		// 有条件判断条件，重新拼接sql
		if (reserve != null) {
			// 判定账户名的文本框的合法性
			// "" null判定

			if (!"".equals(reserve.getName()) && reserve.getName() != null) {
				sb.append(" and name like '%" + reserve.getName() + "%'");

			}
		}
		long num=0;
		try {
			num = queryRunner.query(sb.toString(), new ScalarHandler<>());

			return (int)num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
			//throw new RuntimeException("查询数据失败!");
		}
	}

	// 删除多个
	public int ReserveDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  reservecadre where employee_id in (" + delIds + ")";
		System.out.println("sql--->" + sql);
		try {
			return queryRunner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	// 查单个

	public Reserve select(Reserve reserve) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		String sql = "SELECT * FROM reservecadre WHERE employee_id=?";
		System.out.println(sql);
		Object[] parame = { reserve.getEmployee_id() };
		Reserve list = null;
		try {

			list = quer.query(sql, new BeanHandler<Reserve>(Reserve.class), parame);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
