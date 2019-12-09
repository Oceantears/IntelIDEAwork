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
		// 1 ��дsql
		String sql = "insert into suggest(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		// 2 ������ֵ
		Object params[] = { suggest.getEmployee_id(), suggest.getWork_exper(), suggest.getName(),
				suggest.getReserveposition() };
		// 3 ִ��

		try {
			int rs = queryRunner.update(sql, params);
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
	public boolean add(Suggest suggest) {

		// ��дsql���
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
			throw new RuntimeException("���ʧ��!!");
		}

	}

	public boolean updateb(Suggest suggest) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
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
			throw new RuntimeException("�޸�ʧ��!!");
		}

	}

	// ģ����
	public List<Suggest> mohu(Suggest suggest) {

		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
		StringBuffer sql = new StringBuffer();

		sql.append("select * from suggest where 1=1");

		// �ж�name��Ϊ��
		if (suggest.getName() != null) {
			if (!" ".equals(suggest.getName()) && suggest.getName() != null) {
				// 2.ƴ��sql
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
		// 2 ������ֵ
		Object params[] = { suggest.getEmployee_id() };

		Suggest suggests = null;
		try {
			suggests = queryRunner.query(sql, new BeanHandler<Suggest>(Suggest.class), params);

			System.out.println("suggests--->" + suggests);
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

		return suggests;
	}

	// ����ҳ�Ĳ�ѯȫ��
	public List<Suggest> queryAllSuggest(PageBean pageBean, Suggest suggest) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM suggest where 1=1 ");

		System.out.println("suggest--->"+suggest);
		// 1 ��֤����Ϊnull,�������ڴ�ռ�
		if (suggest!= null) {
			
		
			if (!"".equals(suggest.getName()) && suggest.getName() != null) {

				// ƴ��sql
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
	public boolean del(Suggest suggest) {
		 QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
		String sql = "delete from suggest where employee_id=?";
		System.out.println(sql);
		Object[] parame = { suggest.getEmployee_id() };
		try {
			int i = queryRunner.update(sql, parame);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��!!");
		}

	}

	// ɾ�����
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
		// �������ж�����������ƴ��sql
		if (suggest != null) {
			// 2 �ж���Щ�ֶ���ģ����ѯ
			// name,age��һ��ģ����ѯ
			// ��֤name��ֵ
			
			if (!"".equals(suggest.getName()) && suggest.getName() != null) {

				// ƴ��sql
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
			//throw new RuntimeException("��ѯ����ʧ��!");
			
		}

	}
	// �鵥��

	public Suggest select(Suggest suggest) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
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
