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

@WebServlet("/findSinger.do")
public class FindSingerByIDServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ณýยาย๋
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out=response.getWriter();

		String stu_num=request.getParameter("stu_num");

		Students student=new Students();
		if(!"".equals(stu_num)&&stu_num!=null){
			student.setNum(Integer.parseInt(stu_num));
		}

		IStudents iStudents=new StudentsImpl();
		Students stu=null;
		try {
			stu=iStudents.findStudentById(student);
			if(stu!=null){

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
