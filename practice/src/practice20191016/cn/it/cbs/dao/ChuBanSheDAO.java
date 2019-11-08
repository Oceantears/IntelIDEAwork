/**
 * <一句话功能简述>
 * <创建类ZhangWuDao.java，给ZhangWuDao类添加一个成员变量QueryRunner对象，因为我们使用dbutils来操作数据库。>
 *
 * @author sunmeng
 * @create 2019/10/16   10:44
 */
package practice20191016.cn.it.cbs.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import practice20191016.com.it.cbs.bean.ChuBanShe;
import practice20191016.com.it.cbs.bean.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ChuBanSheDAO {
	QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
	public List<ChuBanShe> selectAll(){

		String sql="select * from cbs";
		try {
			return queryRunner.query(sql,new BeanListHandler<ChuBanShe>(ChuBanShe.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<ChuBanShe> select(String s){
		//List<ChuBanShe> list=null;
		String sql="select book_name,price from cbs where publisher='"+s+"' and 1=1 order by price desc";
		//Object[] params={"book_name","price","price"};

		try {
			return queryRunner.query(sql,new BeanListHandler<ChuBanShe>(ChuBanShe.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateBook(ChuBanShe chuBanShe){
		String sql="update cbs set author=? where book_no=?";      //type_no=?,book_name=?,author=?,publisher=?
		try {
			Object[] params={chuBanShe.getAuthor(),chuBanShe.getBook_no()};       //chuBanShe.getType_no(),chuBanShe.getBook_name(),chuBanShe.getAuthor(),chuBanShe.getPublisher(),

			queryRunner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
