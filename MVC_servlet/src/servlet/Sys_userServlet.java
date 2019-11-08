package servlet;

import com.it.bean.Sys_user;
import com.it.service.sys_user.Isys_user;
import com.it.service.sys_user.Sys_userImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class Sys_userServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��������
		request.setCharacterEncoding("UTF-8");
		//2.��ȡҳ����Ϣ����ȡopt
		String opt=request.getParameter("opt");
		String sys_user_name=request.getParameter("sys_user_name");
		String sys_user_password=request.getParameter("sys_user_password");
		//3.���ɶ���
		Sys_user sys_user=new Sys_user();

		//5.service
		Isys_user user=new Sys_userImpl();

		if("login".equals(opt)){
			//4.""   null
			if(!"".equals(sys_user_name)&&sys_user_name!=null){
				sys_user.setUser_name(sys_user_name);
			}
			if(!"".equals(sys_user_password)&&sys_user_password!=null){
				sys_user.setUser_password(sys_user_password);
			}

			//6.ִ��
			try {
				user.addSys_user(sys_user);
				//7.��ת
				boolean flag=user.logIn(sys_user);
				if(flag){
					response.sendRedirect("sys_user/index.htm");                   //����WEB-INF�ļ��ж�λ�����Ҫ��sys_user
				}
				else {
					response.sendRedirect("sys_user/login.htm");
				}

			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("sys_user/login.htm");
			}
			return;
		}


	}
}
