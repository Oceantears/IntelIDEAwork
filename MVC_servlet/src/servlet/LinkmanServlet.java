package servlet;

import com.it.bean.Cst_linkman;
import com.it.service.cst_linkman.Cst_linkmanImpl;
import com.it.service.cst_linkman.Icst_linkman;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LinkmanServlet")
public class LinkmanServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.处理乱码
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("");
		//2.获取页面信息，获取opt
		String opt=request.getParameter("opt");
		String lkm_id=request.getParameter("lkm_id");
		String lkm_name=request.getParameter("lkm_name");
		String lkm_cust_id=request.getParameter("lkm_cust_id");
		String lkm_gender=request.getParameter("lkm_gender");
		String lkm_phone=request.getParameter("lkm_phone");
		String lkm_mobile=request.getParameter("lkm_mobile");
		String lkm_email=request.getParameter("lkm_email");
		String lkm_qq=request.getParameter("lkm_qq");
		String lkm_position=request.getParameter("lkm_position");
		String lkm_memo=request.getParameter("lkm_memo");

		Cst_linkman linkman=new Cst_linkman();
		Icst_linkman cst_linkman=new Cst_linkmanImpl();

		List<Cst_linkman> linkmanList=null;

		if("lkm_add".equals(opt)){

			return;
		}
		if("lkm_del".equals(opt)){

			return;
		}
		if("lkm_upd".equals(opt)){

			return;
		}
		if("lkm_findById".equals(opt)){

			return;
		}

		if("lkm_queryAll".equals(opt)){
			try {
				linkmanList=cst_linkman.queryAllLinkman(linkman);
				System.out.println("============lkm_queryAll===============>"+linkmanList.size());
				//储存数据到request中
				request.setAttribute("linkmanList",linkmanList);
				//跳转
				request.getRequestDispatcher("linkman/queryAllLkm.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.html");
			}

			return;
		}
	}
}
