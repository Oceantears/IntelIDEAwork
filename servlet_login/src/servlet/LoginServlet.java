package servlet;

import com.it.bean.Students;
import com.it.service.IStudents;
import com.it.service.StudentsImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();

		String stu_name=request.getParameter("stu_name");
		String stu_tel=request.getParameter("stu_tel");

		Students students=new Students();

		if(!"".equals(stu_name)&&stu_name!=null){
			students.setName(stu_name);
		}
		if(!"".equals(stu_tel)&&stu_tel!=null){
			students.setTel(Integer.parseInt(stu_tel));
		}

		IStudents iStudents=new StudentsImpl();

		boolean flag=false;
		try {
			flag=iStudents.logIn(students);
			if(flag){
				response.sendRedirect("queryAllStudents.do");
			}
			else {
				out.print("");
				response.sendRedirect("login.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.html");
		}
	}
}
