package com.sun.dao.imp;

import com.jdbcutils.JdbcUtils;
import com.sun.bean.Admin;
import com.sun.bean.Daily_record;
import com.sun.dao.Idaily_recordDAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Daily_recordDAO_imp implements Idaily_recordDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	@Override
	public void addDaily(Daily_record daily_record) {

		String sql="insert into daily_record (admin_id,upd_time,things) values (?,?,?)";
		Object[] params= {daily_record.getAdmin_id(),daily_record.getUpd_time(),daily_record.getThings()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0) {
				System.out.println("�����־�ɹ�����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�����־ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// @Override
	// public void updateDaily(Daily_record daily_record) {
	// 	String sql="update daily_record set admin_id=?,upd_time=?,things=? where upd_time like %?%";           //ģ����ѯ������
	// 	Object[] params={daily_record.getAdmin_id(),daily_record.getUpd_time(),daily_record.getThings()};
	// 	try {
	// 		int result=queryRunner.update(sql,params);
	// 		if(result>0){
	// 			System.out.println("��־���³ɹ�����");
	// 		}
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 		throw new RuntimeException("��־����ʧ�ܣ���");
	// 	}finally {
	// 		try {
	// 			JdbcUtils.getDataSource().getConnection().close();
	// 		} catch (SQLException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// }
	//
	// @Override
	// public void delDaily(Daily_record daily_record) {
	// 	String sql="delete from daily_record where dailyId=?";
	// 	Object[] params={daily_record.getDailyId()};
	// 	try {
	// 		int result=queryRunner.update(sql,params);
	// 		if(result>0){
	// 			System.out.println("��־ɾ���ɹ�����");
	// 		}
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 		throw new RuntimeException("��־ɾ��ʧ��!!");
	// 	}finally {
	// 		try {
	// 			JdbcUtils.getDataSource().getConnection().close();
	// 		} catch (SQLException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// }

	@Override
	public List<Daily_record> queryAllDaily(Daily_record daily_record) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from daily_record where 1=1 ");
		if(daily_record!=null){
			if(!"".equals(daily_record.getDailyId())){
				sql.append("and admin_position like '%"+daily_record.getDailyId()+"%'");
			}
		}

		List<Daily_record> daily_recordList=null;
		try {
			daily_recordList=queryRunner.query(sql.toString(),new BeanListHandler<>(Daily_record.class));
			if(daily_recordList!=null){
				System.out.println("������־��ѯ�ɹ�����");
			}
			else {
				System.out.println("������־��ѯʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("������־��ѯʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return daily_recordList;
	}

	@Override
	public Daily_record findDailyByID(Daily_record daily_record) {
		String sql="select * from daily_record where dailyId=?";
		Object[] parms={daily_record.getDailyId()};
		Daily_record daily_record1=null;
		try {
			daily_record1=queryRunner.query(sql,new BeanHandler<>(Daily_record.class),parms);
			if(daily_record1!=null){
				System.out.println("���ҵ���ְλ�ɹ�����");
			}
			else {
				System.out.println("���ҵ���ְλʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ҵ���ְλʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return daily_record1;
	}
}
