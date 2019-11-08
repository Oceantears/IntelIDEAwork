/**
 * <一句话功能简述>
 * <用户表功能集合>
 *
 * @author sunmeng
 * @create 2019/10/30   0:02
 */
package com.it.service;

import com.it.bean.Students;

import java.util.List;

public interface IStudents {
	//增
	public void addStudent(Students students);
	//删
	public void delStudent(Students students);
	//改
	public void updateStudent(Students students);
	//查询单个
	public Students findStudentById(Students students);
	//查询所有
	public List<Students> queryAllStudent(Students students);
	//登录
	public boolean logIn(Students students);
}
