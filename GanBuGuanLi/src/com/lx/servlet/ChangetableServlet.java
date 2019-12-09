package com.lx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lx.bean.Changetable;
import com.lx.bean.PageBean;
import com.lx.service.ChangetableService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@WebServlet("/ChangetableServlet")
public class ChangetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ChangetableServlet() {
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
		
	
		
		
		  
		   //Suggest suggest=new Suggest();
		   Changetable changetable=new Changetable();
       
		  // SuggestServise suggestServise=new SuggestServise();
		   ChangetableService changetableService = new ChangetableService();
		   
		  // List<Suggest> suggestlist= null;
           List<Changetable> changelist=null;
          
	        //Suggest suggest2=null;  
           Changetable changetable2=null;
           
			if ("queryAll".equals(opt)) {
				
				String rows = request.getParameter("limit");
				String page = request.getParameter("page");
				if (!"".equals(name) && name != null) {
					changetable.setName(name);
				}
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
			
				changelist= changetableService.queryAllchangetable(pageBean, changetable);
					
					//int total = reserveServise.ReserveCount(reserve);
				  int total = changetableService.ChangetableCount(changetable);
						
						
				
                     JSONObject result = new JSONObject();
					
                     
                     
					JSONArray jsonArray = JSONArray.fromObject(changelist);
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

					changetable.setEmployee_id(Integer.parseInt(employee_id));
				}
				//student2 = studentimpl.select(stu);
				changetable2=  changetableService.select(changetable2);
				
				
				if(changetable2!=null){
					
					
					request.setAttribute("changetable2", changetable2);
					//转发
					request.getRequestDispatcher("change/updateChangetable.jsp").forward(request, response);
					
				}
				
				return;
			}
			 if ("findById".equals(opt)) {
		        	

		        	if (!"".equals(employee_id) && employee_id != null) {

		        		changetable.setEmployee_id(Integer.parseInt(employee_id));
					}

		        	try {
		        		
		        		//suggest2=suggestServise.findSuggestById(suggest);
		        		changetable2=changetableService.findchangetableById(changetable);
		                if(changetable2!=null) {
		                	
		                	request.setAttribute("changetable2", changetable2);
		                	
		                	request.getRequestDispatcher("change/AddChange.jsp").forward(request, response);
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
							

						 changetable.setName(name);
						}
						if (!"".equals(employee_id) && employee_id!= null) {

							changetable.setEmployee_id(Integer.parseInt(employee_id));
						}
											
						if (!"".equals(work_exper) && work_exper != null) {

							changetable.setWork_exper(work_exper);
						}
						if (!"".equals(reserveposition) && reserveposition != null) {

							changetable.setReserveposition(reserveposition);
						}
					JSONObject result = new JSONObject();
					//boolean flag = studentimpl.updateb(stu);
					
					boolean flag = changetableService.updateb(changetable);
					if(flag){
						out.print("修改成功!");						
					}else{
						
						out.print("修改失败!");
						
					}
					
					return;
				}
			 
			 if ("add".equals(opt)) {
				 
					
					if (!"".equals(name) && name != null) {
				
						changetable.setName(name);
					}
					if (!"".equals(employee_id) && employee_id!= null) {

						changetable.setEmployee_id(Integer.parseInt(employee_id));
					}
										
					if (!"".equals(work_exper) && work_exper != null) {

						changetable.setWork_exper(work_exper);
					}
					if (!"".equals(reserveposition) && reserveposition != null) {

						changetable.setReserveposition(reserveposition);
					}

					try {
						
						//suggestServise.addSuggest(suggest);
						changetableService.addchangetable(changetable);
						response.sendRedirect("change/Change2.jsp");

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						response.sendRedirect("error.html");
					}
					return;
				}
			//添加功能
				if("add2".equals(opt)){
					// "" null
					
							
					//判断
					if (!"".equals(name) && name != null) {
						
						changetable.setName(name);
					}
					if (!"".equals(employee_id) && employee_id!= null) {

						changetable.setEmployee_id(Integer.parseInt(employee_id));
					}
										
					if (!"".equals(work_exper) && work_exper != null) {

						changetable.setWork_exper(work_exper);
					}
					if (!"".equals(reserveposition) && reserveposition != null) {

						changetable.setReserveposition(reserveposition);
					}
					
					JSONObject result = new JSONObject();
					boolean flag =changetableService.add(changetable);
					
					if(flag){
						result.put("success", "保存成功！！！");
						
					}else{
						result.put("success", false);
						result.put("errorMsg", "保存失败");
					}
					out.print(result);
					
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
						changetable.setEmployee_id(Integer.parseInt(employee_id));
						
						changetableService.del(changetable);
						delNums = 1;
					}else{;
						delNums = changetableService.ChangetableDelete(delIds); 
					}
					if (delNums > 0) {
						result.put("success", true);
						result.put("delNums", delNums);
						System.out.println("Changetable 删除成功");
						
					} else {
						result.put("errorMsg", "删除失败");
						System.out.println("Changetable 删除失败");
					}
					
				
					return;
				} 
			
	       }
	

}
