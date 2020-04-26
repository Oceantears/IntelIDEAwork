/**
 * <一句话功能简述>
 *
 * @author sunmeng
 * @create 2020/3/17   16:57
 */
package com.it.test;

import com.it.dao.IAdminDao;
import com.it.dao.IOrdersDao;
import com.it.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
	// @Test
	// public void run1() throws Exception{
	// 	// 加载配置文件
	// 	InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
	// 	// 创建SqlSessionFactory对象
	// 	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
	// 	// 创建SqlSession对象
	// 	SqlSession session = factory.openSession();
	// 	// 获取到代理对象
	// 	IAdminDao dao=session.getMapper(IAdminDao.class);
	// 	// Admin admin1 = dao.findByNameAndPassword("张三","123456");
	//
	// 	Admin admin=new Admin();
	// 	admin.setName("张三");
	//
	//
	// 	List<Admin> admin1= dao.findByNameAndPassword(admin);
	// 	System.out.println(admin1);
	// 	session.commit();
	// 	for (Admin ad:admin1) {
	// 		System.out.println(ad);
	// 	}
	// 	// 关闭资源
	// 	session.close();
	// 	in.close();
	// }

	@Test
	public void frontOrderTest() throws Exception{
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		IOrdersDao dao=session.getMapper(IOrdersDao.class);


		FrontEndOrders frontEndOrders1=new FrontEndOrders();
		// frontEndOrders1.setFarmers_name("王五");

		List<FrontEndOrders> frontEndOrders=dao.queryAllDetails(frontEndOrders1);

		for (FrontEndOrders f:frontEndOrders) {
			System.out.println(f);
		}


		session.close();
		in.close();
	}
}
