package com.controllers;

import com.bean.User;
import com.mapper.UsersMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UsersMapper usersMapper;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    //登录
    @RequestMapping(value = "/ulogin", method = {RequestMethod.POST})
    public String login(@RequestParam String USERNAME,
                        @RequestParam String PWD, Model model, HttpSession httpSession) {
        User user = usersMapper.login(USERNAME, PWD);
        //加密
        // User user = userService.checkUser(USERNAME, PWD);
        httpSession.setAttribute("user", user);
        if (user != null) {
            model.addAttribute("data", "登录成功！");
            return "redirect:/list";
        } else {
            model.addAttribute("data", "登录失败！");
            return "redirect:/login";
        }
    }

    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
    //分页
    /*public PageInfo<User> getMyOrder(User user) {
        if (StringUtils.isEmpty(obj.getQueryMonth())) {
            String endMonth = DateUtil.getEndMonth();
            obj.setStartMonth(DateUtil.getStartMonth(endMonth));
            obj.setEndMonth(endMonth);
        } else {
            obj.setStartMonth(null);
            obj.setEndMonth(null);
        }
        //设置分页参数
        PageHelper.startPage(obj.getPageNo(), obj.getPageSize());

        //查询列表数据
        List<MyOrderVo> list = userCenterMapper.getMyOrder(obj);

        //获取分页对象
        PageInfo<MyOrderVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }*/
}
