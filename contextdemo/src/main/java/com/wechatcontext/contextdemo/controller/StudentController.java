/**
 * <一句话功能简述>
 * <p>
 * 学生类控制层
 *
 * @author sunmeng
 * @create 2020/4/13   18:51
 */
package com.wechatcontext.contextdemo.controller;

import com.wechatcontext.contextdemo.model.StudentDomain;
import com.wechatcontext.contextdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/addStudent")
	@ResponseBody
	public int addStudent(StudentDomain stu){

		return studentService.addStudent(stu);
	}

	@RequestMapping("/findAllStudents")
	@ResponseBody
	public Object findAllStudent(
			StudentDomain stu,
			@RequestParam(name = "pageNum",required = false,defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
	){
		return studentService.findAllStudents(stu,pageNum,pageSize);
	}
}
