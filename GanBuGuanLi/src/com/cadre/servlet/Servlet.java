package com.cadre.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cadre.bean.Cadre;
import com.cadre.bean.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.cadre.service.Service;
@WebServlet({ "/Servlet", "/cadre.do" })
public class Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String opt = request.getParameter("opt");
		String employee_id=request.getParameter("employee_id");
		String name=request.getParameter("name") ;
		String nationality=request.getParameter("nationality");
		String cur_loca=request.getParameter("cur_loca") ;
		String nation=request.getParameter("nation");
		String loca_of_resid=request.getParameter("loca_of_resid") ;
		String mari_status=request.getParameter("mari_status");
		String heal_condi=request.getParameter("heal_condi") ;
		String age=request.getParameter("age");
		String sex=request.getParameter("sex") ;
		String high_edu=request.getParameter("high_edu");
		String poli_lands=request.getParameter("poli_lands") ;
		String school=request.getParameter("school");
		String prof=request.getParameter("prof") ;
		String certificate=request.getParameter("certificate");
		String work_exper=request.getParameter("work_exper") ;
		String memb_fam=request.getParameter("memb_fam");
		String english=request.getParameter("english") ;
		String self_evalu=request.getParameter("self_evalu");
		String hobbies=request.getParameter("hobbies") ;
		String entry_time=request.getParameter("entry_time");
		String leave_time=request.getParameter("leave_time") ;
		String asse_status=request.getParameter("asse_status");
		String viola_of_discip=request.getParameter("viola_of_discip") ;
		String audit_status=request.getParameter("audit_status");
		String departure=request.getParameter("departure") ;
		String langu_ability=request.getParameter("langu_ability");
		String ks_id=request.getParameter("ks_id") ;
		String admin_id=request.getParameter("admin_id");
		String reserveposition=request.getParameter("reserveposition");
		Cadre cadre =new Cadre();
		Service service =new Service() ;
		PrintWriter out = response.getWriter();
		if("add".equals(opt)) {
			if (!"".equals(employee_id) && employee_id != null) {
				cadre.setEmployee_id(employee_id);
			}
			if (!"".equals(name) && name != null) {
				cadre.setName(name);
			}
			if (!"".equals(nationality) && nationality != null) {
				cadre.setNationality(nationality);
			}
			if (!"".equals(cur_loca) && cur_loca != null) {
				cadre.setCur_loca(cur_loca);
			}
			if (!"".equals(nation) && nation != null) {
				cadre.setNation(nation);
			}
			if (!"".equals(loca_of_resid) && loca_of_resid != null) {
				cadre.setLoca_of_resid(loca_of_resid);
			}if (!"".equals(mari_status) && mari_status != null) {
				cadre.setMari_status(mari_status);
			}if (!"".equals(heal_condi) && heal_condi != null) {
				cadre.setHeal_condi(heal_condi);
			}if (!"".equals(age) && age != null) {
				cadre.setAge(age);
			}
			if (!"".equals(sex) && sex != null) {
				cadre.setSex(sex);
			}
			if (!"".equals(high_edu) && high_edu != null) {
				cadre.setHigh_edu(high_edu);
			}
			if (!"".equals(poli_lands) && poli_lands != null) {
				cadre.setPoli_lands(poli_lands);
			}
			if (!"".equals(school) && school != null) {
				cadre.setSchool(school);
			}
			if (!"".equals(prof) && prof != null) {
				cadre.setProf(prof);
			}
			if (!"".equals(certificate) && certificate != null) {
				cadre.setCertificate(certificate);
			}
			if (!"".equals(work_exper) && work_exper != null) {
				cadre.setWork_exper(work_exper);
			}
			if (!"".equals(memb_fam) && memb_fam != null) {
				cadre.setMemb_fam(memb_fam);
			}
			if (!"".equals(english) && english != null) {
				cadre.setEnglish(english);
			}
			if (!"".equals(self_evalu) && self_evalu != null) {
				cadre.setSelf_evalu(self_evalu);
			}
			if (!"".equals(hobbies) && hobbies != null) {
				cadre.setHobbies(hobbies);
			}
			if (!"".equals(entry_time) && entry_time != null) {
				cadre.setEntry_time(entry_time);
			}
			if (!"".equals(leave_time) && leave_time != null) {
				cadre.setLeave_time(leave_time);
			}
			if (!"".equals(asse_status) && asse_status != null) {
				cadre.setAsse_status(asse_status);
			}
			if (!"".equals(viola_of_discip) && viola_of_discip != null) {
				cadre.setViola_of_discip(viola_of_discip);
			}
			if (!"".equals(audit_status) && audit_status != null) {
				cadre.setAudit_status(audit_status);
			}
			if (!"".equals(departure) && departure != null) {
				cadre.setDeparture(departure);
			}
			if (!"".equals(langu_ability) && langu_ability != null) {
				cadre.setLangu_ability(langu_ability);
			}
			if (!"".equals(ks_id) && ks_id != null) {
				cadre.setKs_id(ks_id);
			}
			if (!"".equals(admin_id) && admin_id != null) {
				cadre.setAdmin_id(admin_id);
			}
			if (!"".equals(reserveposition) && reserveposition!= null) {
				cadre.setReserveposition(reserveposition);
			}
			boolean flag=service.add(cadre);
			JSONObject result = new JSONObject();
			if (flag) {
				result.put("success", "保存成功！！！");
			} else {
				result.put("success", false);
				result.put("errorMsg", "保存失败");
			}
			out.print(result);
			return;
		}
		if("del".equals(opt)) {
			String delIds = request.getParameter("delArray");
			JSONObject result = new JSONObject();
			int delNums = 0;
			if (!"".equals(employee_id) && employee_id != null) {
				cadre.setEmployee_id(employee_id);
				System.out.println(employee_id);
				System.out.println(service.del(cadre));
				delNums = 1;
			} else {
				delNums = service.delarray(delIds);
				System.out.println(delNums);
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
			cadre.setEmployee_id(employee_id);
			Cadre cadre2= service.findbyid(cadre);
			request.setAttribute("cadre2", cadre2);
			System.out.println(cadre2);
			request.getRequestDispatcher("updatecadre.jsp").forward(request, response);		
			return;
		}
		if("upd".equals(opt)) {
			if (!"".equals(employee_id) && employee_id != null) {
				cadre.setEmployee_id(employee_id);
			}
			if (!"".equals(name) && name != null) {
				cadre.setName(name);
			}
			if (!"".equals(nationality) && nationality != null) {
				cadre.setNationality(nationality);
			}
			if (!"".equals(cur_loca) && cur_loca != null) {
				cadre.setCur_loca(cur_loca);
			}
			if (!"".equals(nation) && nation != null) {
				cadre.setNation(nation);
			}
			if (!"".equals(loca_of_resid) && loca_of_resid != null) {
				cadre.setLoca_of_resid(loca_of_resid);
			}if (!"".equals(mari_status) && mari_status != null) {
				cadre.setMari_status(mari_status);
			}if (!"".equals(heal_condi) && heal_condi != null) {
				cadre.setHeal_condi(heal_condi);
			}if (!"".equals(age) && age != null) {
				cadre.setAge(age);
			}
			if (!"".equals(sex) && sex != null) {
				cadre.setSex(sex);
			}
			if (!"".equals(high_edu) && high_edu != null) {
				cadre.setHigh_edu(high_edu);
			}
			if (!"".equals(poli_lands) && poli_lands != null) {
				cadre.setPoli_lands(poli_lands);
			}
			if (!"".equals(school) && school != null) {
				cadre.setSchool(school);
			}
			if (!"".equals(prof) && prof != null) {
				cadre.setProf(prof);
			}
			if (!"".equals(certificate) && certificate != null) {
				cadre.setCertificate(certificate);
			}
			if (!"".equals(work_exper) && work_exper != null) {
				cadre.setWork_exper(work_exper);
			}
			if (!"".equals(memb_fam) && memb_fam != null) {
				cadre.setMemb_fam(memb_fam);
			}
			if (!"".equals(english) && english != null) {
				cadre.setEnglish(english);
			}
			if (!"".equals(self_evalu) && self_evalu != null) {
				cadre.setSelf_evalu(self_evalu);
			}
			if (!"".equals(hobbies) && hobbies != null) {
				cadre.setHobbies(hobbies);
			}
			if (!"".equals(entry_time) && entry_time != null) {
				cadre.setEntry_time(entry_time);
			}
			if (!"".equals(leave_time) && leave_time != null) {
				cadre.setLeave_time(leave_time);
			}
			if (!"".equals(asse_status) && asse_status != null) {
				cadre.setAsse_status(asse_status);
			}
			if (!"".equals(viola_of_discip) && viola_of_discip != null) {
				cadre.setViola_of_discip(viola_of_discip);
			}
			if (!"".equals(audit_status) && audit_status != null) {
				cadre.setAudit_status(audit_status);
			}
			if (!"".equals(departure) && departure != null) {
				cadre.setDeparture(departure);
			}
			if (!"".equals(langu_ability) && langu_ability != null) {
				cadre.setLangu_ability(langu_ability);
			}
			if (!"".equals(ks_id) && ks_id != null) {
				cadre.setKs_id(ks_id);
			}
			if (!"".equals(admin_id) && admin_id != null) {
				cadre.setAdmin_id(admin_id);
			}
			if (!"".equals(reserveposition) && reserveposition!= null) {
				cadre.setReserveposition(reserveposition);
			}
			boolean flag=service.update(cadre);
			JSONObject result = new JSONObject();
			if (flag) {
				result.put("success", "修改成功！！！");
			} else {
				result.put("success", false);
				result.put("errorMsg", "修改失败");
			}
			out.print(result);
			return;
		}
		if("upd2".equals(opt)) {
			if (!"".equals(employee_id) && employee_id != null) {
				cadre.setEmployee_id(employee_id);
			}
			
			if (!"".equals(work_exper) && work_exper != null) {
				cadre.setWork_exper(work_exper);
			}
			if (!"".equals(reserveposition) && reserveposition != null) {
				cadre.setReserveposition(reserveposition);
			}
			
			boolean flag=service.update2(cadre);
			JSONObject result = new JSONObject();
			if (flag) {
				result.put("success", "修改成功！！！");
			} else {
				result.put("success", false);
				result.put("errorMsg", "修改失败");
			}
			out.print(result);
			response.sendRedirect("queryAllcadre.jsp");
			return;
		}
		if ("queryAll".equals(opt)) {
			List<Cadre> lists = null;
			String page = request.getParameter("page");
			String rows = request.getParameter("limit");
			if (!"".equals(employee_id) && employee_id != null) {
				cadre.setEmployee_id(employee_id);
			}
			if (!"".equals(name) && name != null) {
				cadre.setName(name);
			}
			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
			lists = service.query(pageBean, cadre);
			int total = service.Count(cadre);
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
