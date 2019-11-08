/**
 * <一句话功能简述>
 * <具体数据库sql>
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

	//添加数据
	@Override
	public void addStudent(Students students) {
		//1.编写sql
		String sql="insert into homework1(NAME,Addr,Zip,Tel,Email,Depno,Birth,Sex) values(?,?,?,?,?,?,?,?)";

		//String sql="insert into homework1(NAME,Addr,Zip,Tel,Email,Depno,Birth,Sex) values('田志强','国宴',123456,12345678,null,'1','1987-06-12','男')";
		//2.参数传值
		Object[] parms={students.getName(),students.getAddr(),students.getZip(),students.getTel(),students.getEmail(),students.getDepno(),students.getBirth(),students.getSex()};



		//3.执行
		//System.out.println("students-->"+students);
		//System.out.println("students-->"+students.getDepno());
		try {
			int result=queryRunner.update(sql,parms);

			if(result>0){
				System.out.println("=============添加成功=============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库添加操作失败!!");
		}finally {
			try {
				//断开连接
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//删除数据
	@Override
	public void delStudent(Students students) {
		String sql="delete from homework1 where Num=?";
		Object[] parms={students.getNum()};
		try {
			int result=queryRunner.update(sql,parms);
			if(result>0){
				System.out.println("=============删除成功==============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库删除操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//修改操作
	@Override
	public void updateStudent(Students students) {
		String sql="update homework1 set NAME=?,Addr=?,Zip=?,Tel=?,Email=?,Depno=?,Birth=?,Sex=?";
		Object[] parms={students.getName(),students.getAddr(),students.getZip(),students.getTel(),students.getEmail(),students.getDepno(),students.getBirth(),students.getSex()};

		try {
			int result=queryRunner.update(sql,parms);
			if(result>0){
				System.out.println("===========修改操作成功================>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库修改数据操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//单独条件查询
	@Override
	public Students findStudentById(Students students) {
		String sql="select * from homework1 where Num=?";
		Object[] parms={students.getNum()};
		Students student=null;
		try {
			student=queryRunner.query(sql,new BeanHandler<Students>(Students.class),parms);
			System.out.println("===========查询成功======你要找的学生======>"+student);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库查询操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return student;
	}
	//整体查询
	@Override
	public List<Students> queryAllStudent(Students students) {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from homework1 where 1=1 ");                 //1=1后需要加空格
		//1 保证对象不为null,分配了内存空间
		if(students!=null){
			//2 判断哪些字段有模糊查询
			// name,age做一下模糊查询
			//保证name有值
			if(!"".equals(students.getName())&&students.getName()!=null){
				sql.append("and NAME like '%"+students.getName()+"%'");
			}
			//保证Tel有值
			if(new Integer(students.getTel())!=0){
				sql.append("and Tel like '%"+students.getTel()+"%'");
			}
		}
		List<Students> stuList=null;

		//System.out.println("sql=========>"+sql.toString());

		try {
			stuList=queryRunner.query(sql.toString(),new BeanListHandler<Students>(Students.class));
			System.out.println("==============模糊查询成功===========>"+stuList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库查询操作失败！！");
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
	电话作为密码            如果在数据库中找到相应的对应数据，就登录成功
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
			throw new RuntimeException("登录失败！！");
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
