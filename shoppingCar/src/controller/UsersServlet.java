package controller;

import com.it.bean.UserInfo;
import com.it.service.users.IUser;
import com.it.service.users.UserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/usersServlet")
public class UsersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0 处理乱码
		request.setCharacterEncoding("utf-8");
		// 1 获取页面信息，获取opt值
		String opt=request.getParameter("opt");
		String user_id=request.getParameter("user_id");
		String user_name=request.getParameter("user_name");
		String user_pwd=request.getParameter("user_pwd");
		String user_addr=request.getParameter("user_addr");
		String user_tel=request.getParameter("user_tel");
		String user_sex=request.getParameter("user_sex");

		//生成对象
		UserInfo userInfo=new UserInfo();
		//service

		IUser iUser=new UserImpl();

		//服务器端进行会话跟踪
		//生成session
		HttpSession session=request.getSession();
		//List<UserInfo> userInfoList=null;

		// 5 根据opt的值进行判断执行特定的功能
		//登录
		if("login".equals(opt)){

			userInfo.setUser_name(user_name);
			userInfo.setUser_pwd(user_pwd);
			UserInfo user=iUser.login(userInfo);
			if(user!=null){
				//首页--》展示所有信息--》queryAll.do
				//user.do?opt=queryAll
				//response.sendRedirect("index.html");

				//response.sendRedirect("user.do?opt=queryAll");
				//保存值
				session.setAttribute("users",user);
				response.sendRedirect("jsp/goods/goodsList.jsp");                  //商品展示页
			}
			else {
				response.sendRedirect("users/login.htm");                   //登录页面
			}
			return;
		}

		//注册
		if("reg".equals(opt)){

			return;
		}
	}
}
