/**
 * <һ�仰���ܼ���>
 * <�û����ܼ���>
 *
 * @author sunmeng
 * @create 2019/10/30   0:02
 */
package com.it.service;

import com.it.bean.Students;

import java.util.List;

public interface IStudents {
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
