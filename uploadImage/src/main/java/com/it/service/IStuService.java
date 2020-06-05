/**
 * <一句话功能简述>
 * <p>
 * 学生类的服务层接口
 *
 * @author sunmeng
 * @create 2020/5/29   9:46
 */
package com.it.service;

import com.it.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStuService {
	public List<Student> querryAllStu(Student student);

	public int insertStu(Student student);
}
