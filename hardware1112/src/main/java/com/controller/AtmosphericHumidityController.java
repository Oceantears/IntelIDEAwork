package com.controller;
import com.bean.AtmosphericHumidity;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.AtmosphericHumidityInterface;
import com.mapper.AtmosphericHumidityMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtmosphericHumidityController {
    private static final Logger log = LoggerFactory.getLogger(AtmosphericHumidityController.class);
    public static void dop(ArrayList<String> array, AtmosphericHumidity atm, AtmosphericHumidityMapper AtmosphericHumidityMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {

            //调用大气湿度工具类
            List<String> aa = AtmosphericHumidityInterface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
//进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {

                        atm.setKEYID(AtmosphericHumidityMapper.idPlusAtmosphericHumidity());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        atm.setAT_DATE(date);

                        atm.setATMOSPHERICHUMIDTY(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        atm.setSN(s);

                        //执行数据存入操作
                        AtmosphericHumidityMapper.insertAtmosphericHumidity(atm);
                        log.info("大气湿度数据入库成功===");
                    }
                }else{
                   /* atm.setKEYID(AtmosphericHumidityMapper.idPlusAtmosphericHumidity());
                    atm.setAT_DATE(null);
                    atm.setSN(s);
                    atm.setATMOSPHERICHUMIDTY(0);
                    AtmosphericHumidityMapper.insertAtmosphericHumidity(atm);*/

                    continue;

                }
            }

        }

    }
}
