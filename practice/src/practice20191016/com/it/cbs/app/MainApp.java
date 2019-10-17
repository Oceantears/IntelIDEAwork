/**
 * <一句话功能简述>
 * <程序入口>
 *
 * 1)	查询表中所有信息
 * 2)	修改数据：修改112266号图书的价格为39.00
 * 3)	查询数据：查找出高等教育出版社的所有图书及单价，结果按单价降序排列
 * 4)	查询数据:按照出版社和作者进行模糊查询
 * 5)	删除数据：删除所有隶属于TP3/12类的书籍信息
 * 6)	查询数据库中一共有多少条记录
 * 7)	按照每页pageSize=5条记录实现分页功能
 * 8)	要求用数据库连接池实现底层封装
 *
 * @author sunmeng
 * @create 2019/10/16   10:41
 */
package practice20191016.com.it.cbs.app;

import practice20191016.com.it.cbs.view.MainView;

public class MainApp {
	public static void main(String[] args) {
		new MainView().run();

	}
}
