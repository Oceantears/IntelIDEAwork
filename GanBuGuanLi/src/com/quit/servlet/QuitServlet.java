package com.quit.servlet;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.quit.bean.PageBean;
import com.quit.bean.Quit;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.quit.service.QuitService;
@WebServlet({ "/QuitServlet", "/quit.do" })
public class QuitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String opt=request.getParameter("opt");
		String employee_id=request.getParameter("employee_id");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");;
		String age=request.getParameter("age");;
		String ks_id=request.getParameter("ks_id");;
		String admin_id=request.getParameter("admin_id");
		String cause=request.getParameter("cause");
		Quit quit=new Quit();
		QuitService quitService=new QuitService();
		if("add".equals(opt)) {
			if (!"".equals(employee_id)&&employee_id!=null) {
				quit.setEmployee_id(employee_id);
			}
			if (!"".equals(name)&&name!=null) {
				quit.setName(name);
			}
			if (!"".equals(sex)&&sex!=null) {
				quit.setSex(sex);
			}
			if (!"".equals(age)&&age!=null) {
				quit.setAge(age);
			}
			if (!"".equals(ks_id)&&ks_id!=null) {
				quit.setKs_id(ks_id);
			}
			if (!"".equals(admin_id)&&admin_id!=null) {
				quit.setAdmin_id(admin_id);
			}
			if (!"".equals(cause)&&cause!=null) {
				quit.setCause(cause);
			}
			boolean b=quitService.add(quit);
			JSONObject result = new JSONObject();
			if (b) {
				result.put("success", "保存成功！！！");
			} else {
				result.put("success", false);
				result.put("errorMsg", "保存失败");
			}
			out.print(result);
			return;
		}
		if("update".equals(opt)) {
			if (!"".equals(employee_id)&&employee_id!=null) {
				quit.setEmployee_id(employee_id);
			}
			if (!"".equals(name)&&name!=null) {
				quit.setName(name);
			}
			if (!"".equals(sex)&&sex!=null) {
				quit.setSex(sex);
			}
			if (!"".equals(age)&&age!=null) {
				quit.setAge(age);
			}
			if (!"".equals(ks_id)&&ks_id!=null) {
				quit.setKs_id(ks_id);
			}
			if (!"".equals(admin_id)&&admin_id!=null) {
				quit.setAdmin_id(admin_id);
			}
			if (!"".equals(cause)&&cause!=null) {
				quit.setCause(cause);
			}
			boolean b=quitService.update(quit);
			JSONObject result = new JSONObject();
			if (b) {
				result.put("success", "修改成功！！！");
			} else {
				result.put("success", false);
				result.put("errorMsg", "修改失败");
			}
			out.print(result);
			return;
		}
		if("del".equals(opt)) {
			if (!"".equals(employee_id)&&employee_id!=null) {
				quit.setEmployee_id(employee_id);
			}
			boolean b=quitService.del(quit);
			if (b){
				response.sendRedirect("#");
			}
			String delIds = request.getParameter("delArray");
			JSONObject result = new JSONObject();
			int delNums = 0;
			if (!"".equals(employee_id) && employee_id != null) {
				quit.setEmployee_id(employee_id);
				quitService.del(quit);
				delNums = 1;
			} else {
				delNums = quitService.delarray(delIds);
			}
			if (delNums > 0) {
				result.put("success", true);
				result.put("delNums", delNums);
			} else {
				result.put("errorMsg", "删除失败");
			}
			out.print(result);
			return;
		}
		if("findById".equals(opt)){
			quit.setEmployee_id(employee_id);
			Quit quit2= quitService.findbyid(quit);
			request.setAttribute("quit2", quit2);
			request.getRequestDispatcher("updatequit.jsp").forward(request, response);		
			return;
		}
		if("queryAll".equals(opt)) {
			List<Quit> lists = null;
			String page = request.getParameter("page");
			String rows = request.getParameter("limit");
			if (!"".equals(employee_id) && employee_id != null) {
				quit.setEmployee_id(employee_id);
			}
			if (!"".equals(name) && name != null) {
				quit.setName(name);
			}
			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
			lists = quitService.query(pageBean, quit);
			int total = quitService.Count(quit);
			JSONObject result = new JSONObject();
			JSONArray jsonArray = JSONArray.fromObject(lists);
			result.put("code", 0);
			result.put("msg", "正在加载....");
			result.put("count", total);
			result.put("data", jsonArray);
			out.print(result);
			return;
		}
	}	
}
