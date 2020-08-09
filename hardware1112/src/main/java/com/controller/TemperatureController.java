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
            System.out.println(s);
            //调用大气温度工具类
            List<String> aa = TemperatureInterface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
//进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        temp.setKEYID(temperatureMapper.idPlusTemperature());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        temp.setTE_DATE(date);
                        temp.setTEMPERATURE(userArray.get(i).getAsJsonObject().get("value").getAsInt());
                        temp.setSN(s);
                        //执行数据存入操作
                        temperatureMapper.insertTemperature(temp);
                        log.info("大气温度数据入库成功===-----");

                    }
                }else{
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
/*//使用递归进行解析JSON数据
    public static void getAllKy1(JSONObject jsonObject, String SN, ArrayList<String> array) {
        //TemperatureMapper temperatureMapper =new TemperatureMapper();
        //TemperatureServiceimpl temperatureServiceimpl=new TemperatureServiceimpl();
        Temperature temperature = new Temperature();
        Iterator<String> keys = jsonObject.keySet().iterator();// jsonObject.keys();
        while (keys.hasNext()) {

            String key = keys.next();
            if (key.equals("SN")) {
                array.add(jsonObject.getString(key));
                System.out.println(key.toString() + "---" + jsonObject.getString(key));
            }
            if (jsonObject.get(key) instanceof JSONObject) {
                JSONObject innerObject = (JSONObject) jsonObject.get(key);
                getAllKy1(innerObject, SN, array);
            } else if (jsonObject.get(key) instanceof JSONArray) {
                JSONArray innerObject = (JSONArray) jsonObject.get(key);
                getAllKey2(innerObject, SN, array);
            }
        }
    }

    public static void getAllKey2(JSONArray json1, String SN, ArrayList<String> array) {
        StringBuffer stringBuffer = new StringBuffer();
        if (json1 != null) {
            Iterator i1 = json1.iterator();
            while (i1.hasNext()) {
                Object key = i1.next();
                if (key instanceof JSONObject) {
                    JSONObject innerObject = (JSONObject) key;
                    getAllKy1(innerObject, SN, array);
                } else if (key instanceof JSONArray) {
                    JSONArray innerObject = (JSONArray) key;
                    getAllKey2(innerObject, SN, array);
                }
            }
        }
    }*/
    /*===================================================================大气温度=================================================================================*/



}
