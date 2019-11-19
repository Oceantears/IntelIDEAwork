/**
 * <一句话功能简述>
 * <>
 *
 * @author sunmeng
 * @create 2019/11/14   10:04
 */
package com.it.service;

import com.it.bean.Book;
import com.it.dao.BookDAOImpl;
import com.it.dao.IBookDAO;

import java.util.List;

public class BookImpl implements IBook {
	IBookDAO bookDAO=new BookDAOImpl();
	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	@Override
	public void delBook(Book book) {
		bookDAO.delBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}

	@Override
	public List<Book> queryAllBook(Book book) {
		return bookDAO.queryAllBook(book);
	}

	@Override
	public Book findById(Book book) {
		return bookDAO.findById(book);
	}
}
