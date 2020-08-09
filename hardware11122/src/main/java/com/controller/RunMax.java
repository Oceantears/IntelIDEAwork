package com.controller;

import com.bean.*;
import com.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class RunMax {
    //mysql接口层-大气温度
    @Resource
    TemperatureMapper temperatureMapper;
    //mysql接口层-光照强度
    @Resource
    LightintensityMapper lightintensityMapper;
    //mysql接口层-经度
    @Resource
    LongitudeMapper longitudeMapper;
    //mysql接口层-纬度
    @Resource
    LatitudeMapper latitudeMapper;
    //mysql接口层-大气气压
    @Resource
    AirpressureMapper airpressureMapper;
    //mysql接口层-大气湿度
    @Resource
    AtmosphericHumidityMapper atmosphericHumidityMapper;
    //mysql接口层-海拔
    @Resource
    AltitudeMapper altitudeMapper;
    //mysql接口层-图片
    @Resource
    GetdeviceImagedataMapper getdeviceImagedataMapper;
    //mysql接口层-视频
    @Resource
    GetliveinfoMapper getliveinfoMapper;
    //mysql接口层-降雨量
    @Resource
    PrecipitationMapper precipitationMapper;
    //mysql接口层-风向
    @Resource
    WinddirectionMapper winddirectionMapper;
    //mysql接口层-风速
    @Resource
    WindspeedMapper windspeedMapper;
    //mysql接口层-土壤ph
    @Resource
    SoilphMapper soilphMapper;
    //mysql接口层-pm2.5
    @Resource
    Pm2dot5Mapper pm2dot5Mapper;
    @Resource
    CameraMapper cameraMapper;
    @Resource
    AccesstokenMapper accesstokenMapper;
    @Resource
    DemosMapper demosMapper;
    @Resource
    QxpreMapper qxpreMapper;
    private static final Logger log = LoggerFactory.getLogger(RunMax.class);

    @RequestMapping(value = "/addrun")

    public void runs(Camera cam, Accesstoken acc, Pm2dot5 pm, Temperature temp, Lightintensity lig, Longitude lon, Latitude lat, Airpressure air, AtmosphericHumidity atm, Altitude alt, GetdeviceImagedata ge, Getliveinfo gef, Precipitation pre, Winddirection win, Windspeed wi, Soilph so, Demos d) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Boolean result = false;
        int count = 0;
        while (true)
            try {
                CameraController.Camera(cam, cameraMapper, accesstokenMapper);
                //光照强度数据抓取
                ArrayList<String> array2 = new ArrayList<String>();
                LightintensityController.dop(array2, lig, lightintensityMapper, qxpreMapper);
                //经度数据抓取
                //ArrayList<String> array3=new ArrayList<String>();
                //LongitudeController.dop(array3,lon,longitudeMapper);
                //纬度数据抓取
                //ArrayList<String> array4=new ArrayList<String>();
                //LatitudeController.dop(array4,lat,latitudeMapper);
                //大气气压数据抓取
                ArrayList<String> array5 = new ArrayList<String>();
                ArrayList<String> array55 = new ArrayList<String>();
                AirpressureController.dop(array5, array55, air, airpressureMapper, qxpreMapper);
                //大气湿度数据抓取
                ArrayList<String> array6 = new ArrayList<String>();
                AtmosphericHumidityController.dop(array6, atm, atmosphericHumidityMapper, qxpreMapper);
                //海拔数据抓取
                ArrayList<String> array7 = new ArrayList<String>();
                AltitudeController.dop(array7, alt, altitudeMapper, qxpreMapper);
                //气象站图片数据抓取
                ArrayList<String> array8 = new ArrayList<String>();
                GetdeviceImagedataControllerTow.dop(array8, ge, getdeviceImagedataMapper, qxpreMapper);
                try {
                    //图片数据抓取
                    GetdeviceImagedataController.dop(ge, getdeviceImagedataMapper, cameraMapper, accesstokenMapper);
                } catch (SocketTimeoutException exception) {
                    exception.printStackTrace();
                    log.info("图片获取超时！！！");
                }
                //视频数据抓取
                ArrayList<String> array9 = new ArrayList<String>();
                GetliveinfoController.dop(array9, gef, getliveinfoMapper, qxpreMapper);
                //降雨量数据抓取
                ArrayList<String> array10 = new ArrayList<String>();
                PrecipitationController.dop(array10, pre, precipitationMapper, qxpreMapper);
                //风向数据抓取
                ArrayList<String> array11 = new ArrayList<String>();
                WinddirectionController.dop(array11, win, winddirectionMapper, qxpreMapper);
                //风速数据抓取
                ArrayList<String> array12 = new ArrayList<String>();
                WindspeedController.dop(array12, wi, windspeedMapper, qxpreMapper);
                //土壤ph数据抓取
                ArrayList<String> array13 = new ArrayList<String>();
                SoilphController.dop(array13, so, soilphMapper, qxpreMapper);
                //pm2.5数据抓取
                ArrayList<String> array14 = new ArrayList<String>();
                Pm2dot5Controller.dop(array14, pm, pm2dot5Mapper, qxpreMapper);
                //大气温度数据抓取
                ArrayList<String> array1 = new ArrayList<String>();
                TemperatureController.dop(array1, temp, temperatureMapper, qxpreMapper);
                AaController.demo(altitudeMapper, pm2dot5Mapper, getdeviceImagedataMapper, getliveinfoMapper, winddirectionMapper, windspeedMapper, soilphMapper, temperatureMapper, atmosphericHumidityMapper, lightintensityMapper, demosMapper, airpressureMapper, precipitationMapper, qxpreMapper, d);
                log.info("数据汇总成功===-----");
                count++;
                log.info(sdf.format(new Date()) + "--循环执行第" + count + "次");
                Thread.sleep(7200* 1000); //设置暂停的时间 2 小时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}

