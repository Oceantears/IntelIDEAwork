/**
 * <一句话功能简述>
 * <p>
 * 测试spring配置
 *
 * @author sunmeng
 * @create 2020/5/29   10:05
 */
package com.it.test;

import com.it.domain.Student;
import com.it.service.IStuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	@Test
	public void run1(){
		ApplicationContext ap = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		IStuService istu =(IStuService) ap.getBean("iStuService");

		Student stu = new Student();
		istu.querryAllStu(stu);
	}
}
