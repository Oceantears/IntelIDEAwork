package com.controllers;


import com.bean.*;
import com.mapper.*;
import com.utils.*;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HwEquipmentController {

    private static final Logger log = LoggerFactory.getLogger(HwEquipmentController.class);
    //mysql接口层
    @Resource
    private HwEquipmentMapper hwEquipmentMapper;
    @Resource
    private DemosMapper demosMapper;
    @Resource
    GetliveinfoMapper getliveinfoMapper;
    @Resource
    private Place_infoMapper place_infoMapper;
    @Resource
    private CameraMapper cameraMapper;
    @Resource
    private CompanyifoMapper companyifoMapper;
    @Value("${name}")
    private String name;
    @Resource
    private AccesstokenMapper accesstokenMapper;
    @Resource
    private ChangjiaMapper changjiaMapper;
    @Resource
    private QxpreMapper qxpreMapper;

    @RequestMapping(value = "/list")
    public ModelAndView list(Model model) {
        log.info("加载设备列表");
        List<Hw_Equipment> hwEquipments = hwEquipmentMapper.selecthw_equipmentAll();
        model.addAttribute("hwEquipment", hwEquipments);
        return new ModelAndView("main", "userModel", model);
    }

    @RequestMapping(value = "/query")
    public ModelAndView demosSN(Model model, String EQ_SN) throws MyException {
        log.info("加载设备信息");
        List<Demos> demos = demosMapper.selecthw_demosSN(EQ_SN);
        if (demos.size() == 0) {
            model.addAttribute("wendu", "无");
            model.addAttribute("shidu", "无");
            model.addAttribute("guangzhao", "无");
            model.addAttribute("pm", "无");
            model.addAttribute("yuliang", "无");
            model.addAttribute("turang", "无");
            model.addAttribute("fengsu", "无");
            model.addAttribute("fengxiang", "无");
            model.addAttribute("yali", "无");
            model.addAttribute("haiba", "无");

            Place_info place = place_infoMapper.selectPlace(EQ_SN);
            model.addAttribute("place", place);
            Hw_Equipment hw_equipment2 = hwEquipmentMapper.selectSN(EQ_SN);
            String jingdu = hw_equipment2.getEQ_LONGITUDE() + "°";
            String weidu = hw_equipment2.getEQ_LATITUDE() + "°";
            model.addAttribute("hw_equipment", hw_equipment2);
            model.addAttribute("jingdu", jingdu);
            model.addAttribute("weidu", weidu);

            return new ModelAndView("hwEquipment", "hwEquipmentModel", model);
        } else {

            Demos demo = demos.get(demos.size() - 1);
            //温度
            String wendu = demo.getWENDU() + "℃";
            //湿度
            String shidu = demo.getSHIDU() + "%RH";
            //光照
            String guangzhao = demo.getGUANGZHAO() + "lux";
            //空气pm2.5
            String pm = demo.getPM2DOT5() + "μg/m3";
            //降雨量
            String yuliang = demo.getYULIANG() + "mm";
            //土地ph
            String turang = demo.getTURANGPH() + "pH";
            //风速
            String fengsu = demo.getFENGSU() + "m/s";
            //风向
            String fengxiang = demo.getFENGXIANG() + "°";
            //压力
            String yali = demo.getFENGXIANG() + "hpa";
            //海拔
            String haiba = demo.getHAIBA() + "m";
            model.addAttribute("demos1", demo);
            model.addAttribute("wendu", wendu);
            model.addAttribute("shidu", shidu);
            model.addAttribute("guangzhao", guangzhao);
            model.addAttribute("pm", pm);
            model.addAttribute("yuliang", yuliang);
            model.addAttribute("turang", turang);
            model.addAttribute("fengsu", fengsu);
            model.addAttribute("fengxiang", fengxiang);
            model.addAttribute("yali", yali);
            model.addAttribute("haiba", haiba);

            model.addAttribute("demo", demo);
            Place_info place = place_infoMapper.selectPlace(EQ_SN);
            model.addAttribute("place", place);
            Hw_Equipment hw_equipment1 = hwEquipmentMapper.selectSN(EQ_SN);
            Hw_Equipment hw_equipment = hw_equipment1;
            String jingdu = hw_equipment.getEQ_LONGITUDE() + "°";
            String weidu = hw_equipment.getEQ_LATITUDE() + "°";
            model.addAttribute("hw_equipment", hw_equipment);
            model.addAttribute("jingdu", jingdu);
            model.addAttribute("weidu", weidu);
        }
        return new ModelAndView("hwEquipment", "hwEquipmentModel", model);
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "zhibo2";
    }

    //图片
    @RequestMapping(value = "/test2")
    public ModelAndView test2(Model model, String EQ_SN) throws MyException {
        log.info("加载设备图片");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String data1 = format.format(date);

        MonthuTILS y1 = new MonthuTILS();
        List<String> month1 = y1.m1(EQ_SN, name, data1);
        model.addAttribute("month1", month1);

        List<String> month2 = y1.m2(EQ_SN, name, data1);
        model.addAttribute("month2", month2);

        List<String> month3 = y1.m3(EQ_SN, name, data1);
        model.addAttribute("month3", month3);

        List<String> month4 = y1.m4(EQ_SN, name, data1);
        model.addAttribute("month4", month4);

        List<String> month5 = y1.m5(EQ_SN, name, data1);
        model.addAttribute("month5", month5);

        List<String> month6 = y1.m6(EQ_SN, name, data1);
        model.addAttribute("month6", month6);

        List<String> month7 = y1.m7(EQ_SN, name, data1);
        model.addAttribute("month7", month7);

        List<String> month8 = y1.m8(EQ_SN, name, data1);
        model.addAttribute("month8", month8);

        List<String> month9 = y1.m9(EQ_SN, name, data1);
        model.addAttribute("month9", month9);

        List<String> month10 = y1.m10(EQ_SN, name, data1);
        model.addAttribute("month10", month10);

        List<String> month11 = y1.m11(EQ_SN, name, data1);
        model.addAttribute("month11", month11);

        List<String> month12 = y1.m12(EQ_SN, name, data1);
        model.addAttribute("month12", month12);

        model.addAttribute("data1", data1);
        return new ModelAndView("tupian", "tupiantModel", model);
    }

    @RequestMapping(value = "/zhibo")
    public ModelAndView zhibo(Model model, String EQ_SN) throws MyException {
        log.info("查看环境视频直播");
        if (EQ_SN == null) {
            throw new MyException("SN或设备序列号未获取！！！");
        }
        List<Hw_Equipment> list = hwEquipmentMapper.selectSNs(EQ_SN);
        Hw_Equipment hw_equipment = list.get(list.size() - 1);
        model.addAttribute("hw_equipment", hw_equipment);
        if (hw_equipment.getEQ_NAME().equals("海康")) {
            List<Camera> cameras = cameraMapper.selectAllsn(EQ_SN);
            Camera camera = cameras.get(cameras.size() - 1);
            if (camera.getLiveAddress() != null) {
                model.addAttribute("camera", camera);
                log.info("查看加工视频直播成功");
            } else {
                camera = cameras.get(cameras.size() - 1 - 1);
                model.addAttribute("camera", camera);
                log.info("查看加工视频直播成功");
            }
            return new ModelAndView("zb3", "zb3", model);

        } else if (hw_equipment.getEQ_NAME().equals("智慧树")) {
            List<Getliveinfo> getliveinfos = getliveinfoMapper.selectGetliveinfoSN(EQ_SN);
            Getliveinfo getliveinfo = getliveinfos.get(getliveinfos.size() - 1);
            if (getliveinfo.getGETLIVEINFO() != null) {
                model.addAttribute("getliveinfo", getliveinfo);
                log.info("查看环境视频直播成功");
            } else {
                getliveinfo = getliveinfos.get(getliveinfos.size() - 1 - 1);
                model.addAttribute("getliveinfo", getliveinfo);
                log.info("查看环境视频直播成功");
            }
            return new ModelAndView("zb", "zhibo", model);
        }
        return null;
    }


    @RequestMapping(value = "/insert")
    public ModelAndView insert(HttpServletResponse response, Model model, String company_name, String SB_CHANGJIA) {
        log.info("设备添加");
        //厂商集合
        List<Changjia> changjias = changjiaMapper.selectChangjia();
        model.addAttribute("changjias", changjias);
        //海康厂商参数集合
        List<Accesstoken> accesstokens = accesstokenMapper.selectAll();
        model.addAttribute("accesstokens", accesstokens);
        //公司集合
        List<Company_ifo> company_ifos = companyifoMapper.selectAll();
        model.addAttribute("company_ifos", company_ifos);
        return new ModelAndView("insertem", "insertem", model);
    }


    @RequestMapping("/queryCity.shtml")
    @ResponseBody
    public void queryCity(Integer company_id, HttpServletResponse response, Model model) {
        log.info("获取所有城市");
        try {
            List<Place_info> selectgsid = place_infoMapper.selectgsid(company_id);
            JSONArray json = JSONArray.fromObject(selectgsid);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;character=utf-8");
            response.getWriter().println(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @RequestMapping("/queryHAI.shtml")
    @ResponseBody
    public void queryCity(Integer company_id, HttpServletResponse response, Model model, Integer changjia_id) {
        log.info("获取所有海康参数信息");
        try {
            List<Accesstoken> accesstokens = accesstokenMapper.selectAccesstoken(changjia_id);
            JSONArray json = JSONArray.fromObject(accesstokens);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;character=utf-8");
            response.getWriter().println(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @RequestMapping("/queryqx.shtml")
    @ResponseBody
    public void queryqx(Integer company_id, HttpServletResponse response, Model model, Integer changjia_id) {
        log.info("获取所有气象站参数信息");
        try {
            List<Qxpre> qxpres = qxpreMapper.selectQxpre(changjia_id);
            JSONArray json = JSONArray.fromObject(qxpres);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;character=utf-8");
            response.getWriter().println(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //添加操作
    @RequestMapping("/inserts")
    public String index(Hw_Equipment hw_Equipment, Model model, String SB_CHANGJIA) {
        log.info("添加数据操作");
        hw_Equipment.setKEYID(hwEquipmentMapper.idPlushw_equipment());
        hw_Equipment.setSB_CHANGJIA(SB_CHANGJIA);
        hwEquipmentMapper.insert(hw_Equipment);
        return "redirect:/list";
    }

    //按id查找
    @RequestMapping("/updateems")
    public ModelAndView findid(Model model, Integer KEYID) {
        log.info("按ID获取单个设备");
        Hw_Equipment hw_equipmentFindId = hwEquipmentMapper.find(KEYID);
        model.addAttribute("hw_equipmentFindId", hw_equipmentFindId);
        //厂商集合
        List<Changjia> changjias = changjiaMapper.selectChangjia();
        model.addAttribute("changjias", changjias);
        //公司集合
        List<Company_ifo> company_ifos = companyifoMapper.selectAll();
        model.addAttribute("company_ifos", company_ifos);
        return new ModelAndView("updateem", "insertem", model);
    }


    //修改操作
    @RequestMapping("/updatem")
    public String xiugai(Hw_Equipment hw_Equipment) {
        log.info("修改数据操作");
        //修改
        hwEquipmentMapper.updatehw_equipment(hw_Equipment);
        return "redirect:/list";
    }

    //删除操作
    @RequestMapping("/deleteem")
    public String deletehwtem(Model model, Integer KEYID) {
        log.info("删除数据操作");
        hwEquipmentMapper.delete(KEYID);
        return "redirect:/list";
    }

}
