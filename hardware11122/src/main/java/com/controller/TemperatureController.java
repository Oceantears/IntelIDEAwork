package com.controller;

import com.bean.Temperature;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.mapper.QxpreMapper;
import com.mapper.TemperatureMapper;
import com.interfaces.TemperatureInterface;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TemperatureController {
    private static final Logger log = LoggerFactory.getLogger(TemperatureController.class);

    public static void dop(ArrayList<String> array, Temperature temp, TemperatureMapper temperatureMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        for (String s : array) {
            //调用大气温度工具类
            List<String> aa = null;
            try {
                aa = TemperatureInterface.dop(s, qxpreMapper);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("大气温度请求超时！",e);
            }
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        temp.setKEYID(temperatureMapper.idPlusTemperature());
                        Date date = new Date();
                        temp.setTE_DATE(date);
                        temp.setTEMPERATURE(userArray.get(i).getAsJsonObject().get("value").getAsInt());
                        temp.setSN(s);
                        //执行数据存入操作
                        temperatureMapper.insertTemperature(temp);
                    }
                } else {
                   /* temp.setKEYID(temperatureMapper.idPlusTemperature());
                    temp.setTE_DATE(null);
                    temp.setSN(s);
                    temp.setTEMPERATURE(0);
                    temperatureMapper.insertTemperature(temp);*/
                    continue;
                }
            }
        }
    }

}
