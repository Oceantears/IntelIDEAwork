package com.it.ssm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/18 10:59
 * @description：显示用户信息
 * @modified By：
 * @version:     $
 */
 @Controller
public class ShowUserNameController {

     @RequestMapping("/showUserName")
     public void showUserName(HttpServletRequest request){
         //获取session
         HttpSession session = request.getSession();
         //从session中获取所有的属性名
         /**
          * 迭代枚举
          */
       Enumeration enumeration =  session.getAttributeNames();
          while (enumeration.hasMoreElements()){

              System.out.println(enumeration.nextElement());
          }
         /**
          * 存储用户登录信息的session中的名称
          */
         // SPRING_SECURITY_CONTEXT
         Object spring_security_context  = session.getAttribute("SPRING_SECURITY_CONTEXT");
         System.out.println(spring_security_context);
         //获取SECURITY_CONTEXT对象，安全框架上下文对象,登录信息都在这里存储着
         SecurityContext securityContext = (SecurityContext)spring_security_context;
               //获取认证信息
         Authentication authentication = securityContext.getAuthentication();
              //Principal 翻译：重要的，获取重要信息--》用户的信息（安全提供的用户信息UserDetails）

         User user = (User)authentication.getPrincipal();
         String userName = user.getUsername();

         System.out.println("userName-->"+userName);

        //获取上下文对象方式二  context和securityContext一样 即等价
         SecurityContext context = SecurityContextHolder.getContext();
           //结果为true
         System.out.println(context==securityContext);
     }
}
