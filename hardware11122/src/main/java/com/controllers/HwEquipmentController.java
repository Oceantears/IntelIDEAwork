package com.controllers;


import com.bean.*;
import com.controller.LatitudeController;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.LatitudeInterface;
import com.interfaces.LongitudeInterface;
import com.mapper.*;
import com.utils.InterfacesUtils;
import com.utils.MonthuTILS;
import com.utils.MyException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Resource
    private GetdeviceImagedataMapper getdeviceImagedataMapper;

    //温度
    @Resource
    private TemperatureMapper temperatureMapper;
    //pm2.5
    @Resource
    private Pm2dot5Mapper pm2dot5Mapper;
    //大气湿度
    @Resource
    private AtmosphericHumidityMapper atmosphericHumidityMapper;

    //风向
    @Resource
    private WinddirectionMapper winddirectionMapper;

    //风速
    @Resource
    private WindspeedMapper windspeedMapper;

    //光照
    @Resource
    private LightintensityMapper lightintensityMapper;

    //降雨量
    @Resource
    private PrecipitationMapper precipitationMapper;

    //土壤PH
    @Resource
    private SoilphMapper soilphMapper;

    //大气气压
    @Resource
    private AirpressureMapper airpressureMapper;

    //海拔
    @Resource
    private AltitudeMapper altitudeMapper;


    @RequestMapping(value = "/list")
    public ModelAndView list(Model model) {
        log.info("加载设备列表");

        List<Hw_Equipment> hwEquipments = hwEquipmentMapper.selecthw_equipmentEQ_STATEAll();

        model.addAttribute("hwEquipment", hwEquipments);

        return new ModelAndView("main", "userModel", model);
    }

    @RequestMapping(value = "/query")
    public ModelAndView demosSN(Model model, String EQ_SN) {
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
            String fengmianPicture = place.getFengmian_picture();
            String pic = "http://hanyin.qwdh888.cn";
            String picpath;
            String[] strs = fengmianPicture.split("#");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                list.add(strs[i]);
            }
            for (int j = 0; j < list.size(); j++) {
                picpath = pic + list.get(1);
                model.addAttribute("picpath", picpath);
            }
            model.addAttribute("place", place);
            Hw_Equipment hw_equipment = hwEquipmentMapper.selectSN(EQ_SN);
            String jingdu = hw_equipment.getEQ_LONGITUDE() + "";
            String weidu = hw_equipment.getEQ_LATITUDE() + "";
            model.addAttribute("hw_equipment", hw_equipment);
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
            String fengmianPicture = place.getFengmian_picture();
            String pic = "http://hanyin.qwdh888.cn";
            String picpath;
            String[] strs = fengmianPicture.split("#");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                list.add(strs[i]);
            }
            for (int j = 0; j < list.size(); j++) {
                picpath = pic + list.get(1);
                model.addAttribute("picpath", picpath);
            }
            model.addAttribute("place", place);
            Hw_Equipment hw_equipment = hwEquipmentMapper.selectSN(EQ_SN);
            String jingdu = hw_equipment.getEQ_LONGITUDE() + "";
            String weidu = hw_equipment.getEQ_LATITUDE() + "";
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
    @RequestMapping(value = "/test4")
    public ModelAndView test4(Model model, String EQ_SN, HttpSession session) throws MyException {
        session.setAttribute("ss", EQ_SN);
        model.addAttribute("EQ_SN", EQ_SN);
        long now = System.currentTimeMillis();
        Date date = new Date();
        date.setTime(now);
        String format = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);

        model.addAttribute("EQ_SN", EQ_SN);
        long now1 = System.currentTimeMillis();
        Date date1 = new Date();
        date1.setTime(now1 + 86400000);
        String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
        List<GetdeviceImagedata> getdeviceImagedatas = getdeviceImagedataMapper.selectData(format, format1, EQ_SN);
        if (getdeviceImagedatas.size() == 0) {
            List<GetdeviceImagedata> getdeviceImagedatas2 = getdeviceImagedataMapper.selectData2(format, format1, EQ_SN);
            model.addAttribute("getdeviceImagedatas", getdeviceImagedatas2);
            return new ModelAndView("tupian3", "tupiant3Model", model);
        } else {
            model.addAttribute("getdeviceImagedatas", getdeviceImagedatas);
        }
        return new ModelAndView("tupian3", "tupiant3Model", model);
    }

    //图片
    @RequestMapping(value = "/data2")
    public ModelAndView data2(Model model, String data, String EQ_SN, HttpSession session) throws MyException, ParseException {
        Object ss = session.getAttribute("ss");
        String sss = ss.toString();
        long now = System.currentTimeMillis();
        Date dates = new Date();
        dates.setTime(now);
        String formats = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(dates);
        String date = data;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//24小时制
        long time = simpleDateFormat.parse(date).getTime();
        Date date3 = new Date();
        date3.setTime(time);
        String format3 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date3);
        Date date1 = new Date();
        date1.setTime(time + 86400000);
        String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
        List<GetdeviceImagedata> str = getdeviceImagedataMapper.selectAllData(format3, format1, sss);
        if (str.size() == 0) {
            List<GetdeviceImagedata> strings = getdeviceImagedataMapper.selectAllData2(format3, format1, sss);
            model.addAttribute("lists", strings);
            return new ModelAndView("tupian3", "tupiant3Model", model);
        } else {
            model.addAttribute("lists", str);
        }
        return new ModelAndView("tupian3", "tupiant3Model", model);
    }

    @RequestMapping(value = "/zhibo")
    public ModelAndView zhibo(Model model, String EQ_SN) throws MyException {
        if (EQ_SN == null) {
            throw new MyException("SN或设备序列号未获取！！！");
        }
        List<Hw_Equipment> list = hwEquipmentMapper.selectSNs(EQ_SN);
        Hw_Equipment hw_equipment = list.get(list.size() - 1);
        model.addAttribute("hw_equipment", hw_equipment);
        //1是克拉2是海康
        if (hw_equipment.getSB_CHANGJIA() == 2) {
            List<Camera> cameras = cameraMapper.selectAllsn(EQ_SN);
            Camera camera = cameras.get(cameras.size() - 1);
            if (camera.getLiveAddress() != null) {
                /*"https://open.ys7.com/ezopen/h5/iframe?url=ezopen://open.ys7.com/D76214754/1.live&autoplay=0&
                accessToken=at.0iij7rgh8f1f8tw98l83ec32ajmowu32-2o9ky921pd-0fymt09-e33nrca47"*/
                String serial = camera.getDeviceSerial();
                Integer atkeyid = camera.getATKEYID();
                Accesstoken accesstoken = accesstokenMapper.selectByID(atkeyid);
                String Token = accesstoken.getAccessToken();
                String string = "https://open.ys7.com/ezopen/h5/iframe?url=ezopen://open.ys7.com/" + serial + "/1.live&autoplay=0&accessToken=" + Token + "";

                model.addAttribute("string", string);
                model.addAttribute("camera", camera);
            } else {
                camera = cameras.get(cameras.size() - 1 - 1);
                String serial = camera.getDeviceSerial();
                Integer atkeyid = camera.getATKEYID();
                Accesstoken accesstoken = accesstokenMapper.selectByID(atkeyid);
                String Token = accesstoken.getAccessToken();
                String string = "https://open.ys7.com/ezopen/h5/iframe?url=ezopen://open.ys7.com/" + serial + "/1.live&autoplay=0&accessToken=" + Token + "";

                model.addAttribute("string", string);
                model.addAttribute("camera", camera);
            }
            return new ModelAndView("zb2", "zb3", model);

        } else if (hw_equipment.getSB_CHANGJIA() == 1) {
            List<Getliveinfo> getliveinfos = getliveinfoMapper.selectGetliveinfoSN(EQ_SN);
            Getliveinfo getliveinfo = getliveinfos.get(getliveinfos.size() - 1);
            if (getliveinfo.getGETLIVEINFO() != null) {

                model.addAttribute("getliveinfo", getliveinfo);
            } else {
                getliveinfo = getliveinfos.get(getliveinfos.size() - 1 - 1);

                model.addAttribute("getliveinfo", getliveinfo);
            }
            return new ModelAndView("zb", "zhibo", model);
        }
        return null;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView insert(HttpServletResponse response, Model model, String company_name, String SB_CHANGJIA) {
        log.info("设备添加");
        try {
            ArrayList<String> arrayList = InterfacesUtils.dop(qxpreMapper);
            List<Camera> cameras = cameraMapper.selectAll();
            for(int i=0;i<cameras.size();i++){
                arrayList.add(cameras.get(i).getDeviceSerial());
            }

            model.addAttribute("arrayList", arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public String index(Hw_Equipment hw_Equipment, Model model, String EQ_SN, Integer SB_CHANGJIA) {
        log.info("添加数据操作");
        hw_Equipment.setKEYID(hwEquipmentMapper.idPlushw_equipment());

        if (SB_CHANGJIA == 1) {
            List<String> latitudes = LatitudeInterface.dop(EQ_SN, qxpreMapper);
            List<String> longitudes = LongitudeInterface.dop(EQ_SN, qxpreMapper);
            for (String lat : latitudes) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(lat);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(lat).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        //获取data中的tags里面的sn值
                        String sn = userArray.get(i).getAsJsonObject().get("tags").getAsJsonObject().get("SN").getAsString();
                        //判断sn一致的话将纬度存进表中
                        if (sn.equals(EQ_SN)) {
                            Double latitude = userArray.get(i).getAsJsonObject().get("value").getAsDouble();
                            hw_Equipment.setEQ_LATITUDE(latitude);
                        }
                    }
                }
            }
            for (String lon : longitudes) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(lon);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(lon).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        String sn = userArray.get(i).getAsJsonObject().get("tags").getAsJsonObject().get("SN").getAsString();
                        if (sn.equals(EQ_SN)) {
                            Double longitude = userArray.get(i).getAsJsonObject().get("value").getAsDouble();
                            hw_Equipment.setEQ_LONGITUDE(longitude);
                        }
                    }
                }
            }
        }
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
        hwEquipmentMapper.del(KEYID);
        return "redirect:/list";
    }

    //感知数据
    @RequestMapping("/ganzhishuju")
    public ModelAndView gongsi(Model model,Integer keyid) {

        List<Gongsijidi> gongsijidis = hwEquipmentMapper.selectGongsijidi();
        model.addAttribute("gongsijidis", gongsijidis);

        return new ModelAndView("shujuzhanshi", "shujuzhanshi", model);
    }

    //异步标题
    @RequestMapping("/yibnbiaoti")
    public void biaoti(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);

            //获取公司基地
            Gongsijidi gongsijidis2 = hwEquipmentMapper.selectGongsijidiKEYID(s);
            JSONObject json = JSONObject.fromObject(gongsijidis2);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;character=utf-8");
            response.getWriter().println(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //异步视频
    @RequestMapping("/yibuShipin")
    public void yibu(Model model, Integer KEYID, HttpServletResponse response) {
        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象视频资源
            List<Getliveinfo> getliveinfos = getliveinfoMapper.selectGetliveinfoSN(s);
            if (getliveinfos.size() != 0) {
                //获取最新直播数据
                Getliveinfo getliveinfo = getliveinfos.get(getliveinfos.size() - 1);
                JSONObject json = JSONObject.fromObject(getliveinfo);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Camera cameras = cameraMapper.selectCameraSN(s);
                JSONObject json = JSONObject.fromObject(cameras);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //图片
    @RequestMapping("/yibutupian")
    public void yibutupian(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象图片
            //获取当前日期
            long now = System.currentTimeMillis();
            Date date = new Date();
            date.setTime(now);
            String format = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
            //获取后一天图片
            Date date1 = new Date();
            date1.setTime(now + 86400000);
            String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
            List<String> getdeviceImagedata = getdeviceImagedataMapper.selectDatayi(format, format1, s);

            if (getdeviceImagedata.size() != 0) {
                JSONArray json = JSONArray.fromObject(getdeviceImagedata);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                List<String> getdeviceImagedata1 = getdeviceImagedataMapper.selectDatayi2(format, format1, s);
                JSONArray json = JSONArray.fromObject(getdeviceImagedata1);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //异步统计图
    @RequestMapping("/yibutongji")
    public void yibutongji(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取当前日期
            long now = System.currentTimeMillis();
            Date date = new Date();
            date.setTime(now);
            String format = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
            //获取后一天图片
            Date date1 = new Date();
            date1.setTime(now + 86400000);
            String format1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date1);
            List<Integer> lists = new ArrayList<Integer>();

            for (int i = 0; i < 13; i++) {
                lists.add(0);
            }
//温度
            List<Integer> selectwendu = temperatureMapper.selectwendu(format, format1, s);
//湿度
            List<Integer> selectshidu = atmosphericHumidityMapper.selectshidu(format, format1, s);
//风速
            List<Integer> selectfengsu = windspeedMapper.selectfengsu(format, format1, s);

//光照
            List<Integer> selectguangzhao = lightintensityMapper.selectguangzhao(format, format1, s);

//pm
            List<Integer> selectpm = pm2dot5Mapper.selectpm(format, format1, s);
//降雨
            List<Integer> selectyuliang = precipitationMapper.selectyuliang(format, format1, s);


            if (selectwendu.size() == 0 && selectshidu.size() == 0 && selectfengsu.size() == 0 && selectpm.size() == 0 && selectyuliang.size() == 0) {
                JSONObject json = new JSONObject();
                json.put("selectwendu", lists);
                json.put("selectfengsu", lists);
                json.put("selectguangzhao", lists);
                json.put("selectpm", lists);
                json.put("selectyuliang", lists);
                json.put("selectshidu", lists);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                JSONObject json = new JSONObject();
                json.put("selectwendu", selectwendu);
                json.put("selectfengsu", selectfengsu);
                json.put("selectguangzhao", selectguangzhao);
                json.put("selectpm", selectpm);
                json.put("selectyuliang", selectyuliang);
                json.put("selectshidu", selectshidu);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //异步温度
    @RequestMapping("/yibnwendu")
    public void yibu(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象温度
            List<Temperature> temperatures = temperatureMapper.selectTemperatureSN(s);
            if (temperatures.size() != 0) {
                //获取最新温度
                Temperature temperature = temperatures.get(temperatures.size() - 1);
                JSONObject json = JSONObject.fromObject(temperature);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Temperature temperature = new Temperature();
                temperature.setTEMPERATURE(0);
                JSONObject json = JSONObject.fromObject(temperature);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //异步湿度
    @RequestMapping("/yibnshidu")
    public void shidu(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<AtmosphericHumidity> atmosphericHumidities = atmosphericHumidityMapper.selectAtmosphericHumiditySN(s);
            if (atmosphericHumidities.size() != 0) {
                //获取最新直播数据
                AtmosphericHumidity atmosphericHumidity = atmosphericHumidities.get(atmosphericHumidities.size() - 1);
                JSONObject json = JSONObject.fromObject(atmosphericHumidity);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                AtmosphericHumidity atmosphericHumidity = new AtmosphericHumidity();
                atmosphericHumidity.setATMOSPHERICHUMIDTY(0);
                JSONObject json = JSONObject.fromObject(atmosphericHumidity);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //异步风速
    @RequestMapping("/yibnfengsu")
    public void fengsu(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Windspeed> windspeeds = windspeedMapper.selectWindspeedSN(s);
            if (windspeeds.size() != 0) {
                //获取最新直播数据
                Windspeed windspeed = windspeeds.get(windspeeds.size() - 1);
                JSONObject json = JSONObject.fromObject(windspeed);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Windspeed windspeed = new Windspeed();
                windspeed.setWINDSPEED(0);
                JSONObject json = JSONObject.fromObject(windspeed);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //异步风向
    @RequestMapping("/yibnfengxiang")
    public void fengxiang(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Winddirection> winddirections = winddirectionMapper.selectWinddirectionSN(s);
            if (winddirections.size() != 0) {
                //获取最新直播数据
                Winddirection winddirection = winddirections.get(winddirections.size() - 1);
                JSONObject json = JSONObject.fromObject(winddirection);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Winddirection winddirection = new Winddirection();
                winddirection.setWINDDIRECTION(0);
                JSONObject json = JSONObject.fromObject(winddirection);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //异步PM2.5
    @RequestMapping("/yibnpm")
    public void pm(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Pm2dot5> pm2dot5s = pm2dot5Mapper.selectPm2dot5SN(s);
            if (pm2dot5s.size() != 0) {
                //获取最新直播数据
                Pm2dot5 pm2dot5 = pm2dot5s.get(pm2dot5s.size() - 1);
                JSONObject json = JSONObject.fromObject(pm2dot5);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Pm2dot5 pm2dot5 = new Pm2dot5();
                pm2dot5.setPM2DOT5(0);
                JSONObject json = JSONObject.fromObject(pm2dot5);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //异步光照
    @RequestMapping("/yibnguangzhao")
    public void guangzhao(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Lightintensity> lightintensities = lightintensityMapper.selectLightintensitySN(s);
            if (lightintensities.size() != 0) {
                //获取最新直播数据
                Lightintensity lightintensity = lightintensities.get(lightintensities.size() - 1);
                JSONObject json = JSONObject.fromObject(lightintensity);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Lightintensity lightintensity = new Lightintensity();
                lightintensity.setLIGHTLNTENSITY(0);
                JSONObject json = JSONObject.fromObject(lightintensity);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //异步降雨量
    @RequestMapping("/yibnyuliang")
    public void yuliang(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Precipitation> precipitations = precipitationMapper.selectPrecipitationSN(s);
            if (precipitations.size() != 0) {
                //获取最新直播数据
                Precipitation precipitation = precipitations.get(precipitations.size() - 1);
                JSONObject json = JSONObject.fromObject(precipitation);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                //获取最新直播数据
                Precipitation precipitation = new Precipitation();
                precipitation.setPRECIPITATION(0);
                JSONObject json = JSONObject.fromObject(precipitation);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //异步土壤PH
    @RequestMapping("/yibnturangPH")
    public void turangPH(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Soilph> soilphs = soilphMapper.selectSoilphSN(s);

            if (soilphs.size() != 0) {
                //获取最新直播数据
                Soilph soilph = soilphs.get(soilphs.size() - 1);
                JSONObject json = JSONObject.fromObject(soilph);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Soilph soilph = new Soilph();
                soilph.setSOILPH(0);
                JSONObject json = JSONObject.fromObject(soilph);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //异步大气气压
    @RequestMapping("/yibnqiya")
    public void qiya(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Airpressure> airpressures = airpressureMapper.selectAirpressureSN(s);

            if (airpressures.size() != 0) {
                //获取最新直播数据
                Airpressure airpressure = airpressures.get(airpressures.size() - 1);
                JSONObject json = JSONObject.fromObject(airpressure);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                //获取最新直播数据
                Airpressure airpressure = new Airpressure();
                airpressure.setAIRPRESSURE(0);
                JSONObject json = JSONObject.fromObject(airpressure);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //异步海拔
    @RequestMapping("/yibnhaiba")
    public void haiba(Integer KEYID, HttpServletResponse response) {

        try {
            //获取设备对象
            String s = hwEquipmentMapper.selectoneSN(KEYID);
            //获取设备对象气象数据
            List<Altitude> altitudes = altitudeMapper.selectAltitudeSN(s);
            if (altitudes.size() != 0) {
                //获取最新直播数据
                Altitude altitude = altitudes.get(altitudes.size() - 1);
                JSONObject json = JSONObject.fromObject(altitude);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            } else {
                Altitude altitude = new Altitude();
                altitude.setALTITUDE(0);
                JSONObject json = JSONObject.fromObject(altitude);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;character=utf-8");
                response.getWriter().println(json);
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
