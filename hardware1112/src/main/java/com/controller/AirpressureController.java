package com.controller;

import com.bean.Airpressure;
import com.controllers.HwEquipmentController;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.mapper.AirpressureMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AirpressureController {
    private static final Logger log = LoggerFactory.getLogger(AirpressureController.class);
    public  static void dop(ArrayList<String> array,ArrayList<String> arrayt, Airpressure air,AirpressureMapper AirpressureMapper,QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {

            //调用大气压力工具类
            List<String> aa = AirpressureInterface.dop(s, qxpreMapper);
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);

                //进行主体信息判断是否存在data
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        air.setKEYID(AirpressureMapper.idPlusAirpressure());
                        Date date = new Date(System.currentTimeMillis()+28800000);
                        air.setAI_DATE(date);

                        air.setAIRPRESSURE(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        air.setSN(s);

                        //执行数据存入操作
                        AirpressureMapper.insertAirpressure(air);
                        log.info("大气气压数据入库成功===");

                    }
                }else{
                    /*air.setKEYID(AirpressureMapper.idPlusAirpressure());
                    air.setAI_DATE(null);
                    air.setSN(s);
                    air.setAIRPRESSURE(0);
                    AirpressureMapper.insertAirpressure(air);*/

                    continue;


                }

            }



        }

    }
}
