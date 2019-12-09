package com.gyq.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gyq.bean.PageBean;
import com.gyq.bean.keshi;
import com.jdbcutils.JdbcUtils;

public class Keshidaoimpl implements IKeshidao {

	QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());

//添加科室
	public boolean add(keshi ks) {
		String sql = "INSERT INTO keshi (ks_name,ks_prin,ks_desc) VALUES (?,?,?)";
		System.out.println(sql);
		Object[] parame = { ks.getKs_name(), ks.getKs_prin(), ks.getKs_desc() };

		try {
			int i = quer.update(sql, parame);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加失败!!");
		}
	}

//删除科室
	public boolean del(keshi ks) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		String sql = "DELETE FROM keshi WHERE ks_no = ?";
		System.out.println(sql);
		Object[] parame = { ks.getKs_no() };
		try {
			int i = quer.update(sql, parame);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除失败!!");
		}
	}
//查询单条
		public keshi select(keshi ks) {
			String sql = "SELECT * FROM keshi WHERE ks_no = ?";
			System.out.println(sql);
			Object[] parame = { ks.getKs_no() };
			keshi list = null;
			try {

				list = quer.query(sql, new BeanHandler<keshi>(keshi.class), parame);

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return list;
		}
//修改科室	
	public boolean update(keshi ks) {
		String sql = "UPDATE keshi SET ks_name = ?,ks_prin = ?,ks_desc = ? WHERE ks_no = ?";
		System.out.println(sql);
		Object[] parame = { ks.getKs_name(), ks.getKs_prin(), ks.getKs_desc(), ks.getKs_no() };
		try {
			int in = quer.update(sql, parame);
			return in > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改失败!!");
		}
	}

//查询全部科室
	public List<keshi> selectall() {
		String sql = "SELECT * FROM keshi";
		System.out.println(sql);
		List<keshi> list = null;
		try {
			list = quer.query(sql, new BeanListHandler<keshi>(keshi.class));

			System.out.println("dao-->" + list.size());
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}



	public List<keshi> mohu(keshi ks) {
		// TODO Auto-generated method stub
		return null;
	}

//带分页的查询全部	
	public List<keshi> queryAllKs(PageBean pageBean, keshi keshi) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// 编写sql语句
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM keshi WHERE 1=1");

		if (keshi.getKs_no() != 0) {
			// 2.拼接sql
			sql.append(" and ks_no like '%" + keshi.getKs_no() + "%' ");

		}
		if (!" ".equals(keshi.getKs_name()) && keshi.getKs_name() != null) {
			// 2.拼接sql
			sql.append(" and ks_name like '%" + keshi.getKs_name() + "%' ");

		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getRows());
		}
		
		System.out.println("sql-->"+sql);
		//存放所有Users信息
		List<keshi> listU = null;
		try {
			
			listU = quer.query(sql.toString(), new BeanListHandler<>(keshi.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
		
		return listU;
	}

//删除多条记录
	public int KsDelete(String delksId) {
		System.out.println(delksId);
		String sql = "DELETE FROM keshi WHERE ks_no in (" + delksId + ")";
		System.out.println("delksid--->" + delksId);
		System.out.println("sql--->" + sql);
		try {
			return quer.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

//查询总记录数
	public int KsCount(keshi keshi) {
		StringBuffer sb = new StringBuffer("select count(*) from keshi where 1=1 ");
		// 有条件判断条件，重新拼接sql
		if (keshi != null) {
			// 判定账户名的文本框的合法性

			if (keshi.getKs_no() != 0) {
				sb.append(" and ks_no like '%" + keshi.getKs_no() + "%'");

			}
		}
		Number num;
		try {
			num = (Number) quer.query(sb.toString(), new ScalarHandler<>());

			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}
	}

	

}
