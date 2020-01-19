/**
 * <一句话功能简述>
 * <p>
 * SqlSessionFactory接口的实现类
 *
 * @author sunmeng
 * @create 2020/1/7   11:26
 */
package com.it.mybatis.sqlSession.defaults;

import com.it.mybatis.cfg.Configuration;
import com.it.mybatis.sqlSession.SqlSession;
import com.it.mybatis.sqlSession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
	private Configuration cfg;

	public DefaultSqlSessionFactory(Configuration cfg){
		this.cfg=cfg;
	}

	//用于创建一个新的操作数据库对象
	public SqlSession openSession() {
		return new DefaultSqlSession(cfg);
	}
}
