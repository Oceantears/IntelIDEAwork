/**
 * <һ�仰���ܼ���>
 * <�û�DAO��ʵ����>
 *
 * @author sunmeng
 * @create 2019/11/11   17:42
 */
package com.it.dao.users;

import com.it.bean.UserInfo;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
	QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDatasource());
	// ��
	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		// 1 ��дsql
		String sql = "insert into userinfo(user_name,user_pwd,user_addr,user_addr,user_tel,user_sex)values(?,?,?,?,?,?)";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		// 3 �������
		Object params[] = { userInfo.getUser_name(),userInfo.getUser_pwd(),userInfo.getUser_addr(),userInfo.getUser_tel(),userInfo.getUser_sex()};
		// �����־λ

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("���ʧ��!!");
		} finally {
			// �ͷ���Դ�����ݿ����ӳ�
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
	}

	// ɾ
	@Override
	public boolean delUserInfo(UserInfo userInfo) {
		// 1 ��дsql
		String sql = "delete from userinfo where user_id=?";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		// 3 �������
		Object params[] = {userInfo.getUser_id()};
		// �����־λ

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("ɾ��ʧ��!!");
		} finally {
			// �ͷ���Դ�����ݿ����ӳ�
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}

	}

	// ��
	@Override
	public boolean updUserInfo(UserInfo userInfo) {
		// 1 ��дsql
		String sql = "update userinfo set user_name =? where user_id=?";
		// 2 ��ӡsql
		System.out.println("sql-->" + sql);
		System.out.println(userInfo);
		// 3 �������
		Object params[] = { userInfo.getUser_name(),userInfo.getUser_id() };
		// �����־λ

		try {
			int rows = queryRunner.update(sql, params);
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();

			throw new RuntimeException("�޸�ʧ��!!");
		} finally {
			// �ͷ���Դ�����ݿ����ӳ�
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
	}

	// ��
	@Override
	public List<UserInfo> queryAllUserInfo(UserInfo userInfo) {
		//��дsql
		String sql = "select * from userinfo where 1=1 ";
		if(userInfo!=null){
			//�ж��˻������ı���ĺϷ���
			// "" null�ж�
			if(!"".equals(userInfo.getUser_name()) && userInfo.getUser_name()!=null) {

				//ƴ��sql
				sql+="and user_name like '%"+userInfo.getUser_name()+"%' ";

			}

			/*if(!"".equals(new Integer(UserInfo.getUser_age())) && UserInfo.getUser_age()!=0) {
				sql+=" and user_age like '%"+UserInfo.getUser_age()+"%'";

			}*/
		}

		System.out.println("sql-->"+sql);
		//�������UserInfo��Ϣ
		List<UserInfo> listU = null;
		try {
			listU = queryRunner.query(sql, new BeanListHandler<>(UserInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		return listU;
	}

	// ��ѯ����
	@Override
	public UserInfo findUserInfoById(UserInfo userInfo) {
		//��дsql
		String sql = "select * from userinfo where user_id=?";
		//2 ��ӡsql
		System.out.println("sql-->"+sql);
		//3 �������
		Object params[] = {userInfo.getUser_id()};

		UserInfo userInfo1 = null;
		try {
			userInfo1 =  queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}
		return userInfo1;
	}
	/**
	 * ����û���˻���������
	 * ����������id���������
	 * @param userInfo* @return
	 */
	@Override
	public UserInfo login(UserInfo userInfo) {
		//��дsql
		String sql = "select * from userinfo where user_name=? and user_pwd=?";
		//2 ��ӡsql
		System.out.println("sql-->"+sql);
		//3 �������
		Object params[] = {userInfo.getUser_name(),userInfo.getUser_pwd()};

		UserInfo userInfo1 = null;
		try {
			userInfo1 =  queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), params);
			if(userInfo1!=null){
				return userInfo1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������ʧ��!");
		}
		finally {
			//�ͷ���Դ�����ݿ����ӳ�
			try {
				// DbUtils.close(JDBCUtils.getConnections());
				JDBCUtils.getDatasource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر���Դʧ��!");
			}
		}

		return null;
	}
}
