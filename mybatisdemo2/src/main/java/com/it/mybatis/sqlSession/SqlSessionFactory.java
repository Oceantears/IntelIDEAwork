/**
 * <一句话功能简述>
 * <p>
 * SqlSessionFactory接口
 *
 * @author sunmeng
 * @create 2020/1/7   10:12
 */
package com.it.mybatis.sqlSession;

public interface SqlSessionFactory {
	//用于打开一个新的SqlSession对象
	SqlSession openSession();
}
