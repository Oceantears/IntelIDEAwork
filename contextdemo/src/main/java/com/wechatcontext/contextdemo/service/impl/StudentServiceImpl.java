/**
 * <一句话功能简述>
 * <p>
 * service实现类
 *
 * @author sunmeng
 * @create 2020/4/13   18:55
 */
package com.wechatcontext.contextdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechatcontext.contextdemo.dao.StudentDao;
import com.wechatcontext.contextdemo.model.StudentDomain;
import com.wechatcontext.contextdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public int addStudent(StudentDomain stu) {
		return studentDao.addStudent(stu);
	}

	/**
	 * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
	 * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
	 * pageNum 开始页数
	 * pageSize 每页显示的数据条数
	 * @param stu
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<StudentDomain> findAllStudents(StudentDomain stu, int pageNum, int pageSize) {
		//将参数传给这个方法就可以实现物理分页了，非常简单
		PageHelper.startPage(pageNum,pageSize);
		List<StudentDomain> students = studentDao.findAllStudents(stu);
		PageInfo result = new PageInfo(students);
		return result;
	}


}
