package com.wechatcontext.contextdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wechatcontext.contextdemo.dao")
public class ContextdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContextdemoApplication.class, args);
	}

}
