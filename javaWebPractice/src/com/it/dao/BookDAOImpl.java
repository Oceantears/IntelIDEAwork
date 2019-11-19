/**
 * <一句话功能简述>
 * <>
 *
 * @author sunmeng
 * @create 2019/11/14   10:04
 */
package com.it.dao;

import com.it.bean.Book;
import com.it.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements IBookDAO {
	QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
	@Override
	public void addBook(Book book) {
		String sql="insert into book(type_no,book_name,author,publisher,price) values (?,?,?,?,?)";
		Object[] params={book.getType_no(),book.getBook_name(),book.getAuthor(),book.getPublisher(),book.getPrice()};

		try {
			int result=queryRunner.update(sql,params);
			if(result>0){
				System.out.println("=============添加成功=============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败！！");
		}
		finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delBook(Book book) {
		String sql="delete from book where book_no=?";
		Object[] parms={book.getBook_no()};
		try {
			int result=queryRunner.update(sql,parms);
			if(result>0){
				System.out.println("=============删除成功==============>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库删除操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateBook(Book book) {
		String sql="update book set type_no=?,book_name=?,author=?,publisher=?,price=?";
		Object[] parms={book.getType_no(),book.getBook_name(),book.getAuthor(),book.getPublisher(),book.getPrice()};

		try {
			int result=queryRunner.update(sql,parms);
			if(result>0){
				System.out.println("===========修改操作成功================>"+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库修改数据操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Book> queryAllBook(Book book) {
		System.out.println(book.toString());
		StringBuffer sql=new StringBuffer();
		sql.append("select * from book where 1=1 ");                 //1=1后需要加空格
		//1 保证对象不为null,分配了内存空间
		if(book!=null){
			//2 判断哪些字段有模糊查询
			if(!"".equals(book.getBook_name())&&book.getBook_name()!=null){
				sql.append("and book_name like '%"+book.getBook_name()+"%'");
			}
			if(new Integer(book.getBook_no())!=0){
				sql.append("and book_no like '%"+book.getBook_no()+"%'");
			}
		}
		List<Book> bookList=null;

		//System.out.println("sql=========>"+sql.toString());

		try {
			bookList=queryRunner.query(sql.toString(),new BeanListHandler<Book>(Book.class));
			System.out.println("==============模糊查询成功===========>"+bookList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库查询操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}

	@Override
	public Book findById(Book book) {
		String sql="select * from book where book_no=?";
		Object[] parms={book.getBook_no()};
		Book book1=null;
		try {
			book1=queryRunner.query(sql,new BeanHandler<Book>(Book.class),parms);
			System.out.println("===========查询成功======你要找的学生======>"+book1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库查询操作失败！！");
		}finally {
			try {
				JDBCUtils.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return book1;
	}
}
