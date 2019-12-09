package com.it.ssm.controller;

import com.it.ssm.domain.Order;
import com.it.ssm.domain.PageBean;
import com.it.ssm.domain.Product;
import com.it.ssm.service.OrderService;
import com.it.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/12 10:09
 * @description：订单控制器
 * @modified By：
 * @version:     $
 */
 @Controller
 @RequestMapping("/order")
public class OrderController {
     @Autowired
     OrderService orderService;

     @Autowired
     ProductService productService;

    /**
     * 订单管理查询所有
     * @return
     */
     @RequestMapping("/findAll")
     public ModelAndView findAll(){
         //查询所有订单数据
         List<Order> orderList = orderService.findAll();
         //创建modelandView对象
         ModelAndView modelAndView = new ModelAndView();
         //添加数据
         modelAndView.addObject("orderList",orderList);

         //指定页面
         modelAndView.setViewName("order-list");
         return  modelAndView;
     }

    /**
     * 查看订单数据回显，查看所有产品
     * @return
     */
    @RequestMapping("/addUI")
    public ModelAndView addUI(){
        System.out.println("----------===addUI()================>");

        //查询所有订单数据
       List<Product> productList =  productService.findAll();
        System.out.println("productList--->"+productList.size());
        //创建modelandView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("prodcutList",productList);
        //指定页面
        modelAndView.setViewName("order-add");
        return  modelAndView;
    }

    @RequestMapping("/save")
    public String save(Order order){
        orderService.save(order);
        System.out.println("save--order----》"+order);
        return "redirect:/order/findAll";
    }

    /**
     * 订单管理查询所有手动分页
     * @return
     */
    @RequestMapping("/findAll2")
    public ModelAndView findAll2(@RequestParam( value="currPage",required = false,defaultValue = "1") Integer currPage,
                                 @RequestParam( value="pageSize",required = false,defaultValue = "5") Integer pageSize){
        //查询所有订单数据
       PageBean<Order> pageBean = orderService.findByPage(currPage,pageSize);

        //创建modelandView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("pageBean",pageBean);

        //指定页面
        modelAndView.setViewName("order-list2");
        return  modelAndView;
    }
}
