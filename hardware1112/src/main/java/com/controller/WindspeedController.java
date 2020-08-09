package com.controller;

import com.bean.Windspeed;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.WindspeedInterface;
import com.mapper.QxpreMapper;
import com.mapper.WindspeedMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WindspeedController {
    private static final Logger log = LoggerFactory.getLogger(WindspeedController.class);
    public static void dop(ArrayList<String> array, Windspeed win, WindspeedMapper WindspeedMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {
            System.out.println(s);
            //调用风速工具类
            List<String> aa = WindspeedInterface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
//进行主体信息判断是否存在data

                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {

                        win.setKEYID(WindspeedMapper.idPlusWindspeed());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        win.setWI_DATE(date);
                        win.setWINDSPEED(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        win.setSN(s);
                        //执行数据存入操作
                        WindspeedMapper.insertWindspeed(win);
                        log.info("风速数据入库成功===-----");
                    }
                }else{
                /*  win.setKEYID(WindspeedMapper.idPlusWindspeed());
                    win.setWI_DATE(null);
                    win.setSN(s);
                    win.setWINDSPEED(0);
                    WindspeedMapper.insertWindspeed(win);*/

                    continue;


                }
            }

        }

    }


}
