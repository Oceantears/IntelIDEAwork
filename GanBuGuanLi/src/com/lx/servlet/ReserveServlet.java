package com.lx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.lx.bean.PageBean;
import com.lx.bean.Reserve;
import com.lx.service.ReserveService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ReserveServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String opt = request.getParameter("opt");

		String employee_id = request.getParameter("employee_id");	
		String work_exper = request.getParameter("work_exper");
		String reserveposition=request.getParameter("reserveposition");
		String name=request.getParameter("name");
		

		
		
		   Reserve reserve=new Reserve();	          
           ReserveService reserveService = new ReserveService();           
           List<Reserve> reservelist=null;
        
           Reserve reserve2=null;
	          
           
           
	        
			if ("queryAll".equals(opt)) {
				if (!"".equals(name) && name != null) {
					reserve.setName(name);
				}
				String rows = request.getParameter("limit");
				String page = request.getParameter("page");
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
			
					reservelist= reserveService.queryAllReserve(pageBean, reserve);
					
					int total = reserveService.ReserveCount(reserve);
					
					// request.setAttribute("reservelist", reservelist);
                     JSONObject result = new JSONObject();
					
                     
                     
					JSONArray jsonArray = JSONArray.fromObject(reservelist);
					result.put("code", 0);
					result.put("msg", "正在加载....");
					result.put("count", total);
					result.put("data", jsonArray);
					System.out.println(result.toString());
					 out.print(result);
				
				return;
			
			}

			 if ("findById".equals(opt)) {
		        	

		        	if (!"".equals(employee_id) && employee_id != null) {

		        		reserve.setEmployee_id(Integer.parseInt(employee_id));
					}
//		        	if(!"".equals(get_promoted) && get_promoted != null) {
//
//		        		reserve.setGet_promoted(get_promoted);
//					}
		        	try {
		        		//users2=iUsers.findUserById(users);
		        		reserve2=reserveService.findReserveById(reserve);
		                if(reserve2!=null) {
		                	
		                	request.setAttribute("reserve2", reserve2);
		                	
		                	request.getRequestDispatcher("reserve/Addreserve.jsp").forward(request, response);
		                	//response.sendRedirect("UserServlet?opt=queryAll");	
		                }
		    			

		    		} catch (Exception e) {

		    			e.printStackTrace();
		    			response.sendRedirect("error.html ");
		    		}
		        	return;
		        }
			 
			//查询单个
				if("findById2".equals(opt)){
					//判断
					if (!"".equals(employee_id) && employee_id != null) {

		        		reserve.setEmployee_id(Integer.parseInt(employee_id));
					}
					//student2 = studentimpl.select(stu);
					reserve2=reserveService.select(reserve);
					
					
					if(reserve2!=null){
						
						
						request.setAttribute("reserve2", reserve2);
						//转发
						request.getRequestDispatcher("reserve/updateReserve.jsp").forward(request, response);
						
					}
					
					return;
				}
				
				
				//修改
				if("upd".equals(opt)){
					//判断
					 if (!"".equals(name) && name != null) {
							

							reserve.setName(name);
						}
						if (!"".equals(employee_id) && employee_id!= null) {

							reserve.setEmployee_id(Integer.parseInt(employee_id));
						}
											
						if (!"".equals(work_exper) && work_exper != null) {

							reserve.setWork_exper(work_exper);
						}
						if (!"".equals(reserveposition) && reserveposition != null) {

							reserve.setReserveposition(reserveposition);
						}
					JSONObject result = new JSONObject();
					//boolean flag = studentimpl.updateb(stu);
					boolean flag = reserveService.updateb(reserve);
					if(flag){
						out.print("修改成功!");
						
						
					}else{
						
						out.print("修改失败!");
						
					}
					
					return;
				}
			//添加功能
				if("add2".equals(opt)){
					// "" null
					
							
					//判断
                    if (!"".equals(name) && name != null) {
						

						reserve.setName(name);
					}
					if (!"".equals(employee_id) && employee_id!= null) {

						reserve.setEmployee_id(Integer.parseInt(employee_id));
					}
										
					if (!"".equals(work_exper) && work_exper != null) {

						reserve.setWork_exper(work_exper);
					}
					if (!"".equals(reserveposition) && reserveposition != null) {

						reserve.setReserveposition(reserveposition);
					}
					
					JSONObject result = new JSONObject();
					boolean flag = reserveService.add(reserve);
					
					if(flag){
						result.put("success", "保存成功！！！");
						
					}else{
						result.put("success", false);
						result.put("errorMsg", "保存失败");
					}
					out.print(result);
					
					return;
					
					
				}
			 
			 
			 if ("add".equals(opt)) {
				 
					
					if (!"".equals(name) && name != null) {
						

						reserve.setName(name);
					}
					if (!"".equals(employee_id) && employee_id!= null) {

						reserve.setEmployee_id(Integer.parseInt(employee_id));
					}
										
					if (!"".equals(work_exper) && work_exper != null) {

						reserve.setWork_exper(work_exper);
					}
					if (!"".equals(reserveposition) && reserveposition != null) {

						reserve.setReserveposition(reserveposition);
					}

					try {
						// iUsers.addUsers(users);
						reserveService.addReserve(reserve);
						
						response.sendRedirect("reserve/Reserve.jsp");

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						response.sendRedirect("error.html");
					}
					return;
				}
			 
			 
			 
			 
			 //删除（单个和多个）
			 if("del".equals(opt)){
					//获取前端页面的id集合
					String delIds = request.getParameter("delArray");
					
		              System.out.println("delIds--->"+delIds);
					JSONObject result = new JSONObject();
					int delNums = 0;
					//获取前端页面的user_id
					if(!"".equals(employee_id)&& employee_id!=null){
						reserve.setEmployee_id(Integer.parseInt(employee_id));
						
						reserveService.del(reserve);
						delNums = 1;
					}else{
						delNums = reserveService.ReserveDelete(delIds);
					}
					if (delNums > 0) {
						result.put("success", true);
						result.put("delNums", delNums);
						System.out.println("Reserve 删除成功");
						
					} else {
						result.put("errorMsg", "删除失败");
						System.out.println("Reserve 删除失败");
					}
					
				
					return;
				} 
			 
			 
			 
			 if("delById".equals(opt)){
					int delNums = 0;
					//获取前端页面的user_id
					//判断
					if (!"".equals(employee_id) && employee_id!= null) {

						reserve.setEmployee_id(Integer.parseInt(employee_id));
					}
				
					        //studentimpl.del(stu);
					reserveService.del(reserve);
					
					JSONObject result = new JSONObject();
					if (delNums > 0) {
						result.put("success", "删除成功!");
					} else {
						result.put("errorMsg", "删除失败");
					}
					
					out.print(result);
					return;
				}
			
	       }
	

}
