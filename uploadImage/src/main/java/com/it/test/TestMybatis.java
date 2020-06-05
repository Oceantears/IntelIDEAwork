/**
 * <一句话功能简述>
 * <p>
 * mybatis连接测试
 *
 * @author sunmeng
 * @create 2020/5/29   15:34
 */
package com.it.test;

import com.it.dao.IStuDao;
import com.it.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
	@Test
	public void run1() throws IOException {
		Student student = new Student();
		student.setsNo(null);
		student.setsName("李翔");
		student.setsSex(1);
		student.setsBirthday("2015-10-05");
		student.setsClasses(1);
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession对象
		SqlSession sqlSession = factory.openSession();
		// 获取到代理对象
		IStuDao dao = sqlSession.getMapper(IStuDao.class);

		int i = dao.insertStu(student);

		System.out.println("=============插入数据=========》"+i);
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
		in.close();

	}
	@Test
	public void run2() throws IOException {
		Student student = new Student();

		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = factory.openSession();
		IStuDao dao = sqlSession.getMapper(IStuDao.class);
		List<Student> list = dao.querryAllStu(student);
		for (Student s:list) {
			System.out.println(s);
		}
		sqlSession.close();
		in.close();

	}
}
