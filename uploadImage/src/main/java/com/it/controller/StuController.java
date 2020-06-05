/**
 * <一句话功能简述>
 * <p>
 * 学生类Controller层
 *
 * @author sunmeng
 * @create 2020/5/29   9:49
 */
package com.it.controller;

import com.it.domain.Student;
import com.it.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
	@Autowired
	private IStuService iStuService;

	@RequestMapping("/querryAllStu")
	public String querryAllStu(Student student, Model model){
		List<String> stusName = null;
		//尝试从缓存中取数据
		// stuCount = (String) redis

		// if(stusName == null){
		// 	// redis中没有数据，从数据库中查询，并放入redis缓存中，设置生存时间是1小时
		// 	System.out.println("从数据库中取出当前学生姓名。");
		// 	for (Student stu:iStuService.querryAllStu(student)) {
		// 		stusName.add(stu.getsName());
		// 	}
		// }else {
		// 	System.out.println("从缓存中取当前学生姓名。");
		// }

		model.addAttribute("students",iStuService.querryAllStu(student));

		return "student";
	}
}
