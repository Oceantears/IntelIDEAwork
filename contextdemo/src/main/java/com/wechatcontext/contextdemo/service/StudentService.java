/**
 * <一句话功能简述>
 * <p>
 * 学生类service接口
 *
 * @author sunmeng
 * @create 2020/4/13   18:54
 */
package com.wechatcontext.contextdemo.service;

import com.github.pagehelper.PageInfo;
import com.wechatcontext.contextdemo.model.StudentDomain;

import java.util.List;

public interface StudentService {
	int addStudent(StudentDomain stu);

	PageInfo<StudentDomain> findAllStudents(StudentDomain stu,int pageNum,int pageSize);
}
