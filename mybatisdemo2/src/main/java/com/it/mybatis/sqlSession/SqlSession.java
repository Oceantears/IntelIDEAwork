/**
 * <一句话功能简述>
 * <p>
 *
 * 自定义mybatis中和数据库交互的核心类
 * 里面可以创建dao接口的代理对象
 *
 * @author sunmeng
 * @create 2020/1/7   10:15
 */
package com.it.mybatis.sqlSession;

public interface SqlSession {
	//根据参数创建一个代理对象
	<T> T getMapper(Class<T> daoInterfaceClass);

	//释放资源
	void close();
}
