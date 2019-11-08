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

@WebServlet("/del.do")
public class DelServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡҳ����Ϣ
		String stu_num=request.getParameter("stu_num");
		//2.���ɶ���
		Students students=new Students();
		//�ж�""��null
		if(!"".equals(stu_num)&&stu_num!=null){
			students.setNum(Integer.parseInt(stu_num));
		}
		//4.service
		IStudents iStudents=new StudentsImpl();
		//5.ִ��
		try {
			iStudents.delStudent(students);
			response.sendRedirect("queryAllStudents.do");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
}
