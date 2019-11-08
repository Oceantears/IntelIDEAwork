/**
 * <һ�仰���ܼ���>
 * <�������ݿ�sql>
 *
 * @author sunmeng
 * @create 2019/10/30   0:08
 */
package com.it.dao;

import com.it.bean.Students;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentsDAOImpl implements IStudentsDAO {
	QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());

	//�������
	@Override
	public void addStudent(Students students) {
		//1.��дsql
		String sql="insert into homework1(NAME,Addr,Zip,Tel,Email,Depno,Birth,Sex) values(?,?,?,?,?,?,?,?)";

		//String sql="insert into homework1(NAME,Addr,Zip,Tel,Email,Depno,Birth,Sex) values('��־ǿ','����',123456,12345678,null,'1','1987-06-12','��')";
		//2.������ֵ
		Object[] parms={students.getName(),students.getAddr(),students.getZip(),students.getTel(),students.getEmail(),students.getDepno(),students.getBirth(),students.getSex()};



		//3.ִ��
		//System.out.println("students-->"+students);
		//System.out.println("students-->"+students.getDepno());
		try {
			int result=queryRunner.update(sql,parms);

			if(result>0){
				System.out.println("=============��ӳɹ�=============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ���Ӳ���ʧ��!!");
		}finally {
			try {
				//�Ͽ�����
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//ɾ������
	@Override
	public void delStudent(Students students) {
		String sql="delete from homework1 where Num=?";
		Object[] parms={students.getNum()};
		try {
			int result=queryRunner.update(sql,parms);
			if(result>0){
				System.out.println("=============ɾ���ɹ�==============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ�ɾ������ʧ�ܣ���");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//�޸Ĳ���
	@Override
	public void updateStudent(Students students) {
		String sql="update homework1 set NAME=?,Addr=?,Zip=?,Tel=?,Email=?,Depno=?,Birth=?,Sex=?";
		Object[] parms={students.getName(),students.getAddr(),students.getZip(),students.getTel(),students.getEmail(),students.getDepno(),students.getBirth(),students.getSex()};

		try {
			int result=queryRunner.update(sql,parms);
			if(result>0){
				System.out.println("===========�޸Ĳ����ɹ�================>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ��޸����ݲ���ʧ�ܣ���");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//����������ѯ
	@Override
	public Students findStudentById(Students students) {
		String sql="select * from homework1 where Num=?";
		Object[] parms={students.getNum()};
		Students student=null;
		try {
			student=queryRunner.query(sql,new BeanHandler<Students>(Students.class),parms);
			System.out.println("===========��ѯ�ɹ�======��Ҫ�ҵ�ѧ��======>"+student);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ��ѯ����ʧ�ܣ���");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return student;
	}
	//�����ѯ
	@Override
	public List<Students> queryAllStudent(Students students) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from homework1 where 1=1 ");                 //1=1����Ҫ�ӿո�
		//1 ��֤����Ϊnull,�������ڴ�ռ�
		if(students!=null){
			//2 �ж���Щ�ֶ���ģ����ѯ
			// name,age��һ��ģ����ѯ
			//��֤name��ֵ
			if(!"".equals(students.getName())&&students.getName()!=null){
				sql.append("and NAME like '%"+students.getName()+"%'");
			}
			//��֤Tel��ֵ
			if(new Integer(students.getTel())!=0){
				sql.append("and Tel like '%"+students.getTel()+"%'");
			}
		}
		List<Students> stuList=null;

		//System.out.println("sql=========>"+sql.toString());

		try {
			stuList=queryRunner.query(sql.toString(),new BeanListHandler<Students>(Students.class));
			System.out.println("==============ģ����ѯ�ɹ�===========>"+stuList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ��ѯ����ʧ�ܣ���");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stuList;
	}

	/*
	�绰��Ϊ����            ��������ݿ����ҵ���Ӧ�Ķ�Ӧ���ݣ��͵�¼�ɹ�
	 */
	@Override
	public boolean logIn(Students students) {
		String sql="select * from homework1 where NAME=? and Tel=?";
		Object[] params={students.getName(),students.getTel()};

		Students stu=null;
		try {
			stu=queryRunner.query(sql,new BeanHandler<Students>(Students.class),params);
			if(stu!=null){
				System.out.println("============stu================>"+stu);
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��¼ʧ�ܣ���");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
