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
		// ��������ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// ��ȡҳ���ϵ�ֵ
		String opt = request.getParameter("opt");
		String Ks_no = request.getParameter("ks_no");
		String Ks_name = request.getParameter("ks_name");
		String Ks_prin = request.getParameter("ks_prin");
		String Ks_desc = request.getParameter("ks_desc");

		PrintWriter out = response.getWriter();
		// ��������
		keshi ks = new keshi();
		// service
		Keshiimpl ksimpl = new Keshiimpl();

//��ӿ���			
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
				result.put("success", "����ɹ�������");

			} else {
				result.put("success", false);
				result.put("errorMsg", "����ʧ��");
			}
			out.print(result);

			return;

		}

//ɾ������
		if ("del".equals(opt)) {
			// ��ȡǰ��ҳ���id����
			String delksId = request.getParameter("delArray");

			System.out.println("delksId--->" + delksId);
			JSONObject result = new JSONObject();
			int delNums = 0;
			// ��ȡǰ��ҳ���user_id
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
				result.put("errorMsg", "ɾ��ʧ��");
			}

			out.print(result);
			return;
		}
//ɾ����������
		if ("delById".equals(opt)) {
			int delNums = 0;
			// ��ȡǰ��ҳ���user_id
			// �ж�
			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}

			ksimpl.del(ks);
			JSONObject result = new JSONObject();
			if (delNums > 0) {
				result.put("success", "ɾ���ɹ�!");
			} else {
				result.put("errorMsg", "ɾ��ʧ��");
			}

			out.print(result);
			return;
		}

//�޸�
		if ("upd".equals(opt)) {
			// �ж�
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
				out.print("�޸ĳɹ�!");

			} else {

				out.print("�޸�ʧ��!");

			}

			return;
		}

		// ��ѯ����
		if ("findById".equals(opt)) {
			// �ж�
			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}
				keshi keshi = ksimpl.select(ks);
				if (keshi != null) {

					request.setAttribute("keshi", keshi);
					// ת��
					request.getRequestDispatcher("post/updateKeshi.jsp").forward(request, response);

				}

				return;
			}
		
//��ѯ			
		if ("queryAll".equals(opt)) {
			// ��ż�������
			List<keshi> lists = null;
			String page = request.getParameter("page");
			String rows = request.getParameter("limit");

			if (!"".equals(Ks_no) && Ks_no != null) {
				ks.setKs_no(Integer.parseInt(Ks_no));
			}

			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));

			// ��ѯ������ϢĬ�Ϸ�ҳ
			lists = ksimpl.queryAllKs(pageBean, ks);
			// ��ѯ�ܼ�¼��
			int total = ksimpl.KsCount(ks);

			JSONObject result = new JSONObject();

			JSONArray jsonArray = JSONArray.fromObject(lists);
			result.put("code", 0);
			result.put("msg", "���ڼ���....");
			result.put("count", total);
			result.put("data", jsonArray);
			System.out.println(result.toString());
			out.print(result);

			return;
		}

	}

}
