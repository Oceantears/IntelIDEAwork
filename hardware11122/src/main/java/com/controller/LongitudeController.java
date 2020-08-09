package com.controller;

import com.bean.Longitude;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.LongitudeInterface;
import com.mapper.LongitudeMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LongitudeController {
    private static final Logger log = LoggerFactory.getLogger(LongitudeController.class);

    public static void dop(ArrayList<String> array, Longitude lon, LongitudeMapper longitudeMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {
            //调用经度工具类
            List<String> aa = null;
            try {
                aa = LongitudeInterface.dop(s, qxpreMapper);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("经度请求超时！",e);
            }
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        lon.setKEYID(longitudeMapper.idPlusLongitude());
                        Date date = new Date();
                        lon.setLO_DATE(date);
                        Double dou = userArray.get(i).getAsJsonObject().get("value").getAsDouble();
                        lon.setLONGITUDE(dou);
                        lon.setSN(s);
                        //执行数据存入操作
                        longitudeMapper.insertLongitude(lon);
                    }
                } else {
                  /* lon.setKEYID(longitudeMapper.idPlusLongitude());
                    lon.setLO_DATE(null);
                    lon.setSN(s);
                    lon.setLONGITUDE(0);
                    longitudeMapper.insertLongitude(lon);
*/
                    continue;
                }

            }
        }
    }

}
