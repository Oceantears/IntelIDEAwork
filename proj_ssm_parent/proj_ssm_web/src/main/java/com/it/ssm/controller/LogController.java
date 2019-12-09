package com.it.ssm.controller;

import com.it.ssm.domain.SysLog;
import com.it.ssm.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/11/6 17:40
 * @description：日志控制器
 * @modified By：
 * @version:     $
 * 注解配置aop
 * 提供一个类为切面类
 * 切面:切入点+通知
 * 通知分类：
 *   前置增强@Before
 *   后置增强@After returing
 *   最终增强 @After
 *   异常增强@After throwing
 *   环绕增强@Around
 */
@Component  //生成对象
@Aspect
public class LogController {
 @Autowired
 LogService logService;
 //springmvc一旦发起请求就创建了,只有这个springmvc框架才有这个功能
    @Autowired
   HttpServletRequest request;

 @Pointcut("execution(* com.it.ssm.controller.*.*(..))")
 public void pointcut(){}

 /**连接点就是连接的方法
  * ProceedingJoinPoint 连接点对象 可以执行真实对象的真实方法
    JoinPoint连接点对象 不可以执行真实对象的真实方法

  * @param joinPoint   连接点对象
  *
  */
 @Around("pointcut()")
 public Object around(ProceedingJoinPoint joinPoint){
   //创建日志对象

  SysLog sysLog = new SysLog();
  //日志对象封装

  //访问时间
  sysLog.setVisitTime(new Date().toLocaleString());
   //访问用户名-->安全框架得到，获取上下文对象即可获取
  //获取security对象
  SecurityContext securityContext = SecurityContextHolder.getContext();
  //获取认证对象
  Authentication authentication = securityContext.getAuthentication();
//获取用户对象
 User user = (User)authentication.getPrincipal();
 //获取用户名
  String username = user.getUsername();
  sysLog.setUsername(username);
  //访问ip-->想办法获取请求对象，地址在请求
  sysLog.setIp(request.getRemoteAddr());
   //获取方法名
//被拦截的对象
  Object target = joinPoint.getTarget();
//被拦截的类的完全限定的类名
 String className =  target.getClass().getName();
 //获取被拦截的方法
  Signature signature =  joinPoint.getSignature();
//获取被拦截的方法名
 String methodName =  signature.getName();
 sysLog.setMethod(className+"."+methodName);
 System.out.println("sysLog-->"+sysLog);
 //将日志对象存储到数据库
  logService.save(sysLog);


  //需要把真实方法的返回值返回，
// 如果不返回所有方法被拦截，没有执行返回值
  try{
      return  joinPoint.proceed();
  }catch (Throwable throwable){
        throwable.printStackTrace();
  }
  return  null;
 }
}
