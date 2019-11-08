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
import java.util.List;

@WebServlet("/queryAllStudents.do")
public class QueryAllStudentsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");

		 PrintWriter out =response.getWriter();           //写样式表

		//1.生成service
		IStudents iStudents=new StudentsImpl();
		//2.生成对象
		Students students=new Students();
		//集合查询
		List<Students> stuList=iStudents.queryAllStudent(students);

		//添加样式表

		out.print("<head>\n" +
				"\t\t<meta charset=\"utf-8\">\n" +
				"\t\t<title>学生信息一览</title>\n" +
				"\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"css/bootstrap.css\">\n" +
				"\t\t<script type=\"text/javascript\" src=\"js/jquery-2.1.0.min.js\"></script>\n" +
				"\t\t<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n" +
				"\t\t<script type=\"text/javascript\" src=\"js/zh_CN.js\"></script>\n" +
				"\t\t<script type=\"text/javascript\" src=\"js/bootstrapValidator.min.js\"></script>\n" +
				"\t</head>\n" +
				"\t<body>\n" +
				"\t\t<div class=\"container\">\n" +
				"\t\t\t<form id=\"queryAllStudents\" action=\"queryAllStudents.do\" method=\"post\">\n" +
				"\t\t\t\t<div class=\"form-horizontal\">\n" +
				"\t\t\t\t\t<h2 class=\"lead\" style=\"color: ghostwhite\">学生信息一览</h2>\n" +
				"\t\t\t\t\t<div class=\"form-group\">\n" +
				"\t\t\t\t\t\t<table class=\"table table-hover\" border=\"1px\">\n" +
				"\t\t\t\t\t\t\t<tr>\n" +
				"\t\t\t\t\t\t\t\t<th>ID</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Num</th>\n" +
				"\t\t\t\t\t\t\t\t<th>NAME</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Addr</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Zip</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Tel</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Email</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Depno</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Birth</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Sex</th>\n" +
				"\t\t\t\t\t\t\t\t<th>Del/Update</th>\n" +
				"\t\t\t\t\t\t\t</tr>\n" );
		String[] colors={"success","warning","danger","info"};        //定义表格颜色数组
		int j=0;
		for (int i=0;i<stuList.size();i++) {
			Students stu=stuList.get(i);
			out.print("\t\t\t\t\t\t\t<tr class="+colors[j]+">\n" +
					"\t\t\t\t\t\t\t\t<td>" +(i+1)+ "</td>\n" +
					"\t\t\t\t\t\t\t\t<td>" + stu.getNum() + "</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getName()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getAddr()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getZip()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getTel()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getEmail()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getDepno()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getBirth()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>"+stu.getSex()+"</td>\n" +
					"\t\t\t\t\t\t\t\t<td>\n" +
					"\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\"删除\" onclick=\"javascript:window.location.href='del.do?stu_num="+stu.getNum()+"'\" />\n" +
					"\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\"修改\" onclick=\"javascript:window.location.href='update.html'\" />\n" +
					"\t\t\t\t\t\t\t\t</td>"+
					"\t\t\t\t\t\t\t</tr>\n");
			j++;
			if(j==(colors.length)){
				j=0;
			}
		}

		out.print("\t\t\t\t\t\t</table>\n" +
				"\t\t\t\t\t</div>\n" +
				"\t\t\t\t</div>\n" +
				"\t\t\t</form>\n" +
				"\t\t</div>\n" +
				"\t</body>");



	}
}
