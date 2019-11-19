/**
 * <一句话功能简述>
 * <>
 *
 * @author sunmeng
 * @create 2019/11/14   10:03
 */
package com.it.dao;

import com.it.bean.Book;

import java.util.List;

public interface IBookDAO {
	public void addBook(Book book);
	public void delBook(Book book);
	public void updateBook(Book book);
	public List<Book> queryAllBook(Book book);
	public Book findById(Book book);
}
