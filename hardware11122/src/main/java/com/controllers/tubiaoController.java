package com.controllers;

import com.bean.*;
import com.mapper.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class tubiaoController {
    @Resource
    private HwEquipmentMapper hwEquipmentMapper;
    @Resource
    private DemosMapper demosMapper;
    @Resource
    GetliveinfoMapper getliveinfoMapper;
    @Resource
    private CameraMapper cameraMapper;
    @Value("${name}")
    private String name;
    @Resource
    private GetdeviceImagedataMapper getdeviceImagedataMapper;
    @Resource
    private AccesstokenMapper accesstokenMapper;

    @RequestMapping("/project")
    @ResponseBody
    public ArrayList<Demos> myProject(String EQ_SN) {
        ArrayList<Demos> List = new ArrayList<>();
        EQ_SN = "0018DE743E31";
        List<Demos> demos = demosMapper.selecthw_demosSN(EQ_SN);
        if (demos.size() > 0) {
            for (int i = demos.size() - 1; i >= demos.size() - 13; i--) {
                List.add(demos.get(i));
            }
        }
        return List;
    }

    @RequestMapping(value = "/zhexiantu")
    public ModelAndView zhexiantu(Model model, String EQ_SN) {
        EQ_SN = "0018DE743E31";
        List<Demos> demos = demosMapper.selecthw_demosSN(EQ_SN);
        List<Double> wd = new ArrayList<>();
        List<Double> sd = new ArrayList<>();
        List<Double> fs = new ArrayList<>();
        List<Double> gz = new ArrayList<>();
        List<Double> jy = new ArrayList<>();
        List<Double> pm = new ArrayList<>();

        if (demos.size() > 0) {
            for (int i = demos.size() - 1; i >= demos.size() - 13; i--) {
                wd.add(demos.get(i).getWENDU());
                sd.add(demos.get(i).getSHIDU());
                fs.add(demos.get(i).getFENGSU());
                gz.add(demos.get(i).getGUANGZHAO());
                jy.add(demos.get(i).getYULIANG());
                pm.add(demos.get(i).getPM2DOT5());
            }
        }

        model.addAttribute("wd", wd);
        model.addAttribute("sd", sd);
        model.addAttribute("fs", fs);
        model.addAttribute("gz", gz);
        model.addAttribute("jy", jy);
        model.addAttribute("pm", pm);
        return null;
    }

    @RequestMapping(value = "/shuju")
    public ModelAndView shuju(Model model, Integer keyid, HttpSession session) throws ParseException {
        List<Hw_Equipment> hwEquipments = hwEquipmentMapper.selecthw_equipmentEQ_STATEAll();
        //h获取设备ID
        if (keyid == null) {
            keyid = 2;
            Hw_Equipment hw_equipment1 = hwEquipmentMapper.find(keyid);
            String eq_sn = hw_equipment1.getEQ_SN();
            List<Demos> demos = demosMapper.selecthw_demosSN(eq_sn);
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
                Hw_Equipment hw_equipment = hwEquipmentMapper.selectSN(eq_sn);
                String jingdu = hw_equipment.getEQ_LONGITUDE() + "";
                String weidu = hw_equipment.getEQ_LATITUDE() + "";
                model.addAttribute("hw_equipment", hw_equipment);
                model.addAttribute("jingdu", jingdu);
                model.addAttribute("weidu", weidu);

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

            }
            List<Double> wd = new ArrayList<>();
            List<Double> sd = new ArrayList<>();
            List<Double> fs = new ArrayList<>();
            List<Double> gz = new ArrayList<>();
            List<Double> jy = new ArrayList<>();
            List<Double> pm2 = new ArrayList<>();
            List<Double> hb = new ArrayList<>();
            if (demos.size() > 0) {
                for (int i = demos.size() - 1; i >= demos.size() - 13; i--) {
                    wd.add(demos.get(i).getWENDU());
                    sd.add(demos.get(i).getSHIDU());
                    fs.add(demos.get(i).getFENGSU());
                    gz.add(demos.get(i).getGUANGZHAO());
                    jy.add(demos.get(i).getYULIANG());
                    pm2.add(demos.get(i).getPM2DOT5());
                    hb.add(demos.get(i).getHAIBA());
                }
            }
            model.addAttribute("wd", wd);
            model.addAttribute("sd", sd);
            model.addAttribute("fs", fs);
            model.addAttribute("gz", gz);
            model.addAttribute("jy", jy);
            model.addAttribute("pm2", pm2);
            model.addAttribute("hb", hb);
            List<Hw_Equipment> list = hwEquipmentMapper.selectSNs(eq_sn);
            Hw_Equipment hw_equipment = list.get(list.size() - 1);
            //1是克拉2是海康
            //获取视频
            if (hw_equipment.getSB_CHANGJIA() == 2) {
                List<Camera> cameras = cameraMapper.selectAllsn(eq_sn);
                Camera string = cameras.get(cameras.size() - 1);
                if (string.getLiveAddress() != null) {
                    model.addAttribute("string", string);
                } else {
                    string = cameras.get(cameras.size() - 1 - 1);
                    model.addAttribute("string", string);
                }
            } else if (hw_equipment.getSB_CHANGJIA() == 1) {
                List<Getliveinfo> getliveinfos = getliveinfoMapper.selectGetliveinfoSN(eq_sn);
                Getliveinfo getliveinfo = getliveinfos.get(getliveinfos.size() - 1);
                if (getliveinfo.getGETLIVEINFO() != null) {
                    String string = getliveinfo.getGETLIVEINFO();
                    String gejpg = getliveinfo.getGEJPG();
                    model.addAttribute("string", string);
                    model.addAttribute("gejpg", gejpg);
                } else {
                    getliveinfo = getliveinfos.get(getliveinfos.size() - 1 - 1);
                    String string = getliveinfo.getGETLIVEINFO();
                    String gejpg = getliveinfo.getGEJPG();
                    model.addAttribute("string", string);
                    model.addAttribute("gejpg", gejpg);
                }
            }
            //获取图片
            if (hw_equipment.getSB_CHANGJIA() == 1) {
                session.setAttribute("ss", eq_sn);
                model.addAttribute("EQ_SN", eq_sn);
                long now = System.currentTimeMillis();
                Date date = new Date();
                date.setTime(now);
                String format = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
                model.addAttribute("format", format);
                model.addAttribute("EQ_SN", eq_sn);
                long now1 = System.currentTimeMillis();
                Date date1 = new Date();
                date1.setTime(now1 + 86400000);
                String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
                List<GetdeviceImagedata> getdeviceImagedatas = getdeviceImagedataMapper.selectData(format, format1, eq_sn);
                if (getdeviceImagedatas.size() == 0) {
                    List<GetdeviceImagedata> getdeviceImagedatas2 = getdeviceImagedataMapper.selectData2(format, format1, eq_sn);
                    model.addAttribute("getdeviceImagedatas", getdeviceImagedatas2);
                } else {
                    model.addAttribute("getdeviceImagedatas", getdeviceImagedatas);
                }
            } else if (hw_equipment.getSB_CHANGJIA() == 2) {
                String data = "";
                Object ss = session.getAttribute("ss");
                String sss = ss.toString();
                long now = System.currentTimeMillis();
                Date dates = new Date();
                dates.setTime(now);
                String formats = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(dates);
                model.addAttribute("format", formats);
                String date1 = data;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//24小时制
                long time = simpleDateFormat.parse(date1).getTime();
                Date date3 = new Date();
                date3.setTime(time);
                String format3 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date3);
                Date date11 = new Date();
                date11.setTime(time + 86400000);
                String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
                List<GetdeviceImagedata> str = getdeviceImagedataMapper.selectAllData(format3, format1, sss);
                if (str.size() == 0) {
                    List<GetdeviceImagedata> strings = getdeviceImagedataMapper.selectAllData2(format3, format1, sss);
                    model.addAttribute("lists", strings);
                } else {
                    model.addAttribute("lists", str);
                }
            }
            model.addAttribute("hwEquipments", hwEquipments);
        } else {
            Hw_Equipment hw_equipment1 = hwEquipmentMapper.find(keyid);
            String eq_sn = hw_equipment1.getEQ_SN();
            List<Demos> demos = demosMapper.selecthw_demosSN(eq_sn);
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
                Hw_Equipment hw_equipment = hwEquipmentMapper.selectSN(eq_sn);
                String jingdu = hw_equipment.getEQ_LONGITUDE() + "";
                String weidu = hw_equipment.getEQ_LATITUDE() + "";
                model.addAttribute("hw_equipment", hw_equipment);
                model.addAttribute("jingdu", jingdu);
                model.addAttribute("weidu", weidu);

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

                Hw_Equipment hw_equipment = hwEquipmentMapper.selectSN(eq_sn);
                String jingdu = hw_equipment.getEQ_LONGITUDE() + "";
                String weidu = hw_equipment.getEQ_LATITUDE() + "";
                model.addAttribute("hw_equipment", hw_equipment);
                model.addAttribute("jingdu", jingdu);
                model.addAttribute("weidu", weidu);
            }
            List<Double> wd = new ArrayList<>();
            List<Double> sd = new ArrayList<>();
            List<Double> fs = new ArrayList<>();
            List<Double> gz = new ArrayList<>();
            List<Double> jy = new ArrayList<>();
            List<Double> pm2 = new ArrayList<>();
            List<Double> hb = new ArrayList<>();
            if (demos.size() > 0) {
                for (int i = demos.size() - 1; i >= demos.size() - 13; i--) {
                    wd.add(demos.get(i).getWENDU());
                    sd.add(demos.get(i).getSHIDU());
                    fs.add(demos.get(i).getFENGSU());
                    gz.add(demos.get(i).getGUANGZHAO());
                    jy.add(demos.get(i).getYULIANG());
                    pm2.add(demos.get(i).getPM2DOT5());
                    hb.add(demos.get(i).getHAIBA());
                }
            }
            model.addAttribute("wd", wd);
            model.addAttribute("sd", sd);
            model.addAttribute("fs", fs);
            model.addAttribute("gz", gz);
            model.addAttribute("jy", jy);
            model.addAttribute("pm2", pm2);
            model.addAttribute("hb", hb);

            List<Hw_Equipment> list = hwEquipmentMapper.selectSNs(eq_sn);
            Hw_Equipment hw_equipment = list.get(list.size() - 1);
            //1是克拉2是海康
            if (hw_equipment.getSB_CHANGJIA() == 2) {
                List<Camera> cameras = cameraMapper.selectAllsn(eq_sn);
                Camera camera = cameras.get(cameras.size() - 1);

                if (camera.getLiveAddress() != null) {
                    String string = camera.getLiveAddress();

                    String serial = camera.getDeviceSerial();
                    Integer atkeyid = camera.getATKEYID();
                    Accesstoken accesstoken = accesstokenMapper.selectByID(atkeyid);
                    String Token = accesstoken.getAccessToken();
                    String str = "https://open.ys7.com/ezopen/h5/iframe?url=ezopen://open.ys7.com/" + serial + "/1.live&autoplay=0&accessToken=" + Token + "";
                    System.out.println(str + "string2");
                    model.addAttribute("str", str);
                    model.addAttribute("string", string);
                } else {
                    String serial = camera.getDeviceSerial();

                    Integer atkeyid = camera.getATKEYID();
                    Accesstoken accesstoken = accesstokenMapper.selectByID(atkeyid);
                    String Token = accesstoken.getAccessToken();
                    String string = camera.getLiveAddress();
                    String str = "https://open.ys7.com/ezopen/h5/iframe?url=ezopen://open.ys7.com/" + serial + "/1.live&autoplay=0&accessToken=" + Token + "";
                    System.out.println(str + "string2");
                    System.out.println(str + "string2");

                    model.addAttribute("str", str);
                    model.addAttribute("string", string);
                }
            } else if (hw_equipment.getSB_CHANGJIA() == 1) {
                List<Getliveinfo> getliveinfos = getliveinfoMapper.selectGetliveinfoSN(eq_sn);
                Getliveinfo getliveinfo = getliveinfos.get(getliveinfos.size() - 1);
                if (getliveinfo.getGETLIVEINFO() != null) {
                    String string = getliveinfo.getGETLIVEINFO();
                    String gejpg = getliveinfo.getGEJPG();

                    System.out.println(string + "string1");
                    model.addAttribute("string", string);
                    model.addAttribute("gejpg", gejpg);
                } else {
                    getliveinfo = getliveinfos.get(getliveinfos.size() - 1 - 1);
                    String string = getliveinfo.getGETLIVEINFO();
                    String gejpg = getliveinfo.getGEJPG();
                    System.out.println(string + "string");
                    model.addAttribute("string", string);
                    model.addAttribute("gejpg", gejpg);
                }
            }
            if (hw_equipment.getSB_CHANGJIA() == 1) {
                session.setAttribute("ss", eq_sn);
                model.addAttribute("EQ_SN", eq_sn);
                long now = System.currentTimeMillis();
                Date date = new Date();
                date.setTime(now);
                String format = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
                model.addAttribute("format", format);
                model.addAttribute("EQ_SN", eq_sn);
                long now1 = System.currentTimeMillis();
                Date date1 = new Date();
                date1.setTime(now1 + 86400000);
                String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
                List<GetdeviceImagedata> getdeviceImagedatas = getdeviceImagedataMapper.selectData(format, format1, eq_sn);
                if (getdeviceImagedatas.size() == 0) {
                    List<GetdeviceImagedata> getdeviceImagedatas2 = getdeviceImagedataMapper.selectData2(format, format1, eq_sn);
                    model.addAttribute("getdeviceImagedatas", getdeviceImagedatas2);
                } else {
                    model.addAttribute("getdeviceImagedatas", getdeviceImagedatas);
                }
            } else if (hw_equipment.getSB_CHANGJIA() == 2) {
                String data = "";
                Object ss = session.getAttribute("ss");
                String sss = ss.toString();
                long now = System.currentTimeMillis();
                Date dates = new Date();
                dates.setTime(now);
                String formats = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(dates);
                model.addAttribute("format", formats);
                String date1 = data;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//24小时制
                long time = simpleDateFormat.parse(date1).getTime();
                Date date3 = new Date();
                date3.setTime(time);
                String format3 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date3);
                Date date11 = new Date();
                date11.setTime(time + 86400000);
                String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
                List<GetdeviceImagedata> str = getdeviceImagedataMapper.selectAllData(format3, format1, sss);
                if (str.size() == 0) {
                    List<GetdeviceImagedata> strings = getdeviceImagedataMapper.selectAllData2(format3, format1, sss);
                    model.addAttribute("lists", strings);
                } else {
                    model.addAttribute("lists", str);
                }
            }
            model.addAttribute("hwEquipments", hwEquipments);
        }


        return new ModelAndView("shuju", "sj", model);
    }
}

