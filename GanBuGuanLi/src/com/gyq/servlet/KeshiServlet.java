package com.gyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gyq.bean.PageBean;
import com.gyq.bean.keshi;
import com.gyq.bean.posinformation;
import com.gyq.service.Keshiimpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet({ "/KeshiServlet", "/ks.do" })
public class KeshiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KeshiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取页面上的值
		String opt = request.getParameter("opt");
		String Ks_no = request.getParameter("ks_no");
		String Ks_name = request.getParameter("ks_name");
		String Ks_prin = request.getParameter("ks_prin");
		String Ks_desc = request.getParameter("ks_desc");

		PrintWriter out = response.getWriter();
		// 创建对象
		keshi ks = new keshi();
		// service
		Keshiimpl ksimpl = new Keshiimpl();

//添加科室			
		if ("add".equals(opt)) {
			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}
			if (!"".equals(Ks_name) && Ks_name != null) {
				ks.setKs_name(Ks_name);
			}
			if (!"".equals(Ks_prin) && Ks_prin != null) {
				ks.setKs_prin(Ks_prin);
			}
			if (!"".equals(Ks_desc) && Ks_desc != null) {
				ks.setKs_desc(Ks_desc);
			}
			JSONObject result = new JSONObject();
			boolean flag = ksimpl.add(ks);

			if (flag) {
				result.put("success", "保存成功！！！");

			} else {
				result.put("success", false);
				result.put("errorMsg", "保存失败");
			}
			out.print(result);

			return;

		}

//删除科室
		if ("del".equals(opt)) {
			// 获取前端页面的id集合
			String delksId = request.getParameter("delArray");

			System.out.println("delksId--->" + delksId);
			JSONObject result = new JSONObject();
			int delNums = 0;
			// 获取前端页面的user_id
			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
				ksimpl.del(ks);
				delNums = 1;
			} else {
				delNums = ksimpl.KsDelete(delksId);
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
		if ("delById".equals(opt)) {
			int delNums = 0;
			// 获取前端页面的user_id
			// 判断
			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}

			ksimpl.del(ks);
			JSONObject result = new JSONObject();
			if (delNums > 0) {
				result.put("success", "删除成功!");
			} else {
				result.put("errorMsg", "删除失败");
			}

			out.print(result);
			return;
		}

//修改
		if ("upd".equals(opt)) {
			// 判断
			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}
			if (!"".equals(Ks_name) && Ks_name != null) {
				ks.setKs_name(Ks_name);
			}
			if (!"".equals(Ks_prin) && Ks_prin != null) {
				ks.setKs_prin(Ks_prin);
			}
			if (!"".equals(Ks_desc) && Ks_desc != null) {
				ks.setKs_desc(Ks_desc);
			}
			JSONObject result = new JSONObject();
			boolean flag = ksimpl.update(ks);

			if (flag) {
				out.print("修改成功!");

			} else {

				out.print("修改失败!");

			}

			return;
		}

		// 查询单个
		if ("findById".equals(opt)) {
			// 判断
			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}
				keshi keshi = ksimpl.select(ks);
				if (keshi != null) {

					request.setAttribute("keshi", keshi);
					// 转发
					request.getRequestDispatcher("post/updateKeshi.jsp").forward(request, response);

				}

				return;
			}
		
//查询			
		if ("queryAll".equals(opt)) {
			// 存放集合内容
			List<keshi> lists = null;
			String page = request.getParameter("page");
			String rows = request.getParameter("limit");

			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}

			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));

			// 查询所有信息默认分页
			lists = ksimpl.queryAllKs(pageBean, ks);
			// 查询总记录数
			int total = ksimpl.KsCount(ks);

			JSONObject result = new JSONObject();

			JSONArray jsonArray = JSONArray.fromObject(lists);
			result.put("code", 0);
			result.put("msg", "正在加载....");
			result.put("count", total);
			result.put("data", jsonArray);
			System.out.println(result.toString());
			out.print(result);

			return;
		}

	}

}
