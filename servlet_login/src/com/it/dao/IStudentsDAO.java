/**
 * <一句话功能简述>
 * <DAO层，负责与数据库交互>
 *
 * @author sunmeng
 * @create 2019/10/30   0:09
 */
package com.it.dao;

import com.it.bean.Students;

import java.util.List;

public interface IStudentsDAO {
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
