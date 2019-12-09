package com.sun.dao.imp;

import com.cadre.bean.Cadre;
import com.jdbcutils.JdbcUtils;
import com.sun.bean.Admin;
import com.sun.bean.Auth;
import com.sun.dao.IauthDAO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AuthDAO_imp implements IauthDAO {
	QueryRunner queryRunner=new QueryRunner(JdbcUtils.getDataSource());
	String outString;
	@Override
	public void addAuth(Auth auth) {
		String sql="insert into auth (auth_name,auth_icon,group_au_id,action,viewmode) values (?,?,?,?,?)";
		Object[] params= {auth.getAuth_name(),auth.getAuth_icon(),auth.getGroup_au_id(),auth.getAction(),auth.getViewmode()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0) {
				outString="ִ����"+auth.getAuth_name()+"����Ӳ���";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���Ȩ��ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateAuth(Auth auth) {
		String sql="update auth set auth_name=?,auth_icon=?,group_au_id=?,action=?,viewmode=? where auth_id=?";
		Object[] params={auth.getAuth_name(),auth.getAuth_icon(),auth.getGroup_au_id(),auth.getAction(),auth.getViewmode(),auth.getAuth_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="ִ����"+auth.getAuth_name()+"�ĸ��²���";
				System.out.println(outString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����Ȩ��ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delAuth(Auth auth) {
		String sql="delete from auth where auth_id=?";
		Object[] params={auth.getAuth_id()};
		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				outString="ִ����"+auth.getAuth_name()+"��ɾ������";
				System.out.println(outString);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��Ȩ��ʧ��!!");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Auth> queryAllAuth(Auth auth) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from auth where 1=1 ");
		if(auth!=null){
			if(!"".equals(auth.getGroup_au_id())){
				sql.append("and group_au_id like '%"+auth.getGroup_au_id()+"%'");
			}
			if(!"".equals(auth.getViewmode())){
				sql.append("and viewmode like '%"+auth.getViewmode()+"%'");
			}
		}
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql.toString(),new BeanListHandler<>(Auth.class));
			if(authList!=null){
				System.out.println("��ѯ��Ȩ�޳ɹ�����");
			}
			else {
				System.out.println("��ѯ��Ȩ��ʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ȩ��ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

	@Override
	public Auth findAuthByID(Auth auth) {
		String sql="select * from auth where auth_id=?";
		Object[] parms={auth.getAuth_id()};
		Auth auth1=null;
		try {
			auth1=queryRunner.query(sql,new BeanHandler<>(Auth.class),parms);
			if(auth1!=null){
				System.out.println("���ҵ���Ȩ�޳ɹ�����");
			}
			else {
				System.out.println("���ҵ���Ȩ��ʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ҵ���Ȩ��ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return auth1;
	}

	@Override
	public List<Auth> queryAllAuth(Admin admin) {
		String sql="select * from auth where auth_id in (select auth_id from auth_group where group_id in (select group_id from admin_group where admin_id in (select admin_id from admin where admin_position=?)))";
		Object[] params={admin.getAdmin_position()};
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql,new BeanListHandler<>(Auth.class),params);
			if(authList!=null){
				System.out.println("����ְλ��ѯȨ�޳ɹ�����");
			}
			else {
				System.out.println("����ְλ��ѯȨ��ʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ְλ��ѯȨ��ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

	@Override
	public List<Auth> queryAllAuth(Cadre cadre) {
		String sql="select * from auth where auth_id in (select auth_id from auth_group where group_id in (select group_id from admin_group where admin_id in (select admin_id from cadre where employee_id=?)))";
		Object[] params={cadre.getEmployee_id()};
		List<Auth> authList=null;
		try {
			authList=queryRunner.query(sql,new BeanListHandler<>(Auth.class),params);
			if(authList!=null){
				System.out.println("����ְλ��ѯȨ�޳ɹ�����");
			}
			else {
				System.out.println("����ְλ��ѯȨ��ʧ�ܣ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ְλ��ѯȨ��ʧ�ܣ���");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return authList;
	}

	@Override
	public String viewmode(Auth auth) {
		String sql="select viewmode from auth where auth_id=?";
		Object[] params={auth.getAuth_id()};
		String viewmode1=null;
		try {
			viewmode1=queryRunner.query(sql,new BeanHandler<>(String.class),params);
			if(viewmode1!=null){
				System.out.println("Ȩ�޿ɼ�����");
			}
			else {
				System.out.println("Ȩ�޲��ɼ�����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Ȩ�޲��ɼ�����");
		}finally {
			try {
				JdbcUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return viewmode1;
	}

	// @Override
	// public int findAuthFather(Auth auth) {
	// 	String sql="select group_au_id from auth where auth_id=?";
	// 	Object[] params={auth.getAuth_id()};
	// 	int authFatherID=-1;
	// 	try {
	// 		authFatherID=queryRunner.query(sql,new BeanHandler<>(Integer.class),params);
	// 		if(authFatherID>=0){
	// 			System.out.println("Ȩ�޸��ڵ���ҳɹ�����");
	// 		}
	// 		else {
	// 			System.out.println("Ȩ�޸��ڵ����ʧ�ܣ���");
	// 		}
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 		throw new RuntimeException("Ȩ�޸��ڵ����ʧ�ܣ���");
	// 	}finally {
	// 		try {
	// 			JdbcUtils.getDataSource().getConnection().close();
	// 		} catch (SQLException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	return authFatherID;
	// }
}
