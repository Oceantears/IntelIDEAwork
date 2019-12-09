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
		//��������ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡҳ���ϵ�ֵ
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
		//��������
		posinformation post=new posinformation();
		//service
		Postimpl postimpl=new Postimpl();
		
		
		
		//��ӹ���
		if("add".equals(opt)){
			// "" null
			//�ж�
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
				result.put("success", "����ɹ�������");
				
			}else{
				result.put("success", false);
				result.put("errorMsg", "����ʧ��");
			}
			out.print(result);
			
			return;
			
			
		}
		
		
	
		//��ѯ����
				if("findById".equals(opt)){
					//�ж�
					if(!"".equals(Job_no)&&Job_no!=null){
						post.setJob_no(Job_no);
					}
					posinformation post2 = postimpl.select(post);
					
					if(post2!=null){
						
						
						request.setAttribute("post2", post2);
						//ת��
						request.getRequestDispatcher("post/updatepost.jsp").forward(request, response);
						
					}
					
					return;
				}
				
		//�޸�
				if("upd".equals(opt)){
					//�ж�
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
						out.print("�޸ĳɹ�!");
						
						
					}else{
						
						out.print("�޸�ʧ��!");
						
					}
					
					return;
				}
				
//ɾ������
				if("del".equals(opt)){
					//��ȡǰ��ҳ���id����
					String delIds = request.getParameter("delArray");
					
		              System.out.println("delIds--->"+delIds);
					JSONObject result = new JSONObject();
					int delNums = 0;
					//��ȡǰ��ҳ���user_id
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
						result.put("errorMsg", "ɾ��ʧ��");
					}
					
					out.print(result);
					return;
				}
		
		//ɾ����������
		if("delById".equals(opt)){
			int delNums = 0;
			//��ȡǰ��ҳ���user_id
			//�ж�
			if(!"".equals(Job_no)&&Job_no!=null){
				post.setJob_no(Job_no);
			}
		
			        postimpl.del(post);
			JSONObject result = new JSONObject();
			if (delNums > 0) {
				result.put("success", "ɾ���ɹ�!");
			} else {
				result.put("errorMsg", "ɾ��ʧ��");
			}
			
			out.print(result);
			return;
		}
		//��ѯ����
				if("queryAll".equals(opt)){
					// ��ż�������
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
					
					//��ѯ������ϢĬ�Ϸ�ҳ
					lists = postimpl.queryAllPost(pageBean, post);
					//��ѯ�ܼ�¼��
					int total =postimpl.postCount(post);
					
					JSONObject result = new JSONObject();
					
					

					JSONArray jsonArray = JSONArray.fromObject(lists);
					result.put("code", 0);
					result.put("msg", "���ڼ���....");
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
		//��½
		//�жϡ�����null
		if("login".equals(opt)){
			if(!"".equals(Sno)&&Sno!=null){
				stu.setJob_no(Sno);
			}
			if(!"".equals(Sname)&&Sname!=null){
				stu.setSname(Sname);
			}
		}
		
		
		//  ִ��
					boolean flag3 = studentimpl.logion(stu);
					
					out.print(String.valueOf(flag3));
//		//ִ��
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
