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
import com.lx.bean.Suggest;
import com.lx.service.ReserveService;
import com.lx.service.SuggestService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@WebServlet("/SuggestServlet")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SuggestServlet() {
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
		
	
		
		
		   //Reserve reserve=new Reserve();
		   Suggest suggest=new Suggest();
		   
          // ReserveServise reserveServise = new ReserveServise(); 
		   SuggestService suggestService=new SuggestService();
          // List<Reserve> reservelist=null;
		   
        
           //Reserve reserve2=null;
	        Suggest suggest2=null;  
	        
		
			
			//查询所有
			if("queryAll".equals(opt)){
				// 存放集合内容
				List<Suggest> suggestlist= null;
				String page = request.getParameter("page");
				String rows = request.getParameter("limit");
				if (!"".equals(name) && name != null) {
					suggest.setName(name);
				}
				
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
				
				//查询所有信息默认分页
				suggestlist= suggestService.queryAllSuggest(pageBean, suggest); 
				//查询总记录数
				int total = suggestService.SuggestCount(suggest);
				
				JSONObject result = new JSONObject();
				
				

				JSONArray jsonArray = JSONArray.fromObject(suggestlist);
				result.put("code", 0);
				result.put("msg", "正在加载....");
				result.put("count", total);
				result.put("data", jsonArray);
				System.out.println(result.toString());
				 out.print(result);
				
				
				return;
			}
			
			
			//查询单个
			if("findById2".equals(opt)){
				//判断
				if (!"".equals(employee_id) && employee_id != null) {

					suggest.setEmployee_id(Integer.parseInt(employee_id));
				}
				//student2 = studentimpl.select(stu);
				suggest2=suggestService.select(suggest);
				
				
				if(suggest2!=null){
					
					
					request.setAttribute("suggest2", suggest2);
					//转发
					request.getRequestDispatcher("suggest/updateSuggest.jsp").forward(request, response);
					
				}
				
				return;
			}
			
			 if ("findById".equals(opt)) {
		        	

		        	if (!"".equals(employee_id) && employee_id != null) {

		        		suggest.setEmployee_id(Integer.parseInt(employee_id));
					}

		        	try {
		        		//users2=iUsers.findUserById(users);
		        		suggest2=suggestService.findSuggestById(suggest);
		                if(suggest2!=null) {
		                	
		                	request.setAttribute("suggest2", suggest2);
		                	
		                	request.getRequestDispatcher("suggest/Addsuggest.jsp").forward(request, response);
		                	//response.sendRedirect("UserServlet?opt=queryAll");	
		                }
		    			

		    		} catch (Exception e) {

		    			e.printStackTrace();
		    			response.sendRedirect("error.html");
		    		}
		        	return;
		        }
			 
			//修改
				if("upd".equals(opt)){
					//判断
					 if (!"".equals(name) && name != null) {
							

						 suggest.setName(name);
						}
						if (!"".equals(employee_id) && employee_id!= null) {

							suggest.setEmployee_id(Integer.parseInt(employee_id));
						}
											
						if (!"".equals(work_exper) && work_exper != null) {

							suggest.setWork_exper(work_exper);
						}
						if (!"".equals(reserveposition) && reserveposition != null) {

							suggest.setReserveposition(reserveposition);
						}
					JSONObject result = new JSONObject();
					//boolean flag = studentimpl.updateb(stu);
					
					boolean flag = suggestService.updateb(suggest);
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
						

                    	suggest.setName(name);
					}
					if (!"".equals(employee_id) && employee_id!= null) {

						suggest.setEmployee_id(Integer.parseInt(employee_id));
					}
										
					if (!"".equals(work_exper) && work_exper != null) {

						suggest.setWork_exper(work_exper);
					}
					if (!"".equals(reserveposition) && reserveposition != null) {

						suggest.setReserveposition(reserveposition);
					}
					
					JSONObject result = new JSONObject();
					boolean flag = suggestService.add(suggest);
					
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
						

						suggest.setName(name);
					}
					if (!"".equals(employee_id) && employee_id!= null) {

						suggest.setEmployee_id(Integer.parseInt(employee_id));
					}
										
					if (!"".equals(work_exper) && work_exper != null) {

						suggest.setWork_exper(work_exper);
					}
					if (!"".equals(reserveposition) && reserveposition != null) {

						suggest.setReserveposition(reserveposition);
					}

					try {
						// iUsers.addUsers(users);
						//reserveServise.addReserve(reserve);
						suggestService.addSuggest(suggest);
						response.sendRedirect("suggest/Suggest.jsp");

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
						suggest.setEmployee_id(Integer.parseInt(employee_id));
						
						suggestService.del(suggest);
						delNums = 1;
					}else{
						delNums = suggestService.SuggestDelete(delIds);
					}
					if (delNums > 0) {
						result.put("success", true);
						result.put("delNums", delNums);
						System.out.println("suggest 删除成功");
						
					} else {
						result.put("errorMsg", "删除失败");
						System.out.println("suggest 删除失败");
					}
					
					out.print(result);
					return;
				} 
			
	       }
	

}
