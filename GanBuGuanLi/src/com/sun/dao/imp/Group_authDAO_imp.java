package com.sun.dao.imp;

import com.cadre.bean.Cadre;
import com.jdbcutils.JdbcUtils;
import com.sun.bean.Auth;
import com.sun.bean.Group_auth;
import com.sun.dao.Igroup_authDAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Group_authDAO_imp implements Igroup_authDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	String outString;
	@Override
	public void addGroupAuth(Group_auth groupauth) {
		String sql="insert into group_auth (group_name,father_id) values (?,?)";
		Object[] params= {groupauth.getGroup_name(),groupauth.getFather_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0) {
				outString="ִ����"+groupauth.getGroup_name()+"����Ӳ���";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���Ȩ����ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateGroupAuth(Group_auth groupauth) {
		String sql="update group_auth set group_name=?,father_id=? where group_id=?";
		Object[] params={groupauth.getGroup_name(),groupauth.getFather_id(),groupauth.getGroup_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="ִ����"+groupauth.getGroup_name()+"�ĸ��²���";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Ȩ�������ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delGroupAuth(Group_auth groupauth) {
		String sql="delete from group_auth where group_id=?";
		Object[] params={groupauth.getGroup_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="ִ����"+groupauth.getGroup_name()+"��ɾ������";
				System.out.println(outString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Ȩ����ɾ��ʧ��!!");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Group_auth> queryAllGroup(Group_auth groupauth) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from group_auth where 1=1 ");
		if(groupauth!=null){
			if(!"".equals(groupauth.getFather_id())){
				sql.append("and group_au_id like '%"+groupauth.getFather_id()+"%'");
			}
		}
		List<Group_auth> group_authList=null;
		try {
			group_authList=queryRunner.query(sql.toString(),new BeanListHandler<>(Group_auth.class));
			if(group_authList!=null){
				System.out.println("��ѯȫ��Ȩ����ɹ�����");
			}
			else {
				System.out.println("��ѯȫ��Ȩ����ʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯȫ��Ȩ����ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return group_authList;
	}

	@Override
	public List<Group_auth> queryAllGroup(Cadre cadre) {
		String sql="select * from group_auth where group_id in (select group_au_id from auth where auth_id in (select auth_id from auth_group where group_id in (select group_id from group_admin where group_name in (select group_name from admin_group where admin_id in (select admin_id from cadre where employee_id=?)))))";
		Object[] params={cadre.getEmployee_id()};
		List<Group_auth> group_authList=null;
		try {
			group_authList=queryRunner.query(sql,new BeanListHandler<>(Group_auth.class),params);
			if(group_authList!=null){
				System.out.println("����Ա����ѯȨ����ɹ�����");
			}
			else {
				System.out.println("����Ա����ѯȨ����ʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����Ա����ѯȨ����ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return group_authList;
	}

	@Override
	public Group_auth findGroupByID(Group_auth groupauth) {
		String sql="select * from group_auth where group_id=?";
		Object[] params={groupauth.getGroup_id()};
		Group_auth group_auth=null;
		try {
			group_auth=queryRunner.query(sql,new BeanHandler<>(Group_auth.class),params);
			if(group_auth!=null){
				System.out.println("��ѯ����Ȩ����ɹ�����");
			}
			else {
				System.out.println("��ѯ����Ȩ����ʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����Ȩ����ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return group_auth;
	}

	@Override
	public List<Auth> findAuths(Group_auth group_auth) {
		String sql="select * from auth where group_au_id=? and viewmode=1";
		Object[] pararms={group_auth.getGroup_id()};
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql,new BeanListHandler<>(Auth.class),pararms);
			if(authList!=null){
				System.out.println("��ѯ��ӦȨ�޳ɹ�����");
			}
			else {
				System.out.println("��ѯ��ӦȨ��ʧ�ܣ���");
			}
			// for (Auth au:authList) {
			// 	if(!"".equals(iauthDAO.viewmode(au))&&(Integer.parseInt(iauthDAO.viewmode(au))==1)){
			// 		authList1.add(au);
			// 	}
			// }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��ӦȨ��ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

}
