package com.gyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gyq.bean.PageBean;
import com.gyq.bean.posinformation;

import com.gyq.service.Postimpl;




/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/postServlet", "/post.do" })
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取页面上的值
		String opt=request.getParameter("opt");
		String Job_no=request.getParameter("job_no");
		String Ks_no=request.getParameter("ks_no");
		String Job_title=request.getParameter("job_title");
		String Job_description=request.getParameter("job_description");
		String Job_duenum=request.getParameter("job_duenum");
		String Job_realitynum=request.getParameter("job_realitynum");
		String Shortage_num=request.getParameter("shortage_num");
		String Job_preparation=request.getParameter("job_preparation");
		
		
		PrintWriter out = response.getWriter();
		//创建对象
		posinformation post=new posinformation();
		//service
		Postimpl postimpl=new Postimpl();
		
		
		
		//添加功能
		if("add".equals(opt)){
			// "" null
			//判断
			if(!"".equals(Job_no)&&Job_no!=null){
				post.setJob_no(Job_no);
			}
			if(!"".equals(Ks_no)&&Ks_no!=null){
				post.setKs_no(Ks_no);
			}
			if(!"".equals(Job_title)&&Job_title!=null){
				post.setJob_title(Job_title);
			}

			if(!"".equals(Job_description)&&Job_description!=null){
				post.setJob_description(Job_description);
			}
			if(!"".equals(Job_duenum)&&Job_duenum!=null){
				post.setJob_duenum(Job_duenum);
			}
			if(!"".equals(Job_realitynum)&&Job_realitynum!=null){
				post.setJob_realitynum(Job_realitynum);
			}
			if(!"".equals(Shortage_num) && Shortage_num!=null) {
				post.setShortage_num(Shortage_num);
			}
			if(!"".equals(Job_preparation)&&Job_preparation!=null){
				post.setJob_preparation(Job_preparation);
			}
			JSONObject result = new JSONObject();
			boolean flag = postimpl.update(post);
			
			if(flag){
				result.put("success", "保存成功！！！");
				
			}else{
				result.put("success", false);
				result.put("errorMsg", "保存失败");
			}
			out.print(result);
			
			return;
			
			
		}
		
		
	
		//查询单个
				if("findById".equals(opt)){
					//判断
					if(!"".equals(Job_no)&&Job_no!=null){
						post.setJob_no(Job_no);
					}
					posinformation post2 = postimpl.select(post);
					
					if(post2!=null){
						
						
						request.setAttribute("post2", post2);
						//转发
						request.getRequestDispatcher("post/updatepost.jsp").forward(request, response);
						
					}
					
					return;
				}
				
		//修改
				if("upd".equals(opt)){
					//判断
					if(!"".equals(Job_no)&&Job_no!=null){
						post.setJob_no(Job_no);
					}
					if(!"".equals(Ks_no)&&Ks_no!=null){
						post.setKs_no(Ks_no);
					}
					if(!"".equals(Job_title)&&Job_title!=null){
						post.setJob_title(Job_title);
					}

					if(!"".equals(Job_description)&&Job_description!=null){
						post.setJob_description(Job_description);
					}
					if(!"".equals(Job_duenum)&&Job_duenum!=null){
						post.setJob_duenum(Job_duenum);
					}
					if(!"".equals(Job_realitynum)&&Job_realitynum!=null){
						post.setJob_realitynum(Job_realitynum);
					}
					if(!"".equals(Shortage_num) && Shortage_num!=null) {
						post.setShortage_num(Shortage_num);
					}
					if(!"".equals(Job_preparation)&&Job_preparation!=null){
						post.setJob_preparation(Job_preparation);
					}
					JSONObject result = new JSONObject();
					boolean flag = postimpl.update(post);
					if(flag){
						out.print("修改成功!");
						
						
					}else{
						
						out.print("修改失败!");
						
					}
					
					return;
				}
				
//删除功能
				if("del".equals(opt)){
					//获取前端页面的id集合
					String delIds = request.getParameter("delArray");
					
		              System.out.println("delIds--->"+delIds);
					JSONObject result = new JSONObject();
					int delNums = 0;
					//获取前端页面的user_id
					if(!"".equals(Job_no)&&Job_no!=null){
						post.setJob_no(Job_no);
						  postimpl.del(post);
						delNums = 1;
					}else{
						delNums = postimpl.postDelete(delIds);
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
		
		//删除单个功能
		if("delById".equals(opt)){
			int delNums = 0;
			//获取前端页面的user_id
			//判断
			if(!"".equals(Job_no)&&Job_no!=null){
				post.setJob_no(Job_no);
			}
		
			        postimpl.del(post);
			JSONObject result = new JSONObject();
			if (delNums > 0) {
				result.put("success", "删除成功!");
			} else {
				result.put("errorMsg", "删除失败");
			}
			
			out.print(result);
			return;
		}
		//查询所有
				if("queryAll".equals(opt)){
					// 存放集合内容
					List<posinformation> lists= null;	
					String page = request.getParameter("page");
					String rows = request.getParameter("limit");
					if(!"".equals(Job_no)&&Job_no!=null){
						post.setJob_no(Job_no);
					}
					if(!"".equals(Ks_no)&& Ks_no!=null){
						post.setKs_no(Ks_no);
					}
					PageBean pageBean = new PageBean(Integer.parseInt(page),
							Integer.parseInt(rows));
					
					//查询所有信息默认分页
					lists = postimpl.queryAllPost(pageBean, post);
					//查询总记录数
					int total =postimpl.postCount(post);
					
					JSONObject result = new JSONObject();
					
					

					JSONArray jsonArray = JSONArray.fromObject(lists);
					result.put("code", 0);
					result.put("msg", "正在加载....");
					result.put("count", total);
					result.put("data", jsonArray);
					System.out.println(result.toString());
					 out.print(result);
					/*JSONArray jsonArray = JSONArray.fromObject(lists);
					result.put("total", total);
					result.put("rows", jsonArray);
					System.out.println(result.toString());
					 out.print(result);*/
					
					return;
				}
/*		
		//登陆
		//判断“”！null
		if("login".equals(opt)){
			if(!"".equals(Sno)&&Sno!=null){
				stu.setJob_no(Sno);
			}
			if(!"".equals(Sname)&&Sname!=null){
				stu.setSname(Sname);
			}
		}
		
		
		//  执行
					boolean flag3 = studentimpl.logion(stu);
					
					out.print(String.valueOf(flag3));
//		//执行
//		boolean falg;
//		try {
//			falg = studentimpl.logion(stu);
//			if(falg){
//				response.sendRedirect("user.do?opt=query");
//				
//			}else{
//				response.sendRedirect("User/Login.html");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			response.sendRedirect("Login.html");
//		}
		
		return;
		
		*/
		
	}

}
