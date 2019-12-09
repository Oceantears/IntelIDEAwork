package com.lx.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lx.bean.Changetable;
import com.lx.bean.PageBean;
import com.lx.bean.Reserve;
import com.lx.bean.Suggest;
import com.lx.jdbcutils.JdbcUtils;

public class ChangetableDAO {

	QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

	public void addChangetable(Changetable changetable) {
		// 1 编写sql
		String sql = "insert into changetable(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		// 2 参数传值
		Object params[] = {changetable.getEmployee_id(),changetable.getWork_exper(),changetable.getName(),changetable.getReserveposition()};
		// 3 执行

		try {
			int rs = queryRunner.update(sql, params);
			System.out.println("rs----->"+rs);
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
		public boolean add(Changetable changetable) {

			// 编写sql语句
			String sql = "insert into changetable(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
			System.out.println(sql);
			Object params[] = { changetable.getEmployee_id(), changetable.getWork_exper(), changetable.getName(),
					changetable.getReserveposition() };

			try {
				int i = queryRunner.update(sql, params);
				return i > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("添加失败!!");
			}

		}

		//改
		public boolean updateb(Changetable changetable) {
			QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
			// 编写sql语句
			String sql = "update changetable set name=?,work_exper=?,reserveposition=? where employee_id=? ";
			System.out.println(sql);
			Object[] parame = { changetable.getName(), changetable.getWork_exper(), changetable.getReserveposition(),
					changetable.getEmployee_id() };
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
		public List<Changetable> mohu(Changetable changetable) {

			QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
			// 编写sql语句
			StringBuffer sql = new StringBuffer();

			sql.append("select * from changetable where 1=1");

			// 判断name不为空
			if (changetable.getName() != null) {
				if (!" ".equals(changetable.getName()) && changetable.getName() != null) {
					// 2.拼接sql
					sql.append(" and name like '%" + changetable.getName() + "%' ");

				}
			}
			List<Changetable> list = null;
			try {

				list = quer.query(sql.toString(), new BeanListHandler<Changetable>(Changetable.class));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return list;
		}
		
		
		
		
	public Changetable findChangetableById(Changetable changetable) {
		String sql = "select * from changetable where employee_id = ? ";
		// 2 参数传值
		Object params[] = { changetable.getEmployee_id() };

		Changetable changetables = null;
		try {
			changetables = queryRunner.query(sql, new BeanHandler<Changetable>(Changetable.class), params);

			System.out.println("changetables--->" + changetables);
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

		return changetables;
	}

	
	// 带分页查询
	public List<Changetable> queryAllChangetable(PageBean pageBean, Changetable changetable) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM changetable where 1=1");

		// 1 保证对象不为null,分配了内存空间
		if(changetable!=null){
		  //2 判断哪些字段有模糊查询
			// name,age做一下模糊查询
			//保证name有值
			if(!"".equals(changetable.getName()) && changetable.getName()!=null){
				
				//拼接sql
				sql.append(" and name like '%"+changetable.getName()+"%'");
				
			}
			
			
		}

		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}

		List<Changetable> listU = null;

		System.out.println("sql-->" + sql.toString());

		try {
			listU = queryRunner.query(sql.toString(), new BeanListHandler<Changetable>(Changetable.class));

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

	
   //总记录数
	public int ChangetableCount(Changetable changetable) {
		QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		StringBuffer sb = new StringBuffer("select count(*) from changetable ");
		// 有条件判断条件，重新拼接sql
	if(changetable!=null){
		//判定账户名的文本框的合法性
		// "" null判定
		
		if(!"".equals(changetable.getName()) && changetable.getName()!=null) {
			sb .append(" and name like '%"+changetable.getName()+"%'");
			
		}
	}
		long num;
		try {
			num =queryRunner.query(sb.toString(), new ScalarHandler<>());

			return (int)num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
			  return 0;
			//throw new RuntimeException("查询数据失败!");
		}
	}
	 //删除单个
		public boolean del(Changetable changetable) {
			// QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
			// 编写sql语句
			String sql = "delete from changetable where employee_id=?";
			System.out.println(sql);
			Object[] parame = { changetable.getEmployee_id() };
			try {
				int i = queryRunner.update(sql, parame);
				return i > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("删除失败!!");
			}

		}
		
		//删除多个
		public int ChangetableDelete(String delIds) {
			System.out.println(delIds);
			String sql = "delete from  changetable where employee_id in (" + delIds + ")";
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

		public Changetable select(Changetable changetable) {
			QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
			// 编写sql语句
			String sql = "SELECT * FROM changetable WHERE employee_id=?";
			System.out.println(sql);
			Object[] parame = { changetable.getEmployee_id() };
			Changetable list = null;
			try {

				list = quer.query(sql, new BeanHandler<Changetable>(Changetable.class), parame);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return list;
		}
}
