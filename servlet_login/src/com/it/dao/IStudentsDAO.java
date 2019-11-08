/**
 * <һ�仰���ܼ���>
 * <DAO�㣬���������ݿ⽻��>
 *
 * @author sunmeng
 * @create 2019/10/30   0:09
 */
package com.it.dao;

import com.it.bean.Students;

import java.util.List;

public interface IStudentsDAO {
	//��
	public void addStudent(Students students);
	//ɾ
	public void delStudent(Students students);
	//��
	public void updateStudent(Students students);
	//��ѯ����
	public Students findStudentById(Students students);
	//��ѯ����
	public List<Students> queryAllStudent(Students students);
	//��¼
	public boolean logIn(Students students);
}
