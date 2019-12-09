package com.it.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.it.ssm.domain.PageBean;
import com.it.ssm.domain.Product;
import com.it.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author     ：zyx
 * @date       ：Created in 2019/10/10 20:57
 * @description：产品控制器
 * @modified By：
 * @version:     v1.0$
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    //查询全部
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //准备数据
        List<Product> productList = productService.findAll();
        System.out.println("productList--->"+productList.size());
        //创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("productList",productList);
        //指定页面
        modelAndView.setViewName("product-list");
        return   modelAndView;
    }

    /**
     * 添加产品
     * @param product
     * @return
     */
    @RequestMapping("/save")
    public String save(Product product){
        System.out.println(product);
        productService.save(product);
        return "redirect:/product/findAll";
    }
    //查询全部
    @RequestMapping("/findById")
    public ModelAndView findById(long id){
        //准备数据
        Product product = productService.findById(id);
        System.out.println("product--->"+product);
        //创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("product",product);
        //指定页面
        modelAndView.setViewName("product-update");
        return   modelAndView;
    }

    /**
     * 修改功能
     * @param product
     * @return
     */
    @RequestMapping("/update")
    public String update(Product product){
        System.out.println("update---->"+product);
        productService.update(product);
       return "redirect:/product/findAll";
    }

    /**
     *删除单个
     * @param id
     * @return
     */
    @RequestMapping("/delOne")
    public String delOne(Long id){
        System.out.println("id---->"+id);
        productService.delOne(id);
        return "redirect:/product/findAll";
    }

    /**
     * 删除多个
     * @param ids
     * @return
     */
    @RequestMapping("/delMany")
    public String delMany(Long ids[]){
        System.out.println("ids---->"+ids.length);
        productService.delMany(ids);
        return "redirect:/product/findAll";
    }


    /**
     * 手动分页查询
     *
     * RequestParam; 请求参数绑定
     *      name:别名value, 指定页面参数的名称
     *      required: 是否必要参数
     * @return
     */
    @RequestMapping("/findAll2")
    public ModelAndView findAll2(
            @RequestParam(value = "currPage",required = false,defaultValue = "1")  Integer currPage ,
            @RequestParam(value = "pageSize",required = false, defaultValue = "5")Integer pageSize){
        //准备数据: 分页数据
        PageBean<Product> pageBean = productService.findByPage(currPage, pageSize);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("currPage--->"+currPage);
        System.out.println("pageSize"+pageSize);
        for (Product product:pageBean.getList()) {

            System.out.println(product);

        }
        //添加数据
        modelAndView.addObject("pageBean",pageBean);
        //指定页面
        modelAndView.setViewName("product-list2");
        return modelAndView;
    }

    /**
     * 分页助手查询
     *
     * RequestParam; 请求参数绑定
     *      name:别名value, 指定页面参数的名称
     *      required: 是否必要参数
     * @return
     */
    @RequestMapping("/findAll3")
    public ModelAndView findAll3(
            @RequestParam(value = "currPage",required = false,defaultValue = "1")  Integer currPage ,
            @RequestParam(value = "pageSize",required = false, defaultValue = "5")Integer pageSize){
        //准备数据: 分页数据
        PageInfo<Product> pageInfo = productService.findByPageHelper(currPage, pageSize);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("currPage--->"+currPage);
        System.out.println("pageSize"+pageSize);
        for (Product product:pageInfo.getList()) {

            System.out.println(product);

        }
        //添加数据
        modelAndView.addObject("pageInfo",pageInfo);
        //指定页面
        modelAndView.setViewName("product-list3");
        return modelAndView;
    }
}
