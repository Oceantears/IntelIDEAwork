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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//1.获取页面信息      form表单中获取的都是字符串
		String stu_num=request.getParameter("stu_num");
		String stu_name=request.getParameter("stu_name");
		String stu_addr=request.getParameter("stu_addr");
		String stu_zip =request.getParameter("stu_zip");
		String stu_tel =request.getParameter("stu_tel");
		String stu_email =request.getParameter("stu_email");
		String stu_depno =request.getParameter("stu_depno");
		String stu_birth =request.getParameter("stu_birth");
		String stu_sex =request.getParameter("stu_sex");

		//2.封装对象
		Students students=new Students();
		//判断非null或""
		if(!"".equals(stu_num)&&stu_num!=null){
			students.setNum(Integer.parseInt(stu_num));
		}
		if(!"".equals(stu_name)&&stu_name!=null){
			students.setName(stu_name);
		}
		if(!"".equals(stu_addr)&&stu_addr!=null){
			students.setAddr(stu_addr);
		}
		if(!"".equals(stu_zip)&&stu_zip!=null){
			students.setZip(Integer.parseInt(stu_zip));
		}
		if(!"".equals(stu_tel)&&stu_tel!=null){
			students.setTel(Integer.parseInt(stu_tel));
		}
		if(stu_email==""){
			students.setEmail(null);
		}else {
			students.setEmail(stu_email);                 //email可以为空
		}

		if(!"".equals(stu_depno)&&stu_depno!=null){

			students.setDepno(stu_depno);

		}
		if(!"".equals(stu_birth)&&stu_birth!=null){
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			try {
				students.setBirth(dateFormat.parse(stu_birth));
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException("生日日期转换出错！！");
			}
		}
		if(!"".equals(stu_sex)&&stu_sex!=null){
			students.setSex(stu_sex);
		}
		//3.service
		IStudents iStudents=new StudentsImpl();
		//执行功能          try-catch快捷键：Ctrl+win+Alt+T
		try {
			iStudents.updateStudent(students);
			response.sendRedirect("queryAllStudents.do");                  //添加成功后，响应跳转查询
		} catch (IOException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");                  //添加失败后，响应跳转页面,重新添加
		}
	}
}
