package com.controller;

import com.bean.Lightintensity;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.LightintensityInterface;
import com.mapper.LightintensityMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LightintensityController {

    private static final Logger log = LoggerFactory.getLogger(LightintensityController.class);

    public static void dop(ArrayList<String> array, Lightintensity lig, LightintensityMapper lightintensityMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);


        //进行设备SN迭代
        for (String s : array) {
            //调用光照强度工具类
            List<String> aa = null;
            try {
                aa = LightintensityInterface.dop(s, qxpreMapper);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("光照强度请求超时！", e);
            }
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        lig.setKEYID(lightintensityMapper.idPlusLightintensity());
                        Date date = new Date();
                        lig.setLI_DATE(date);
                        Double dou = userArray.get(i).getAsJsonObject().get("value").getAsDouble();
                        lig.setLIGHTLNTENSITY(dou);
                        lig.setSN(s);
                        //执行数据存入操作
                        lightintensityMapper.insertLightintensity(lig);
                    }

                } else {
                    /*lig.setKEYID(lightintensityMapper.idPlusLightintensity());
                    lig.setLI_DATE(null);
                    lig.setSN(s);
                    lig.setLIGHTLNTENSITY(0);
                    lightintensityMapper.insertLightintensity(lig);*/
                    continue;
                }
            }
        }
    }

}
