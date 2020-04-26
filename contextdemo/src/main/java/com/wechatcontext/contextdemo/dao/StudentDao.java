/**
 * <一句话功能简述>
 * <p>
 * 学生dao层
 *
 * @author sunmeng
 * @create 2020/4/13   18:52
 */
package com.wechatcontext.contextdemo.dao;

import com.wechatcontext.contextdemo.model.StudentDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
	int addStudent(StudentDomain stu);

	List<StudentDomain> findAllStudents(StudentDomain stu);
}
