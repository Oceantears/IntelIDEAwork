package com.springboot2.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: sun
 * @Date: 2021/5/16 19:38
 * @Description:
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);
        String[] strings = run.getBeanDefinitionNames();
        for (String s:strings){
            System.out.println(s);
        }
    }
}
