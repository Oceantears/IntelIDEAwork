package com.it.ssm.controller;

import com.it.ssm.domain.Role;
import com.it.ssm.domain.SysUser;
import com.it.ssm.service.RoleService;
import com.it.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/27 9:21
 * @description：用户模块
 * @modified By：
 * @version:     $
 */

@Controller
@RequestMapping("/user")
@Secured({"ROLE_管理员","ROLE_超级管理员"})
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //查询数据
        List<SysUser> userList = userService.findAll();
        //生成视图
        ModelAndView modelAndView = new ModelAndView();
        //存数据
        modelAndView.addObject("userList",userList);
        //设置前端页面
        modelAndView.setViewName("user-list");
        return  modelAndView;
    }

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @RequestMapping("/save")
    public String save(SysUser sysUser){
        System.out.println("sysUser-->"+sysUser);
        userService.save(sysUser);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/details")
    public ModelAndView details(long id){
        SysUser sysUser =  userService.findById(id);
        //生成视图
        ModelAndView modelAndView = new ModelAndView();
        //存数据
        modelAndView.addObject("user",sysUser);
        //设置前端页面
        modelAndView.setViewName("user-show");
        return  modelAndView;

    }

    /**
     * 用户添加角色数据回显
     * @param id
     * @return
     */
    @RequestMapping("/addUsertoUI")
    public ModelAndView addUsertoUI(long id){
        //查询数据--所有角色
       List<Role> roleList =  roleService.findAll();
       //当前用户拥有的角色列表
       SysUser sysUser =  userService.findById(id);
       //当前用户具有的角色列表
        List<Role> roleWithUserList = sysUser.getRoleList();
        //把该用户拥有的角色id拼接成一个字符串
        // 1,2,3,
        //1,2,3,12,
        //前后追加,1, 为了防止出现1,2,12情况，后续前端查询是否包含(,id,)即可、
        //防止1,2,12会显示成一个
        StringBuffer str = new StringBuffer();
        for (Role role : roleWithUserList) {
            str.append(",");
            str.append(role.getId());
            str.append(",");
        }
        //生成视图
        ModelAndView modelAndView = new ModelAndView();
        //存数据-所有的角色列表
        modelAndView.addObject("roleList",roleList);
        //存数据-当前哪个用户
        modelAndView.addObject("user",sysUser);
        //存数据-当前用户拥有的角色列表
        modelAndView.addObject("str",str);
        //设置前端页面
        modelAndView.setViewName("user-role-add");
        return  modelAndView;
    }

    /**
     *
     * @param userId   给哪个用户添加角色
     * @param ids  给用户添加角色的id集合
     */
    @RequestMapping("/addRolesToUser")
    public String addRolesToUser(Long userId,Long ids[]){
          //保存操作
          userService.addRolesToUser(userId,ids);
        //请求查询全部

        return "redirect:/user/findAll";
    }
}
