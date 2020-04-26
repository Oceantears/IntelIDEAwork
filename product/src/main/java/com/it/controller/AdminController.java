package com.it.controller;/*
@author Laotian
@create 2020-03-10-12:07
*/

import com.it.domain.Admin;
import com.it.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 管理web
 */
@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    /**
     * 查询
     * @param admin
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/queryAllAdmin")
    @ResponseBody
    public Map<String,Object> queryAllAdmin(Admin admin, int limit, int page){

        Map<String,Object> map=new HashMap<>();
        List<Admin> admins = adminService.queryAll(admin,(page-1)*limit,limit);
        /*for (Admin admin1 : admins) {
            System.out.println(admin1);
        }*/
        int count = adminService.count(admin);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",admins);
        System.out.println("map-->"+map);
        return map;
    }

    @RequestMapping("/toqueryAllAdmin")
    public String toqueryAllAdmin(){
        return "/admin/queryAllAdmin";
    }

    /**
     * 保存
     * @param admin
     * @return
     */
    @RequestMapping("/saveAdmin")
    public String saveAdmin(Admin admin){
        try{
            adminService.saveAdmin(admin);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/tosaveAdmin")
    public String tosaveAdmin(){
        return "admin/saveAdmin";
    }

    /**
     * 删除
     * @param admin
     * @return
     */
    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(Admin admin){
        try{
            adminService.deleteAdmin(admin);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/admin/queryAllAdmin";
    }

    @RequestMapping("/adminDelete")
    @ResponseBody
    public String adminDelete(String delArray){
        System.out.println(delArray+"aaaaaaaaaa");
        adminService.adminDelete(delArray);
        return  "redirect:/abmin/queryAllAdmin";

    }

    /**
     * 登录
     * @param model
     * @param admin
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model, Admin admin) {

        Admin admin1 = null;
        try {

            admin1 = adminService.findByNameAndPassword(admin);
            System.out.println(admin);
            if (admin1!= null) {
                model.addAttribute("admin1",admin1);
                return "forward:/menu.jsp";
            }else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";

        }

    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "admin/login";
    }

    /**
     * 修改
     * @param admin
     * @return
     */
    @RequestMapping("/updateAdmin")
    public String updateAdmin(Admin admin){
        try{
            System.out.println(admin);
            adminService.updateAdmin(admin);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/toupdateAdmin")
    public String toupdateAdmin(){
        return "admin/updateAdmin";
    }

}
