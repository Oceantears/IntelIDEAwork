/**
 * <一句话功能简述>
 * <p>
 * 用于创建一个SqlSessionFactory对象
 *
 * @author sunmeng
 * @create 2020/1/7   10:10
 */
package com.it.mybatis.sqlSession;

import com.it.mybatis.cfg.Configuration;
import com.it.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import com.it.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

	//根据参数的字节输入流来构建一个SqlSessionFactory工厂
	public SqlSessionFactory build(InputStream config){
		Configuration cfg= XMLConfigBuilder.loadConfiguration(config);
		return new DefaultSqlSessionFactory(cfg);
	}
}
