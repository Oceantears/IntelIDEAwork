package com.controller;

import com.bean.Altitude;
import com.controllers.HwEquipmentController;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.AltitudeInterface;
import com.mapper.AltitudeMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AltitudeController {
    private static final Logger log = LoggerFactory.getLogger(AltitudeController.class);
    public static void dop(ArrayList<String> array, Altitude alt, AltitudeMapper AltitudeMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {

            //调用海拔工具类
            List<String> aa = AltitudeInterface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {

                        alt.setKEYID(AltitudeMapper.idPlusAltitude());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        alt.setAL_DATE(date);

                        alt.setALTITUDE(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        alt.setSN(s);
                        //执行数据存入操作
                        AltitudeMapper.insertAltitude(alt);
                        log.info("海拔数据入库成功===");

                    }
                }else{
                   /*alt.setKEYID(AltitudeMapper.idPlusAltitude());
                    alt.setAL_DATE(null);
                    alt.setSN(s);
                    alt.setALTITUDE(0);
                    AltitudeMapper.insertAltitude(alt);*/

                    continue;

                }
            }

        }

    }
}
