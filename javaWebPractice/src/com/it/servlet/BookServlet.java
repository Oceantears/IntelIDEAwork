package com.it.servlet;

import com.it.bean.Book;
import com.it.service.BookImpl;
import com.it.service.IBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.处理乱码
		request.setCharacterEncoding("utf-8");
		//2.获取页面信息，获取opt
		String opt=request.getParameter("opt");
		String book_no=request.getParameter("book_no");
		String type_no=request.getParameter("type_no");
		String book_name=request.getParameter("book_name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String price=request.getParameter("price");

		Book book=new Book();
		IBook bookImpl=new BookImpl();
		List<Book> booksList=null;
		if("book_add".equals(opt)){
			if(!"".equals(type_no)&&type_no!=null){
				book.setType_no(type_no);
			}
			if(!"".equals(book_name)&&book_name!=null){
				book.setBook_name(book_name);
			}
			if(!"".equals(author)&&author!=null){
				book.setAuthor(author);
			}
			if(!"".equals(publisher)&&publisher!=null){
				book.setPublisher(publisher);
			}
			if(!"".equals(price)&&price!=null){
				book.setPrice(Double.parseDouble(price));
			}

			try {
				bookImpl.addBook(book);
				response.sendRedirect("BookServlet?opt=book_queryAll");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.html");
			}

			return;
		}
		if("book_del".equals(opt)){
			if(!"".equals(book_no)&&book_no!=null){
				book.setBook_no(Integer.parseInt(book_no));
			}
			try {
				bookImpl.delBook(book);
				response.sendRedirect("BookServlet?opt=book_queryAll");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
			return;
		}
		if("book_update".equals(opt)){
			if(!"".equals(book_no)&&book_no!=null){
				book.setBook_no(Integer.parseInt(book_no));
			}
			if(!"".equals(type_no)&&type_no!=null){
				book.setType_no(type_no);
			}
			if(!"".equals(book_name)&&book_name!=null){
				book.setBook_name(book_name);
			}
			if(!"".equals(author)&&author!=null){
				book.setAuthor(author);
			}
			if(!"".equals(publisher)&&publisher!=null){
				book.setPublisher(publisher);
			}
			if(!"".equals(price)&&price!=null){
				book.setPrice(Double.parseDouble(price));
			}
			try {
				bookImpl.updateBook(book);
				response.sendRedirect("BookServlet?opt=book_queryAll");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
			return;
		}
		if("book_findById".equals(opt)){
			Book book1=null;
			if(!"".equals(book_no)&&book_no!=null){
				book.setBook_no(Integer.parseInt(book_no));
			}
			try {
				book1=bookImpl.findById(book);
				if(book1!=null){
					request.setAttribute("book1",book1);
					request.getRequestDispatcher("findBookByID.jsp").forward(request,response);
				}
				response.sendRedirect("BookServlet?opt=queryAll");

			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
			return;
		}
		if("book_queryAll".equals(opt)){
			if(!"".equals(book_name)&&book_name!=null){
				book.setBook_name(book_name);
			}
			if(!"".equals(book_no)&&book_no!=null){
				book.setBook_no(Integer.parseInt(book_no));
			}
			try {
				booksList=bookImpl.queryAllBook(book);
				System.out.println("=======================>"+booksList.size());
				//储存数据到request中
				request.setAttribute("booksList",booksList);
				//跳转
				request.getRequestDispatcher("queryAllBooks.jsp").forward(request,response);
			}
			catch (Exception e){
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
			return;
		}
	}
}
