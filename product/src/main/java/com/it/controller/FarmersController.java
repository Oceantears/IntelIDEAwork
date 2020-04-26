package com.it.controller;/*
@author Laotian
@create 2020-03-13-9:56
*/

import com.it.domain.Farmers;
import com.it.service.IFarmersService;
import com.it.utils.TimeHelper;
import com.it.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/farmers")
public class FarmersController {
    @Autowired
    private IFarmersService farmersService;

    /**
     * 查询
     * @param farmers
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping("/queryAllFarmers")
    @ResponseBody
    public Map<String,Object> queryAllFarmers( Farmers farmers, int limit, int page){

        Map<String,Object> map=new HashMap<>();
        List<Farmers> farmersList = farmersService.queryAll(farmers,(page-1)*limit,limit);
        /*for (Admin admin1 : admins) {
            System.out.println(admin1);
        }*/
        int count = farmersService.count(farmers);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",farmersList);
        //System.out.println("map-->"+map);
        return map;
    }

    @RequestMapping("/toqueryAllFarmers")
    public String toqueryAllFarmers(){
        return "farmers/queryAllFarmers";
    }

    /**
     * 保存
     * @param
     * @return
     */
    @RequestMapping(value = {"/saveFarmers"},method = {RequestMethod.POST})
    //@ResponseBody
    public void saveFarmers(Farmers farmers, HttpServletResponse response)throws IOException {

        String mes;
        try {
            farmers.setFarmers_id(UUIDUtils.getUUID());
            farmers.setAddtime(TimeHelper.getCurrentTime());
            farmersService.saveFarmers(farmers);
            mes = "success";
        } catch (Exception e) {
            e.printStackTrace();
            mes = "error";
        }
        response.getWriter().write(mes);
    }

    @RequestMapping("/tosaveFarmers")
    public String tosaveFarmers(){
        return "farmers/saveFarmers";
    }

    /**
     * 删除
     * @param farmers
     * @return
     */
    @RequestMapping("/deleteFarmers")
    @ResponseBody
    public String deleteFarmers(Farmers farmers){
        try{
            farmersService.deleteFarmer(farmers);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/farmers/queryAllFarmers";
    }

    /**
     * 批量删除
     * @param delArray
     * @return
     */
    @RequestMapping("/farmersDelete")
    @ResponseBody
    public String farmersDelete(String delArray){
        System.out.println(delArray+"aaaaaaaaaa");
        farmersService.farmersDelete(delArray);
        return  "redirect:/farmers/queryAllFarmers";
    }

    /**
     * 修改
     * @param farmers
     * @return
     */
    @RequestMapping(value = {"/updateFarmers"},method = {RequestMethod.POST})
    public void updateFarmers(Farmers farmers,HttpServletResponse response) throws IOException {
        String mes;
        try{
            /*farmers.setFarmers_id(UUIDUtils.getUUID());
            farmers.setAddtime(TimeHelper.getCurrentTime());*/
            farmersService.updateFarmers(farmers);
            mes = "success";
        }catch (Exception e){
            e.printStackTrace();
            mes = "error";
        }
        response.getWriter().write(mes);
    }

    @RequestMapping("/toupdateFarmers")
    public String toupdateFarmers(){
        return "farmers/updateFarmers";
    }
}
