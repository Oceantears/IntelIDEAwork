/**
 * <一句话功能简述>
 * <p>
 * 使用类加载器读取配置文件的类
 *
 * @author sunmeng
 * @create 2020/1/7   10:04
 */
package com.it.mybatis.io;

import java.io.InputStream;

public class Resources {
	public static InputStream getResourceAsStream(String filePath){
		//获取当前字节码，获取字节码的类加载器，之后根据类加载器读取配置
		return Resources.class.getClassLoader().getResourceAsStream(filePath);
	}
}
