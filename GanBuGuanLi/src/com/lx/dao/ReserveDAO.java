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

	// ��
	public void addReserve(Reserve reserve) {
		// 1 ��дsql
		String sql = "insert into reservecadre(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		// 2 ������ֵ
		Object params[] = { reserve.getEmployee_id(), reserve.getWork_exper(), reserve.getName(),
				reserve.getReserveposition() };
		// 3 ִ��
		System.out.println("sql-->" + sql);
		try {
			int rs = queryRunner.update(sql, params);
			System.out.println(rs);
			if (rs > 0) {
				System.out.println("-----��ӳɹ�-------rs-->" + rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("���ݿ���Ӳ���ʧ��!!");
		} finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ��
	public boolean add(Reserve reserve) {

		// ��дsql���
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
			throw new RuntimeException("���ʧ��!!");
		}

	}

	// �޸�
	public boolean updateb(Reserve reserve) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
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
			throw new RuntimeException("�޸�ʧ��!!");
		}

	}

	// ģ����
	public List<Reserve> mohu(Reserve reserve) {

		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
		StringBuffer sql = new StringBuffer();

		sql.append("select * from reservecadre where 1=1");

		// �ж�name��Ϊ��
		if (reserve.getName() != null) {
			if (!" ".equals(reserve.getName()) && reserve.getName() != null) {
				// 2.ƴ��sql
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

	// ��ѯ����
	public Reserve findReserveById(Reserve reserve) {
		String sql = "select * from reservecadre where employee_id = ? ";
		// 2 ������ֵ
		Object params[] = { reserve.getEmployee_id() };

		Reserve reserves = null;
		try {
			reserves = queryRunner.query(sql, new BeanHandler<Reserve>(Reserve.class), params);

			System.out.println("reserves--->" + reserves);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("���ݿ��ѯ��������ʧ��!!");
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

	// ����ҳ��ѯ
	public List<Reserve> queryAllReserve(PageBean pageBean, Reserve reserve) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM reservecadre where 1=1");

		// 1 ��֤����Ϊnull,�������ڴ�ռ�
		if (reserve != null) {
			// 2 �ж���Щ�ֶ���ģ����ѯ
			// name,age��һ��ģ����ѯ
			// ��֤name��ֵ
			if (!"".equals(reserve.getName()) && reserve.getName() != null) {

				// ƴ��sql
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
			throw new RuntimeException("���ݿ��ѯ����ʧ��!!");
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

	// ɾ������
	public boolean del(Reserve reserve) {
		// QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
		String sql = "delete from reservecadre where employee_id=?";
		System.out.println(sql);
		Object[] parame = { reserve.getEmployee_id() };
		try {
			int i = queryRunner.update(sql, parame);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��!!");
		}

	}

// �ܼ�¼��
	public int ReserveCount(Reserve reserve) {
		QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		StringBuffer sb = new StringBuffer("select count(*) from reservecadre ");
		// �������ж�����������ƴ��sql
		if (reserve != null) {
			// �ж��˻������ı���ĺϷ���
			// "" null�ж�

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
			//throw new RuntimeException("��ѯ����ʧ��!");
		}
	}

	// ɾ�����
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
	// �鵥��

	public Reserve select(Reserve reserve) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
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
