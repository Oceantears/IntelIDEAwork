/**
 * <一句话功能简述>
 * <p>
 * 持久层接口
 *
 * @author sunmeng
 * @create 2020/1/6   14:51
 */
package com.it.dao;

import com.it.bean.Student;

import java.util.List;

public interface IStudentDAO {
	public List<Student> queryAll();
}
