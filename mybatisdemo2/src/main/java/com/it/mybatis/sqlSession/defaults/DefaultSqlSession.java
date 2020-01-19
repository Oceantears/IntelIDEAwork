/**
 * <一句话功能简述>
 * <p>
 * SqlSession接口的实现类
 *
 * @author sunmeng
 * @create 2020/1/7   11:31
 */
package com.it.mybatis.sqlSession.defaults;

import com.it.mybatis.cfg.Configuration;
import com.it.mybatis.sqlSession.SqlSession;
import com.it.mybatis.sqlSession.proxy.MapperProxy;
import com.it.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {
	private Configuration cfg;
	private Connection connection;
	public DefaultSqlSession(Configuration cfg){
		this.cfg=cfg;
		this.connection= DataSourceUtil.getConnection(cfg);
	}

	//用于创建代理对象
	public <T> T getMapper(Class<T> daoInterfaceClass) {
		return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
				new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
	}
	//用于释放资源
	public void close() {
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
