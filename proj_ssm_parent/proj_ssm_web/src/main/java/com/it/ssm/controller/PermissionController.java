package com.it.ssm.controller;

import com.it.ssm.domain.Permission;
import com.it.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.MarshalledObject;
import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/27 17:50
 * @description：权限控制器
 * @modified By：
 * @version:     $
 */

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //查询数据
        List<Permission> permissionList = permissionService.findAll();
        //生成modelandview
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("permissionList",permissionList);
        //添加前端页面
        modelAndView.setViewName("permission-list");
        return  modelAndView;
    }

    /**
     *查询所有的父权限返回
     * @return
     */
    @RequestMapping("/findAllParentPermission")
    public ModelAndView findById(){
        //查询数据
        List<Permission> permissionList = permissionService.findAllParentPermission();
        //生成modelandview
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        //添加数据
        modelAndView.addObject("permissionList",permissionList);
        //添加前端页面
        modelAndView.setViewName("permission-add");
        return  modelAndView;
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @RequestMapping("/save")
    public String save(Permission permission){
        System.out.println("permission-->"+permission);
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }

}
