package com.it.ssm.controller;

import com.it.ssm.domain.Permission;
import com.it.ssm.domain.Role;
import com.it.ssm.service.PermissionService;
import com.it.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/27 16:58
 * @description：角色控制器
 * @modified By：
 * @version:     $
 */

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //查询数据
        List<Role> roleList = roleService.findAll();
        //生成modelandView
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("roleList", roleList);
        //编写前端页面
        modelAndView.setViewName("role-list");
        return  modelAndView;
    }

    /**
     * 维护用户角色关系
     * @param role
     * @return
     */
    @RequestMapping("/save")
    public String save(Role role){
        System.out.println("role-->"+role);
        roleService.save(role);
        return "redirect:/role/findAll";
    }

    /**
     * 添加权限到角色
     * @param roleId
     * @return
     */
    @RequestMapping("/addPermissionToRoleUI")
    public ModelAndView addPermissionToRoleUI(Long roleId){
        //查询数据
        //1 所有的权限
      List<Permission> permissionList =  permissionService.findAll();

        //2 查询已经拥有的权限  有一个角色id，可以查询出该角色下的所有权限
        Role role =   roleService.findById(roleId);
        //3 已经拥有的权限的id，拼接为一个字符串
        StringBuffer buffer = new StringBuffer();
        for (Permission permission:role.getPermissionList()) {
            buffer.append(",");
            buffer.append(permission.getId());
            buffer.append(",");
        }
        //生成modelandView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.addObject("str",buffer.toString());
        modelAndView.addObject("roleId",role.getId());
        //编写前端页面
        modelAndView.setViewName("role-permission-add");
        return  modelAndView;
    }

    /**
     * 添加权限到角色
     * @param roleId  当前用户的角色id
     * @param ids  当前角色对应的权限id
     * @return
     */
    @RequestMapping("/addPermissionsToRole")
    public String addPermissionsToRole(Long roleId,Long []ids){
         //保存
        roleService.addPermissionsToRole(roleId,ids);
        //查询全部
        return "redirect:/role/findAll";

    }
}
