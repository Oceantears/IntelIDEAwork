package com.controller;

import com.bean.Latitude;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.LatitudeInterface;
import com.mapper.LatitudeMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LatitudeController {
    private static final Logger log = LoggerFactory.getLogger(LatitudeController.class);
    public static void dop(ArrayList<String> array, Latitude lat, LatitudeMapper latitudeMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {

            //调用大气温度工具类
            List<String> aa = LatitudeInterface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
//进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {

                        lat.setKEYID(latitudeMapper.idPlusLatitude());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        lat.setLA_DATE(date);
                        Double dou=userArray.get(i).getAsJsonObject().get("value").getAsDouble();
                        lat.setLATITUDE(dou);
                        lat.setSN(s);
                        //执行数据存入操作
                        latitudeMapper.insertLatitude(lat);
                        log.info("纬度数据入库成功===");

                    }
                }else{
                   /*lat.setKEYID(latitudeMapper.idPlusLatitude());
                    lat.setLA_DATE(null);
                    lat.setSN(s);
                    lat.setLATITUDE(0);
                    latitudeMapper.insertLatitude(lat);*/

                    continue;

                }
            }
        }

    }

}
