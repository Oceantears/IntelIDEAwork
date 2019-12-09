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
		// 1 ��дsql
		String sql = "insert into changetable(employee_id,work_exper,name,reserveposition)values(?,?,?,?)";
		// 2 ������ֵ
		Object params[] = {changetable.getEmployee_id(),changetable.getWork_exper(),changetable.getName(),changetable.getReserveposition()};
		// 3 ִ��

		try {
			int rs = queryRunner.update(sql, params);
			System.out.println("rs----->"+rs);
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
		public boolean add(Changetable changetable) {

			// ��дsql���
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
				throw new RuntimeException("���ʧ��!!");
			}

		}

		//��
		public boolean updateb(Changetable changetable) {
			QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
			// ��дsql���
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
				throw new RuntimeException("�޸�ʧ��!!");
			}

		}
		
		// ģ����
		public List<Changetable> mohu(Changetable changetable) {

			QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
			// ��дsql���
			StringBuffer sql = new StringBuffer();

			sql.append("select * from changetable where 1=1");

			// �ж�name��Ϊ��
			if (changetable.getName() != null) {
				if (!" ".equals(changetable.getName()) && changetable.getName() != null) {
					// 2.ƴ��sql
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
		// 2 ������ֵ
		Object params[] = { changetable.getEmployee_id() };

		Changetable changetables = null;
		try {
			changetables = queryRunner.query(sql, new BeanHandler<Changetable>(Changetable.class), params);

			System.out.println("changetables--->" + changetables);
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

		return changetables;
	}

	
	// ����ҳ��ѯ
	public List<Changetable> queryAllChangetable(PageBean pageBean, Changetable changetable) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM changetable where 1=1");

		// 1 ��֤����Ϊnull,�������ڴ�ռ�
		if(changetable!=null){
		  //2 �ж���Щ�ֶ���ģ����ѯ
			// name,age��һ��ģ����ѯ
			//��֤name��ֵ
			if(!"".equals(changetable.getName()) && changetable.getName()!=null){
				
				//ƴ��sql
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

	
   //�ܼ�¼��
	public int ChangetableCount(Changetable changetable) {
		QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
		StringBuffer sb = new StringBuffer("select count(*) from changetable ");
		// �������ж�����������ƴ��sql
	if(changetable!=null){
		//�ж��˻������ı���ĺϷ���
		// "" null�ж�
		
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
			//throw new RuntimeException("��ѯ����ʧ��!");
		}
	}
	 //ɾ������
		public boolean del(Changetable changetable) {
			// QueryRunner quer=new QueryRunner(JdbcUtils.getDataSource());
			// ��дsql���
			String sql = "delete from changetable where employee_id=?";
			System.out.println(sql);
			Object[] parame = { changetable.getEmployee_id() };
			try {
				int i = queryRunner.update(sql, parame);
				return i > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("ɾ��ʧ��!!");
			}

		}
		
		//ɾ�����
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
		
		// �鵥��

		public Changetable select(Changetable changetable) {
			QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
			// ��дsql���
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
