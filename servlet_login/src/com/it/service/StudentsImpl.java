/**
 * <Ò»¾ä»°¹¦ÄÜ¼òÊö>
 * <ÒÀÀµDAO²ã>
 *
 * @author sunmeng
 * @create 2019/10/30   0:01
 */
package com.it.service;

import com.it.bean.Students;
import com.it.dao.IStudentsDAO;
import com.it.dao.StudentsDAOImpl;

import java.util.List;

public class StudentsImpl implements IStudents {
	IStudentsDAO studentsDAO=new StudentsDAOImpl();

	@Override
	public void addStudent(Students students) {
		studentsDAO.addStudent(students);
	}

	@Override
	public void delStudent(Students students) {
		studentsDAO.delStudent(students);
	}

	@Override
	public void updateStudent(Students students) {
		studentsDAO.updateStudent(students);
	}

	@Override
	public Students findStudentById(Students students) {
		return studentsDAO.findStudentById(students);
	}

	@Override
	public List<Students> queryAllStudent(Students students) {
		return studentsDAO.queryAllStudent(students);
	}

	@Override
	public boolean logIn(Students students) {
		return studentsDAO.logIn(students);
	}
}
