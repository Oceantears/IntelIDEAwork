package com.springboot2.start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sun
 * @Date: 2021/5/17 0:01
 * @Description:
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(){
        return "Hello World!";
    }
}
