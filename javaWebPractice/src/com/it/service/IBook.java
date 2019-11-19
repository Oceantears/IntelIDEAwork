/**
 * <一句话功能简述>
 * <>
 *
 * @author sunmeng
 * @create 2019/11/14   10:04
 */
package com.it.service;

import com.it.bean.Book;

import java.util.List;

public interface IBook {
	public void addBook(Book book);
	public void delBook(Book book);
	public void updateBook(Book book);
	public List<Book> queryAllBook(Book book);
	public Book findById(Book book);
}
