package com.it.controller;/*
@author Laotian
@create 2020-03-13-10:59
*/

import com.it.domain.Farmers;
import com.it.domain.Pro_farmer;
import com.it.domain.Product;
import com.it.service.IFarmersService;
import com.it.service.IProductService;
import com.it.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("productController")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IFarmersService farmersService;

    /**
     * 查询
     * @param pro_farmer
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/queryAllProduct")
    @ResponseBody
    public Map<String,Object> queryAllProduct(Pro_farmer pro_farmer, int limit, int page){

        Map<String,Object> map=new HashMap<>();
        List<Pro_farmer> pro_farmers = productService.queryAll(pro_farmer,(page-1)*limit,limit);
        for (Pro_farmer proFarmer : pro_farmers) {
            System.out.println(proFarmer);
        }
        int count = productService.count(pro_farmer);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",pro_farmers);
        System.out.println("map-->"+map);
        return map;
    }
    @RequestMapping("/toqueryAllProduct")
    public String toqueryAllproduct(){
        return "product/queryAllProduct";
    }

    /**
     * 保存
     * @param
     * @return
     */
    @RequestMapping(value = {"/saveProduct"})
    @ResponseBody
    public String saveProduct(Pro_farmer pro_farmer){
        pro_farmer.setProduct_id(UUIDUtils.getUUID());
        pro_farmer.setFarmers_id(UUIDUtils.getUUID());
        productService.saveProduct(pro_farmer);
        return "redirect:/farmers/queryAllFarmers";
    }

    @RequestMapping("/tosaveProduct")
    public String tosaveProduct(){
        return "product/saveProduct";
    }

    /**
     * 删除
     * @param product
     * @return
     */
    @RequestMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(Product product){
        try{
            productService.deleteProduct(product);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/product/queryAllProduct";
    }

    /**
     * 批量删除
     * @param delArray
     * @return
     */
    @RequestMapping("/productDelete")
    @ResponseBody
    public String productDelete(String delArray){
        System.out.println(delArray+"aaaaaaaaaa");
        productService.productDelete(delArray);
        return  "redirect:/product/queryAllProduct";
    }

    /**
     * 修改
     * @param pro_farmer
     * @return
     */
    @RequestMapping(value = {"/updateProduct"})
    public String updateProduct(Pro_farmer pro_farmer){
        try{
            /*farmers.setFarmers_id(UUIDUtils.getUUID());
            farmers.setAddtime(TimeHelper.getCurrentTime());*/
            productService.updateProduct(pro_farmer);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/toupdateProduct")
    public String toupdateProduct(){
        return "product/updateProduct";
    }
}
