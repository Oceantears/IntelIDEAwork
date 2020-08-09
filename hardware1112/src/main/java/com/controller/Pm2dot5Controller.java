package com.controller;

import com.bean.Pm2dot5;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.Pm2dot5Interface;
import com.mapper.Pm2dot5Mapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pm2dot5Controller {
    private static final Logger log = LoggerFactory.getLogger(Pm2dot5Controller.class);
    public static void dop(ArrayList<String> array, Pm2dot5 pm, Pm2dot5Mapper pm2dot5Mapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {
            System.out.println(s);
            //调用PM2.5工具类
            List<String> aa = Pm2dot5Interface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
//进行主体信息判断是否存在data

                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        pm.setKEYID(pm2dot5Mapper.idPlusPm2dot5());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        pm.setPM_DATE(date);
                        pm.setPM2DOT5(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        pm.setSN(s);
                        //执行数据存入操作
                        pm2dot5Mapper.insertPm2dot5(pm);
                        log.info("PM2.5数据入库成功===");

                    }
                }else{
                  /* pm.setKEYID(pm2dot5Mapper.idPlusPm2dot5());
                    pm.setPM_DATE(null);
                    pm.setSN(s);
                    pm.setPM2DOT5(0);
                    pm2dot5Mapper.insertPm2dot5(pm);*/

                    continue;
                }

            }
        }

    }

}
