package com.controller;

import com.bean.Precipitation;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.interfaces.AirpressureInterface;
import com.interfaces.PrecipitationInterface;
import com.mapper.PrecipitationMapper;
import com.mapper.QxpreMapper;
import com.utils.InterfacesUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrecipitationController {
    private static final Logger log = LoggerFactory.getLogger(PrecipitationController.class);

    public static void dop(ArrayList<String> array, Precipitation pre, PrecipitationMapper PrecipitationMapper, QxpreMapper qxpreMapper) throws IOException {
        array = InterfacesUtils.dop(qxpreMapper);
        //进行设备SN迭代
        for (String s : array) {
            //调用雨量工具类
            List<String> aa = null;
            try {
                aa = PrecipitationInterface.dop(s, qxpreMapper);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("雨量请求超时！",e);
            }
            for (String a : aa) {
                //接受json data数组
                JSONObject jb = JSONObject.fromObject(a);
                //进行主体信息判断是否存在data
                if (jb.containsKey("data")) {
                    //data数组
                    JsonArray userArray = new JsonParser().parse(a).getAsJsonObject().get("data").getAsJsonArray();
                    for (int i = 0; i < userArray.size(); i++) {
                        pre.setKEYID(PrecipitationMapper.idPlusPrecipitation());
                        Date date = new Date();
                        pre.setPR_DATE(date);
                        pre.setPRECIPITATION(userArray.get(i).getAsJsonObject().get("value").getAsDouble());
                        pre.setSN(s);
                        //执行数据存入操作
                        PrecipitationMapper.insertPrecipitation(pre);
                    }
                } else {
                    /*pre.setKEYID(PrecipitationMapper.idPlusPrecipitation());
                    pre.setPR_DATE(null);
                    pre.setSN(s);
                    pre.setPRECIPITATION(0);
                    PrecipitationMapper.insertPrecipitation(pre);*/
                    continue;
                }
            }
        }
    }

}
