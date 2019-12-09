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

//��ӿ���
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
			throw new RuntimeException("���ʧ��!!");
		}
	}

//ɾ������
	public boolean del(keshi ks) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
		String sql = "DELETE FROM keshi WHERE ks_no = ?";
		System.out.println(sql);
		Object[] parame = { ks.getKs_no() };
		try {
			int i = quer.update(sql, parame);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��!!");
		}
	}
//��ѯ����
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
//�޸Ŀ���	
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
			throw new RuntimeException("�޸�ʧ��!!");
		}
	}

//��ѯȫ������
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

//����ҳ�Ĳ�ѯȫ��	
	public List<keshi> queryAllKs(PageBean pageBean, keshi keshi) {
		QueryRunner quer = new QueryRunner(JdbcUtils.getDataSource());
		// ��дsql���
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM keshi WHERE 1=1");

		if (keshi.getKs_no() != 0) {
			// 2.ƴ��sql
			sql.append(" and ks_no like '%" + keshi.getKs_no() + "%' ");

		}
		if (!" ".equals(keshi.getKs_name()) && keshi.getKs_name() != null) {
			// 2.ƴ��sql
			sql.append(" and ks_name like '%" + keshi.getKs_name() + "%' ");

		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getRows());
		}
		
		System.out.println("sql-->"+sql);
		//�������Users��Ϣ
		List<keshi> listU = null;
		try {
			
			listU = quer.query(sql.toString(), new BeanListHandler<>(keshi.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��!");
		}
		
		return listU;
	}

//ɾ��������¼
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

//��ѯ�ܼ�¼��
	public int KsCount(keshi keshi) {
		StringBuffer sb = new StringBuffer("select count(*) from keshi where 1=1 ");
		// �������ж�����������ƴ��sql
		if (keshi != null) {
			// �ж��˻������ı���ĺϷ���

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
			throw new RuntimeException("��ѯ����ʧ��!");
		}
	}

	

}
