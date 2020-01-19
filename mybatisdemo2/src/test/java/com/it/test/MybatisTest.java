/**
 * <一句话功能简述>
 * <p>
 * mybatis测试类
 *
 * 黑马视频mybatis第一个简单测试
 * 在pom.xml文件中的dependency引入了mybatis包
 *
 * @author sunmeng
 * @create 2020/1/6   15:05
 */
package com.it.test;


import com.it.dao.IStudentDAO;
import com.it.mapper.Student;
import com.it.mybatis.io.Resources;
import com.it.mybatis.sqlSession.SqlSession;
import com.it.mybatis.sqlSession.SqlSessionFactory;
import com.it.mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
	public static void main(String[] args) throws IOException {
		//1.读取配置文件
		InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
		//2.创建SqlSessionFactory工厂
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(in);
		//3.使用工厂生产SqlSession对象
		SqlSession sqlSession=factory.openSession();
		//4.使用SqlSession创建DAO接口的代理对象
		IStudentDAO studentDAO=sqlSession.getMapper(IStudentDAO.class);
		//5.使用代理对象执行方法
		List<Student> students=studentDAO.queryAll();
		for (Student student:students) {
			System.out.println(student);
		}
		//6.释放资源
		sqlSession.close();
		in.close();
	}
}
