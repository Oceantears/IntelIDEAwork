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
	        
		
			
			//��ѯ����
			if("queryAll".equals(opt)){
				// ��ż�������
				List<Suggest> suggestlist= null;
				String page = request.getParameter("page");
				String rows = request.getParameter("limit");
				if (!"".equals(name) && name != null) {
					suggest.setName(name);
				}
				
				PageBean pageBean = new PageBean(Integer.parseInt(page),
						Integer.parseInt(rows));
				
				//��ѯ������ϢĬ�Ϸ�ҳ
				suggestlist= suggestService.queryAllSuggest(pageBean, suggest); 
				//��ѯ�ܼ�¼��
				int total = suggestService.SuggestCount(suggest);
				
				JSONObject result = new JSONObject();
				
				

				JSONArray jsonArray = JSONArray.fromObject(suggestlist);
				result.put("code", 0);
				result.put("msg", "���ڼ���....");
				result.put("count", total);
				result.put("data", jsonArray);
				System.out.println(result.toString());
				 out.print(result);
				
				
				return;
			}
			
			
			//��ѯ����
			if("findById2".equals(opt)){
				//�ж�
				if (!"".equals(employee_id) && employee_id != null) {

					suggest.setEmployee_id(Integer.parseInt(employee_id));
				}
				//student2 = studentimpl.select(stu);
				suggest2=suggestService.select(suggest);
				
				
				if(suggest2!=null){
					
					
					request.setAttribute("suggest2", suggest2);
					//ת��
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
			 
			//�޸�
				if("upd".equals(opt)){
					//�ж�
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
						out.print("�޸ĳɹ�!");
						
						
					}else{
						
						out.print("�޸�ʧ��!");
						
					}
					
					return;
				}
				
				//��ӹ���
				if("add2".equals(opt)){
					// "" null
					
							
					//�ж�
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
						result.put("success", "����ɹ�������");
						
					}else{
						result.put("success", false);
						result.put("errorMsg", "����ʧ��");
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
			 
			 //ɾ���������Ͷ����
			 if("del".equals(opt)){
					//��ȡǰ��ҳ���id����
					String delIds = request.getParameter("delArray");
					
		              System.out.println("delIds--->"+delIds);
					JSONObject result = new JSONObject();
					int delNums = 0;
					//��ȡǰ��ҳ���user_id
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
						System.out.println("suggest ɾ���ɹ�");
						
					} else {
						result.put("errorMsg", "ɾ��ʧ��");
						System.out.println("suggest ɾ��ʧ��");
					}
					
					out.print(result);
					return;
				} 
			
	       }
	

}
