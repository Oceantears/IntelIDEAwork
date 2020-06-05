/**
 * <一句话功能简述>
 * <p>
 * 学生类dao层
 *
 * @author sunmeng
 * @create 2020/5/29   9:48
 */
package com.it.dao;

import com.it.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository		//此注解代表这是一个持久层，用法类似@controller、@service
public interface IStuDao {
	// @Select("select * from student")
	public List<Student> querryAllStu(Student student);
	@Insert("insert into student values (#{sNo},#{sName},#{sSex},#{sBirthday},#{sClasses})")
	public int insertStu(Student student);
}
