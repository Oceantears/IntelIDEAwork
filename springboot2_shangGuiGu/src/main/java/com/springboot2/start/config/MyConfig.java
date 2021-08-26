package com.springboot2.start.config;

import com.springboot2.start.entity.Car;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author: sun
 * @Date: 2021/5/22 17:29
 * @Description:
 */
@EnableConfigurationProperties(Car.class)
public class MyConfig {

}
