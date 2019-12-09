package com.sun.servlet;

import com.sun.bean.User;
import com.sun.server.IuserConfirm;
import com.sun.server.imp.UserConfirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��������
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String userName=request.getParameter("userName");
		int userID=Integer.parseInt(request.getParameter("userID"));
		System.out.println(userName);
		IuserConfirm iuserConfirm=new UserConfirm();
		try {
			if(iuserConfirm.confirmEmp(userID,userName)!=null){
				User user=iuserConfirm.getUser(userID,userName);
				//���ServiceУ��ͨ�������û���ݼ�¼��Session
				session.setAttribute("user",user);
				response.sendRedirect("index.jsp");
			}
			else {
				throw new RuntimeException("�û���������󣡣�");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
