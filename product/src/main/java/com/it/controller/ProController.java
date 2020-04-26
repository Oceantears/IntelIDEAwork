/**
 * 产品组成控制器
 */
package com.it.controller;

import com.it.domain.Pro_form_info;
import com.it.service.IProService;
import com.it.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Laotian
 * @date 2020-03-20 10:55
 */
@Controller
@RequestMapping("/pro")
public class ProController {

    @Autowired
    private IProService proService;

    /**
     * 查询所有产品组成
     */
    @RequestMapping("/queryAllPro")
    @ResponseBody
    public Map<String,Object> queryAllPro(Pro_form_info pro_form_info){

        Map<String,Object> map=new HashMap<>();
        List<Pro_form_info> pro_form_infos = proService.queryAllPro(pro_form_info);
        /*for (Admin admin1 : admins) {
            System.out.println(admin1);
        }*/
        //int count = adminService.count(admin);
        map.put("code",0);
        map.put("msg","");
        map.put("count",10);
        map.put("data",pro_form_infos);
        System.out.println("map-->"+map);
        return map;
    }

    @RequestMapping("/toqueryAllPro")
    public String toqueryAllPro(){
        return "pro/queryAllPro";
    }

    //添加
    @RequestMapping("/savePro")
    @ResponseBody
    public String savePro(Pro_form_info pro_form_info){
        try {
            pro_form_info.setProduct_id(UUIDUtils.getUUID());
            proService.savePro(pro_form_info);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }
    @RequestMapping("/tosavePro")
    public String tosavePro(){
        return "pro/savePro";
    }
}