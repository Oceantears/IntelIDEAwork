/**
 * <一句话功能简述>
 *
 * @author sunmeng
 * @create 2020/1/15   10:54
 */
package com.springboot.example.springboot_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	@GetMapping("/")
	//name之后可以加入required = false,defaultValue = "world"，如果不加，需要在网址上输入name值
	// public String hello(@RequestParam(name="name") String name, Model model){
	// 	model.addAttribute("name",name);
	// 	return "index";
	// }

	public String index(){
		return "index";
	}
}
