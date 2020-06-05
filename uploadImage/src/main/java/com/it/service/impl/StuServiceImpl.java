/**
 * <一句话功能简述>
 * <p>
 * 学生类服务层实现类
 *
 * @author sunmeng
 * @create 2020/5/29   9:47
 */
package com.it.service.impl;

import com.it.dao.IStuDao;
import com.it.domain.Student;
import com.it.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("iStuService")
public class StuServiceImpl implements IStuService {
	@Autowired
	private IStuDao stuDao;
	@Override
	public List<Student> querryAllStu(Student student) {

		return stuDao.querryAllStu(student);
	}

	@Transactional	//事务注释，涉及到改变数据库的最好都加上
	@Override
	public int insertStu(Student student) {

		return stuDao.insertStu(student);
	}
}
