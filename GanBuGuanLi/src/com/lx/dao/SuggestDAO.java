package com.lx.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.lx.bean.PageBean;
import com.lx.bean.Reserve;
import com.lx.bean.Suggest;
import com.lx.jdbcutils.JdbcUtils;

public class SuggestDAO {

	QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

	public void addSuggest(Suggest suggest) {
		// 1 编写sql
		String sql = "insert into suggest(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		// 2 参数传值
		Object params[] = { suggest.getEmployee_id(), suggest.getWork_exper(), suggest.getName(),
				suggest.getReserveposition() };
		// 3 执行

		try {
			int rs = queryRunner.update(sql, params);
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
	public boolean add(Suggest suggest) {

		// 编写sql语句
		String sql = "insert into suggest(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		System.out.println(sql);
		Object params[] = { suggest.getEmployee_id(), suggest.getWork_exper(), suggest.getName(),
				suggest.getReserveposition() };

		try {
			int i = queryRunner.update(sql, params);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加失败!!");
		}

	}

	public boolean updateb(Suggest suggest) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		String sql = "update suggest set name=?,work_exper=?,reserveposition=? where employee_id=? ";
		System.out.println(sql);
		Object[] parame = { suggest.getName(), suggest.getWork_exper(), suggest.getReserveposition(),
				suggest.getEmployee_id() };
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
	public List<Suggest> mohu(Suggest suggest) {

		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		StringBuffer sql = new StringBuffer();

		sql.append("select * from suggest where 1=1");

		// 判断name不为空
		if (suggest.getName() != null) {
			if (!" ".equals(suggest.getName()) && suggest.getName() != null) {
				// 2.拼接sql
				sql.append(" and name like '%" + suggest.getName() + "%' ");

			}
		}
		List<Suggest> list = null;
		try {

			list = quer.query(sql.toString(), new BeanListHandler<Suggest>(Suggest.class));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Suggest findSuggestById(Suggest suggest) {
		String sql = "select * from suggest where employee_id = ? ";
		// 2 参数传值
		Object params[] = { suggest.getEmployee_id() };

		Suggest suggests = null;
		try {
			suggests = queryRunner.query(sql, new BeanHandler<Suggest>(Suggest.class), params);

			System.out.println("suggests--->" + suggests);
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

		return suggests;
	}

	// 带分页的查询全部
	public List<Suggest> queryAllSuggest(PageBean pageBean, Suggest suggest) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM suggest where 1=1 ");

		System.out.println("suggest--->"+suggest);
		// 1 保证对象不为null,分配了内存空间
		if (suggest!= null) {
			
		
			if (!"".equals(suggest.getName()) && suggest.getName() != null) {

				// 拼接sql
				sql.append(" and name like '%" + suggest.getName() + "%'");

			}

		}

		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows()+";");
		}

		List<Suggest> listU = null;

		System.out.println("sql-->" + sql.toString());

		try {
			listU = queryRunner.query(sql.toString(), new BeanListHandler<Suggest>(Suggest.class));

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
	public boolean del(Suggest suggest) {
		 QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		String sql = "delete from suggest where employee_id=?";
		System.out.println(sql);
		Object[] parame = { suggest.getEmployee_id() };
		try {
			int i = queryRunner.update(sql, parame);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除失败!!");
		}

	}

	// 删除多个
	public int SuggestDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from suggest where employee_id in (" + delIds + ")";
		System.out.println("sql--->" + sql);
		try {
			return queryRunner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int SuggestCount(Suggest suggest) {
		QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		StringBuffer sb = new StringBuffer("select count(*) from suggest ");
		// 有条件判断条件，重新拼接sql
		if (suggest != null) {
			// 2 判断哪些字段有模糊查询
			// name,age做一下模糊查询
			// 保证name有值
			
			if (!"".equals(suggest.getName()) && suggest.getName() != null) {

				// 拼接sql
				sb.append(" and name like '%" + suggest.getName() + "%'");

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
	// 查单个

	public Suggest select(Suggest suggest) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		String sql = "SELECT * FROM suggest WHERE employee_id=?";
		System.out.println(sql);
		Object[] parame = { suggest.getEmployee_id() };
		Suggest list = null;
		try {

			list = quer.query(sql, new BeanHandler<Suggest>(Suggest.class), parame);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
