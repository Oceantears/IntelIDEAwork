/**
 * <一句话功能简述>
 * <p>
 * 代理方式
 *
 * @author sunmeng
 * @create 2020/1/7   11:42
 */
package com.it.mybatis.sqlSession.proxy;

import com.it.mybatis.cfg.Mapper;
import com.it.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
	//Map的key是全限定类名+方法名
	private Map<String, Mapper> mappers;
	private Connection conn;
	public MapperProxy(Map<String,Mapper> mappers,Connection conn){
		this.mappers=mappers;
		this.conn=conn;
	}

	//用于对方法进行增强，我们的增强其实就是调用selectList方法
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//1.获取方法名
		String methodName =method.getName();
		//2.获取方法所在类的名称
		String className=method.getDeclaringClass().getName();
		//3.组合key
		String key=className+"."+methodName;
		//4.获取mappers中的Mapper对象
		Mapper mapper=mappers.get(key);
		//5.判断是否有mapper
		if(mapper==null){
			throw new IllegalArgumentException("传入参数有误");
		}
		//6.调用工具类执行查询所有

		return new Executor().selectList(mapper,conn);
	}
}
